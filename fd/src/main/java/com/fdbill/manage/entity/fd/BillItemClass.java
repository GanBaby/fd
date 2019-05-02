package com.fdbill.manage.entity.fd;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 子账单类别表
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@TableName("fd_bill_item_class")
public class BillItemClass extends Model<BillItemClass> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
	private String id;
    /**
     * 名称
     */
	private String name;
    /**
     * 图标
     */
	private String icon;
    /**
     * 图标类型（1.收入 0支出）
     */
	private Integer type;
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

	public BillItemClass setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public BillItemClass setName(String name) {
		this.name = name;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public BillItemClass setIcon(String icon) {
		this.icon = icon;
		return this;
	}

	public Integer getType() {
		return type;
	}

	public BillItemClass setType(Integer type) {
		this.type = type;
		return this;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public BillItemClass setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
		return this;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public BillItemClass setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
