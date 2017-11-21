package objects;

import java.util.Date;

/**
 * 
 * @author GOLIATH
 *
 */
public class UsersBo {

	private Long id;
	private Long role_id;
	private Long discord_id;
	private String email;
	private Long notifications_cancel;
	private Long notifications_new;
	private Long notifications_validate;
	private Long status;
	private Date created;
	private Date modified;
	

	public UsersBo(Long id, Long role_id, Long discord_id, String email, Long notifications_cancel, Long notifications_new, Long notifications_validate, Long status, Date created, Date modified) {
		this.id = id;
		this.role_id = role_id;
		this.discord_id = discord_id;
		this.email = email;
		this.notifications_cancel = notifications_cancel;
		this.notifications_new = notifications_new;
		this.notifications_validate = notifications_validate;
		this.status = status;
		this.created = created;
		this.modified = modified;
	}

	public UsersBo() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	public Long getDiscord_id() {
		return discord_id;
	}

	public void setDiscord_id(Long discord_id) {
		this.discord_id = discord_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNotifications_cancel() {
		return notifications_cancel;
	}

	public void setNotifications_cancel(Long notifications_cancel) {
		this.notifications_cancel = notifications_cancel;
	}

	public Long getNotifications_new() {
		return notifications_new;
	}

	public void setNotifications_new(Long notifications_new) {
		this.notifications_new = notifications_new;
	}

	public Long getNotifications_validate() {
		return notifications_validate;
	}

	public void setNotifications_validate(Long notifications_validate) {
		this.notifications_validate = notifications_validate;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	
	
}
