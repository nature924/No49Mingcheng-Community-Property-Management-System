package com.entity.view;

import com.entity.BaoxiuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 报修
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("baoxiu")
public class BaoxiuView extends BaoxiuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 报修类型的值
		*/
		private String baoxiuValue;
		/**
		* 是否维修的值
		*/
		private String baoxiuWeixiuValue;



		//级联表 yonghu
			/**
			* 住户姓名
			*/
			private String yonghuName;
			/**
			* 住户手机号
			*/
			private String yonghuPhone;
			/**
			* 住户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 住户照片
			*/
			private String yonghuPhoto;
			/**
			* 余额
			*/
			private Double newMoney;

		//级联表 yuangong
			/**
			* 员工姓名
			*/
			private String yuangongName;
			/**
			* 员工手机号
			*/
			private String yuangongPhone;
			/**
			* 员工身份证号
			*/
			private String yuangongIdNumber;
			/**
			* 员工照片
			*/
			private String yuangongPhoto;

	public BaoxiuView() {

	}

	public BaoxiuView(BaoxiuEntity baoxiuEntity) {
		try {
			BeanUtils.copyProperties(this, baoxiuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 报修类型的值
			*/
			public String getBaoxiuValue() {
				return baoxiuValue;
			}
			/**
			* 设置： 报修类型的值
			*/
			public void setBaoxiuValue(String baoxiuValue) {
				this.baoxiuValue = baoxiuValue;
			}
			/**
			* 获取： 是否维修的值
			*/
			public String getBaoxiuWeixiuValue() {
				return baoxiuWeixiuValue;
			}
			/**
			* 设置： 是否维修的值
			*/
			public void setBaoxiuWeixiuValue(String baoxiuWeixiuValue) {
				this.baoxiuWeixiuValue = baoxiuWeixiuValue;
			}































				//级联表的get和set yonghu
					/**
					* 获取： 住户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 住户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 住户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 住户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 住户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 住户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 住户照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 住户照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}




				//级联表的get和set yuangong
					/**
					* 获取： 员工姓名
					*/
					public String getYuangongName() {
						return yuangongName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYuangongName(String yuangongName) {
						this.yuangongName = yuangongName;
					}
					/**
					* 获取： 员工手机号
					*/
					public String getYuangongPhone() {
						return yuangongPhone;
					}
					/**
					* 设置： 员工手机号
					*/
					public void setYuangongPhone(String yuangongPhone) {
						this.yuangongPhone = yuangongPhone;
					}
					/**
					* 获取： 员工身份证号
					*/
					public String getYuangongIdNumber() {
						return yuangongIdNumber;
					}
					/**
					* 设置： 员工身份证号
					*/
					public void setYuangongIdNumber(String yuangongIdNumber) {
						this.yuangongIdNumber = yuangongIdNumber;
					}
					/**
					* 获取： 员工照片
					*/
					public String getYuangongPhoto() {
						return yuangongPhoto;
					}
					/**
					* 设置： 员工照片
					*/
					public void setYuangongPhoto(String yuangongPhoto) {
						this.yuangongPhoto = yuangongPhoto;
					}



}
