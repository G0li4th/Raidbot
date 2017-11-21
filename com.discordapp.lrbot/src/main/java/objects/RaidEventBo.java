package objects;

import java.util.Date;

/**
 * 
 * @author GOLIATH
 *
 */
public class RaidEventBo {

	private Long id;
	private String title;
	private String Description;
	private Long size;
	private Long userId;
	private Date dateStart;
	private Date dateEnd;
	private Long open;
	private Date created;
	private Date modified;
	
	public RaidEventBo(Long id, String title, String description, Long size, Long userId, Date dateStart, Date dateEnd, Long open, Date created, Date modified) {
		this.id = id;
		this.title = title;
		Description = description;
		this.size = size;
		this.userId = userId;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.open = open;
		this.created = created;
		this.modified = modified;
	}

	public RaidEventBo() {
		
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
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Long getOpen() {
		return open;
	}

	public void setOpen(Long open) {
		this.open = open;
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
