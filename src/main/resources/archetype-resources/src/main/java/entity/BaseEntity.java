package ${package}.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity {
	
    @Column(name="creation_date", updatable=false)
    private Date creationDate;

    @Column(name="last_modified_date", insertable=false)
    private Date lastModifiedDate;
    
    @PrePersist
	void onCreate() {
    	this.setCreationDate(new Date());
	}

	@PreUpdate
	void onPersist() {
		this.setLastModifiedDate(new Date());
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}