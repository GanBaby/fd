package com.fdbill.manage.entity.fd;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 账单子表
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@TableName("fd_bill_item")
public class BillItem extends Model<BillItem> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 金额
     */
	private BigDecimal amount;
    /**
     * 账单类型 (1.收入 0.支出 )
     */
	private Integer type;
    /**
     * 账单ID
     */
	@TableField("bill_id")
	private String billId;
    /**
     * 创建用户的ID
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

	public BillItem setId(String id) {
		this.id = id;
		return this;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BillItem setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public BillItem setType(Integer type) {
		this.type = type;
		return this;
	}

	public String getBillId() {
		return billId;
	}

	public BillItem setBillId(String billId) {
		this.billId = billId;
		return this;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public BillItem setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public BillItem setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public BillItem setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
		return this;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public BillItem setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
