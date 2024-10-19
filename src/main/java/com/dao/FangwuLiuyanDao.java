package com.dao;

import com.entity.FangwuLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.FangwuLiuyanView;

/**
 * 房屋留言 Dao 接口
 *
 * @author 
 */
public interface FangwuLiuyanDao extends BaseMapper<FangwuLiuyanEntity> {

   List<FangwuLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
