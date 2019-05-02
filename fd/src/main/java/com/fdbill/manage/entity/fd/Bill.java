package com.fdbill.manage.entity.fd;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 账单表
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@TableName("fd_bill")
public class Bill extends Model<Bill> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 账单总收入
     */
	private BigDecimal income;
    /**
     * 账单总支出
     */
	private BigDecimal outcome;
    /**
     * 利润
     */
	private BigDecimal proft;
    /**
     * 描述
     */
	private String detail;
    /**
     * 创建用户ID
     */
	@TableField("create_user_id")
	private String createUserId;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 排序号(时间的秒级毫秒数)
     */
	@TableField("order_num")
	private Integer orderNum;
    /**
     * 删除标记(0.删除 1正常)
     */
	@TableField("del_flag")
	private Integer delFlag;


	public String getId() {
		return id;
	}

	public Bill setId(String id) {
		this.id = id;
		return this;
	}

	public BigDecimal getIncome() {
		return income;
	}

	public Bill setIncome(BigDecimal income) {
		this.income = income;
		return this;
	}

	public BigDecimal getOutcome() {
		return outcome;
	}

	public Bill setOutcome(BigDecimal outcome) {
		this.outcome = outcome;
		return this;
	}

	public BigDecimal getProft() {
		return proft;
	}

	public Bill setProft(BigDecimal proft) {
		this.proft = proft;
		return this;
	}

	public String getDetail() {
		return detail;
	}

	public Bill setDetail(String detail) {
		this.detail = detail;
		return this;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public Bill setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public Bill setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public Bill setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
		return this;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public Bill setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
