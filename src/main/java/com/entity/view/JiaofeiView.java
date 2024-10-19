package com.entity.view;

import com.entity.JiaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 缴费
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaofei")
public class JiaofeiView extends JiaofeiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 缴费类型的值
		*/
		private String jiaofeiValue;
		/**
		* 是否缴费的值
		*/
		private String jiaofeiShifouValue;



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

	public JiaofeiView() {

	}

	public JiaofeiView(JiaofeiEntity jiaofeiEntity) {
		try {
			BeanUtils.copyProperties(this, jiaofeiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 缴费类型的值
			*/
			public String getJiaofeiValue() {
				return jiaofeiValue;
			}
			/**
			* 设置： 缴费类型的值
			*/
			public void setJiaofeiValue(String jiaofeiValue) {
				this.jiaofeiValue = jiaofeiValue;
			}
			/**
			* 获取： 是否缴费的值
			*/
			public String getJiaofeiShifouValue() {
				return jiaofeiShifouValue;
			}
			/**
			* 设置： 是否缴费的值
			*/
			public void setJiaofeiShifouValue(String jiaofeiShifouValue) {
				this.jiaofeiShifouValue = jiaofeiShifouValue;
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


















}
