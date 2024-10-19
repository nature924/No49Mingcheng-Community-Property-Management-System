package com.dao;

import com.entity.HuanjingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuanjingView;

/**
 * 小区环境 Dao 接口
 *
 * @author 
 */
public interface HuanjingDao extends BaseMapper<HuanjingEntity> {

   List<HuanjingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
