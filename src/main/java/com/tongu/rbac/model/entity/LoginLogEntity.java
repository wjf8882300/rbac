package com.tongu.rbac.model.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 *  entity. @author Tools
 */
@Entity
@Table(name = "CK_T_LOGIN_LOG")
public class LoginLogEntity extends BaseEntity  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 */
	private String userId;

	/**
	 * 
	 */
	private String ipAddress;



	@Column(name = "USER_ID", length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "IP_ADDRESS", length = 50)
	public String getIpAddress() {
		return this.ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

}
