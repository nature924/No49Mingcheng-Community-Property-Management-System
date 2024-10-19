package com.entity.model;

import com.entity.HuanjingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 小区环境
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuanjingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 环境名称
     */
    private String huanjingName;


    /**
     * 环境图片
     */
    private String huanjingPhoto;


    /**
     * 环境类型
     */
    private Integer huanjingTypes;


    /**
     * 环境详情
     */
    private String huanjingContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：环境名称
	 */
    public String getHuanjingName() {
        return huanjingName;
    }


    /**
	 * 设置：环境名称
	 */
    public void setHuanjingName(String huanjingName) {
        this.huanjingName = huanjingName;
    }
    /**
	 * 获取：环境图片
	 */
    public String getHuanjingPhoto() {
        return huanjingPhoto;
    }


    /**
	 * 设置：环境图片
	 */
    public void setHuanjingPhoto(String huanjingPhoto) {
        this.huanjingPhoto = huanjingPhoto;
    }
    /**
	 * 获取：环境类型
	 */
    public Integer getHuanjingTypes() {
        return huanjingTypes;
    }


    /**
	 * 设置：环境类型
	 */
    public void setHuanjingTypes(Integer huanjingTypes) {
        this.huanjingTypes = huanjingTypes;
    }
    /**
	 * 获取：环境详情
	 */
    public String getHuanjingContent() {
        return huanjingContent;
    }


    /**
	 * 设置：环境详情
	 */
    public void setHuanjingContent(String huanjingContent) {
        this.huanjingContent = huanjingContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
