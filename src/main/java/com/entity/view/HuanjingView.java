package com.entity.view;

import com.entity.HuanjingEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 小区环境
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("huanjing")
public class HuanjingView extends HuanjingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 环境类型的值
		*/
		private String huanjingValue;



	public HuanjingView() {

	}

	public HuanjingView(HuanjingEntity huanjingEntity) {
		try {
			BeanUtils.copyProperties(this, huanjingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 环境类型的值
			*/
			public String getHuanjingValue() {
				return huanjingValue;
			}
			/**
			* 设置： 环境类型的值
			*/
			public void setHuanjingValue(String huanjingValue) {
				this.huanjingValue = huanjingValue;
			}














}
