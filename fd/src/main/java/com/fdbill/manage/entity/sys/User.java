package com.fdbill.manage.entity.sys;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fdbill.manage.utils.global.UserGlobal;
import com.fdbill.manage.utils.util.Utils;

import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author 甘银涛
 * @since 2019-05-01
 */
@TableName("sys_user")
public class User extends Model<User> {

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
     * 密码
     */
	private String password;

	/**
	 * 加密盐
	 */
	private String salt;

    /**
     * 电话号码
     */
	private String phone;
    /**
     * 用户头像
     */
	@TableField("head_phone")
	private String headPhone;
    /**
     * 用户角色类型（1.用户 0.管理员）
     */
	@TableField("role_type")
	private String roleType;
    /**
     * 用户状态(1.正常 0封禁 -1.删除)
     */
	private String status;
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
	private String delFlag;

	public void setInit(){
		this.setId(Utils.genUUID());
		this.setStatus(UserGlobal.USABLE);
		this.setDelFlag(UserGlobal.NOT_DELETED);
		this.setCreateTime(new Date());
	}

	public String getId() {
		return id;
	}

	public User setId(String id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public User setName(String name) {
		this.name = name;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public User setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getHeadPhone() {
		return headPhone;
	}

	public User setHeadPhone(String headPhone) {
		this.headPhone = headPhone;
		return this;
	}

	public String getRoleType() {
		return roleType;
	}

	public User setRoleType(String roleType) {
		this.roleType = roleType;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public User setStatus(String status) {
		this.status = status;
		return this;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public User setCreateTime(Date createTime) {
		this.createTime = createTime;
		return this;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public User setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
		return this;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public User setDelFlag(String delFlag) {
		this.delFlag = delFlag;
		return this;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
