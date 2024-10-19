












package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 缴费
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaofei")
public class JiaofeiController {
    private static final Logger logger = LoggerFactory.getLogger(JiaofeiController.class);

    @Autowired
    private JiaofeiService jiaofeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private FangwuService fangwuService;

    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("住户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiaofeiService.queryPage(params);

        //字典表数据转换
        List<JiaofeiView> list =(List<JiaofeiView>)page.getList();
        for(JiaofeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaofeiEntity jiaofei = jiaofeiService.selectById(id);
        if(jiaofei !=null){
            //entity转view
            JiaofeiView view = new JiaofeiView();
            BeanUtils.copyProperties( jiaofei , view );//把实体数据重构到view中

                //级联表
                FangwuEntity fangwu = fangwuService.selectById(jiaofei.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }



    /**
     * 缴费接口
     */
    @RequestMapping("/jiaofei/{id}")
    public R jiaofei(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("jiaofei方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("住户".equals(role)){
            JiaofeiEntity jiaofei = jiaofeiService.selectById(id);
            if(jiaofei !=null){

                Integer userid = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
                YonghuEntity yonghuEntity = yonghuService.selectById(userid);
                if(yonghuEntity == null){
                    return R.error(511,"查不到当前账户");
                }
                Double newMoney = yonghuEntity.getNewMoney();
                if(newMoney == null || (newMoney-jiaofei.getNewMoney())<0){
                    return R.error(511,"当前账户余额不够缴费，请去前台充值金额");
                }
                yonghuEntity.setNewMoney(newMoney-jiaofei.getNewMoney());
                jiaofei.setJiaofeiShifouTypes(2);
                jiaofeiService.updateById(jiaofei);
                yonghuService.updateById(yonghuEntity);
                return R.ok();
            }else {
                return R.error(511,"查不到要缴费的数据");
            }
        }else {
            return R.error(511,"您没有权限缴费");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaofeiEntity jiaofei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaofei:{}",this.getClass().getName(),jiaofei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<JiaofeiEntity> queryWrapper = new EntityWrapper<JiaofeiEntity>()
            .eq("fangwu_id", jiaofei.getFangwuId())
            .eq("jiaofei_name", jiaofei.getJiaofeiName())
            .eq("jiaofei_yuefen", jiaofei.getJiaofeiYuefen())
            .eq("jiaofei_types", jiaofei.getJiaofeiTypes())
//            .eq("jiaofei_shifou_types", jiaofei.getJiaofeiShifouTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeiEntity jiaofeiEntity = jiaofeiService.selectOne(queryWrapper);
        if(jiaofeiEntity==null){
            jiaofei.setInsertTime(new Date());
            jiaofei.setCreateTime(new Date());
            jiaofeiService.insert(jiaofei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaofeiEntity jiaofei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaofei:{}",this.getClass().getName(),jiaofei.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<JiaofeiEntity> queryWrapper = new EntityWrapper<JiaofeiEntity>()
            .notIn("id",jiaofei.getId())
            .andNew()
            .eq("fangwu_id", jiaofei.getFangwuId())
            .eq("jiaofei_name", jiaofei.getJiaofeiName())
            .eq("jiaofei_yuefen", jiaofei.getJiaofeiYuefen())
            .eq("jiaofei_types", jiaofei.getJiaofeiTypes())
//            .eq("jiaofei_shifou_types", jiaofei.getJiaofeiShifouTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeiEntity jiaofeiEntity = jiaofeiService.selectOne(queryWrapper);
        if(jiaofeiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jiaofei.set
            //  }
            jiaofeiService.updateById(jiaofei);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jiaofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<JiaofeiEntity> jiaofeiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiaofeiEntity jiaofeiEntity = new JiaofeiEntity();
//                            jiaofeiEntity.setFangwuId(Integer.valueOf(data.get(0)));   //房源 要改的
//                            jiaofeiEntity.setJiaofeiName(data.get(0));                    //缴费名称 要改的
//                            jiaofeiEntity.setJiaofeiYuefen(data.get(0));                    //缴费月份 要改的
//                            jiaofeiEntity.setJiaofeiTypes(Integer.valueOf(data.get(0)));   //缴费类型 要改的
//                            jiaofeiEntity.setNewMoney(data.get(0));                    //缴费金额 要改的
//                            jiaofeiEntity.setJiaofeiContent("");//照片
//                            jiaofeiEntity.setJiaofeiShifouTypes(Integer.valueOf(data.get(0)));   //是否缴费 要改的
//                            jiaofeiEntity.setInsertTime(date);//时间
//                            jiaofeiEntity.setCreateTime(date);//时间
                            jiaofeiList.add(jiaofeiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        jiaofeiService.insertBatch(jiaofeiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = jiaofeiService.queryPage(params);

        //字典表数据转换
        List<JiaofeiView> list =(List<JiaofeiView>)page.getList();
        for(JiaofeiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaofeiEntity jiaofei = jiaofeiService.selectById(id);
            if(jiaofei !=null){


                //entity转view
                JiaofeiView view = new JiaofeiView();
                BeanUtils.copyProperties( jiaofei , view );//把实体数据重构到view中

                //级联表
                    FangwuEntity fangwu = fangwuService.selectById(jiaofei.getFangwuId());
                if(fangwu != null){
                    BeanUtils.copyProperties( fangwu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangwuId(fangwu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiaofeiEntity jiaofei, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiaofei:{}",this.getClass().getName(),jiaofei.toString());
        Wrapper<JiaofeiEntity> queryWrapper = new EntityWrapper<JiaofeiEntity>()
            .eq("fangwu_id", jiaofei.getFangwuId())
            .eq("jiaofei_name", jiaofei.getJiaofeiName())
            .eq("jiaofei_yuefen", jiaofei.getJiaofeiYuefen())
            .eq("jiaofei_types", jiaofei.getJiaofeiTypes())
            .eq("jiaofei_shifou_types", jiaofei.getJiaofeiShifouTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaofeiEntity jiaofeiEntity = jiaofeiService.selectOne(queryWrapper);
        if(jiaofeiEntity==null){
            jiaofei.setInsertTime(new Date());
            jiaofei.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jiaofei.set
        //  }
        jiaofeiService.insert(jiaofei);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



}
