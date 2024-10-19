package com.entity.vo;

import com.entity.JiaofeiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 缴费
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaofei")
public class JiaofeiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房源
     */

    @TableField(value = "fangwu_id")
    private Integer fangwuId;


    /**
     * 缴费名称
     */

    @TableField(value = "jiaofei_name")
    private String jiaofeiName;


    /**
     * 缴费月份
     */

    @TableField(value = "jiaofei_yuefen")
    private String jiaofeiYuefen;


    /**
     * 缴费类型
     */

    @TableField(value = "jiaofei_types")
    private Integer jiaofeiTypes;


    /**
     * 缴费金额
     */

    @TableField(value = "new_money")
    private Double newMoney;


    /**
     * 缴费详情
     */

    @TableField(value = "jiaofei_content")
    private String jiaofeiContent;


    /**
     * 是否缴费
     */

    @TableField(value = "jiaofei_shifou_types")
    private Integer jiaofeiShifouTypes;


    /**
     * 缴费发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：房源
	 */
    public Integer getFangwuId() {
        return fangwuId;
    }


    /**
	 * 获取：房源
	 */

    public void setFangwuId(Integer fangwuId) {
        this.fangwuId = fangwuId;
    }
    /**
	 * 设置：缴费名称
	 */
    public String getJiaofeiName() {
        return jiaofeiName;
    }


    /**
	 * 获取：缴费名称
	 */

    public void setJiaofeiName(String jiaofeiName) {
        this.jiaofeiName = jiaofeiName;
    }
    /**
	 * 设置：缴费月份
	 */
    public String getJiaofeiYuefen() {
        return jiaofeiYuefen;
    }


    /**
	 * 获取：缴费月份
	 */

    public void setJiaofeiYuefen(String jiaofeiYuefen) {
        this.jiaofeiYuefen = jiaofeiYuefen;
    }
    /**
	 * 设置：缴费类型
	 */
    public Integer getJiaofeiTypes() {
        return jiaofeiTypes;
    }


    /**
	 * 获取：缴费类型
	 */

    public void setJiaofeiTypes(Integer jiaofeiTypes) {
        this.jiaofeiTypes = jiaofeiTypes;
    }
    /**
	 * 设置：缴费金额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 获取：缴费金额
	 */

    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 设置：缴费详情
	 */
    public String getJiaofeiContent() {
        return jiaofeiContent;
    }


    /**
	 * 获取：缴费详情
	 */

    public void setJiaofeiContent(String jiaofeiContent) {
        this.jiaofeiContent = jiaofeiContent;
    }
    /**
	 * 设置：是否缴费
	 */
    public Integer getJiaofeiShifouTypes() {
        return jiaofeiShifouTypes;
    }


    /**
	 * 获取：是否缴费
	 */

    public void setJiaofeiShifouTypes(Integer jiaofeiShifouTypes) {
        this.jiaofeiShifouTypes = jiaofeiShifouTypes;
    }
    /**
	 * 设置：缴费发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：缴费发布时间
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

}
