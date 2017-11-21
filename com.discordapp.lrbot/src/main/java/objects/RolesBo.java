package objects;

import java.util.Date;

public class RolesBo {
	
	private Long id;
	private String title;
	private String description;
	private Date created;
	private Date modified;

	public RolesBo() {
		
	}
	
	public RolesBo(Long id, String title, String description, Date created, Date modified) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.created = created;
		this.modified = modified;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
