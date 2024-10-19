package com.entity.view;

import com.entity.FangwuLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 房屋留言
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangwu_liuyan")
public class FangwuLiuyanView extends FangwuLiuyanEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 fangwu
			/**
			* 房屋名称
			*/
			private String fangwuName;
			/**
			* 房屋地址
			*/
			private String fangwuAddress;
			/**
			* 房屋照片
			*/
			private String fangwuPhoto;
			/**
			* 房屋类型
			*/
			private Integer fangwuTypes;
				/**
				* 房屋类型的值
				*/
				private String fangwuValue;
			/**
			* 逻辑删除
			*/
			private Integer fangwuDelete;
			/**
			* 房屋详情
			*/
			private String fangwuContent;

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

	public FangwuLiuyanView() {

	}

	public FangwuLiuyanView(FangwuLiuyanEntity fangwuLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, fangwuLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













				//级联表的get和set fangwu
					/**
					* 获取： 房屋名称
					*/
					public String getFangwuName() {
						return fangwuName;
					}
					/**
					* 设置： 房屋名称
					*/
					public void setFangwuName(String fangwuName) {
						this.fangwuName = fangwuName;
					}
					/**
					* 获取： 房屋地址
					*/
					public String getFangwuAddress() {
						return fangwuAddress;
					}
					/**
					* 设置： 房屋地址
					*/
					public void setFangwuAddress(String fangwuAddress) {
						this.fangwuAddress = fangwuAddress;
					}
					/**
					* 获取： 房屋照片
					*/
					public String getFangwuPhoto() {
						return fangwuPhoto;
					}
					/**
					* 设置： 房屋照片
					*/
					public void setFangwuPhoto(String fangwuPhoto) {
						this.fangwuPhoto = fangwuPhoto;
					}
					/**
					* 获取： 房屋类型
					*/
					public Integer getFangwuTypes() {
						return fangwuTypes;
					}
					/**
					* 设置： 房屋类型
					*/
					public void setFangwuTypes(Integer fangwuTypes) {
						this.fangwuTypes = fangwuTypes;
					}


						/**
						* 获取： 房屋类型的值
						*/
						public String getFangwuValue() {
							return fangwuValue;
						}
						/**
						* 设置： 房屋类型的值
						*/
						public void setFangwuValue(String fangwuValue) {
							this.fangwuValue = fangwuValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getFangwuDelete() {
						return fangwuDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setFangwuDelete(Integer fangwuDelete) {
						this.fangwuDelete = fangwuDelete;
					}
					/**
					* 获取： 房屋详情
					*/
					public String getFangwuContent() {
						return fangwuContent;
					}
					/**
					* 设置： 房屋详情
					*/
					public void setFangwuContent(String fangwuContent) {
						this.fangwuContent = fangwuContent;
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






}
