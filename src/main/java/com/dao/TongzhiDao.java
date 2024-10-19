package com.dao;

import com.entity.TongzhiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.TongzhiView;

/**
 * 通知 Dao 接口
 *
 * @author 
 */
public interface TongzhiDao extends BaseMapper<TongzhiEntity> {

   List<TongzhiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
