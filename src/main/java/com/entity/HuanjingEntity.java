package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 小区环境
 *
 * @author 
 * @email
 */
@TableName("huanjing")
public class HuanjingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuanjingEntity() {

	}

	public HuanjingEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 环境名称
     */
    @TableField(value = "huanjing_name")

    private String huanjingName;


    /**
     * 环境图片
     */
    @TableField(value = "huanjing_photo")

    private String huanjingPhoto;


    /**
     * 环境类型
     */
    @TableField(value = "huanjing_types")

    private Integer huanjingTypes;


    /**
     * 环境详情
     */
    @TableField(value = "huanjing_content")

    private String huanjingContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：环境名称
	 */
    public String getHuanjingName() {
        return huanjingName;
    }


    /**
	 * 获取：环境名称
	 */

    public void setHuanjingName(String huanjingName) {
        this.huanjingName = huanjingName;
    }
    /**
	 * 设置：环境图片
	 */
    public String getHuanjingPhoto() {
        return huanjingPhoto;
    }


    /**
	 * 获取：环境图片
	 */

    public void setHuanjingPhoto(String huanjingPhoto) {
        this.huanjingPhoto = huanjingPhoto;
    }
    /**
	 * 设置：环境类型
	 */
    public Integer getHuanjingTypes() {
        return huanjingTypes;
    }


    /**
	 * 获取：环境类型
	 */

    public void setHuanjingTypes(Integer huanjingTypes) {
        this.huanjingTypes = huanjingTypes;
    }
    /**
	 * 设置：环境详情
	 */
    public String getHuanjingContent() {
        return huanjingContent;
    }


    /**
	 * 获取：环境详情
	 */

    public void setHuanjingContent(String huanjingContent) {
        this.huanjingContent = huanjingContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huanjing{" +
            "id=" + id +
            ", huanjingName=" + huanjingName +
            ", huanjingPhoto=" + huanjingPhoto +
            ", huanjingTypes=" + huanjingTypes +
            ", huanjingContent=" + huanjingContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
