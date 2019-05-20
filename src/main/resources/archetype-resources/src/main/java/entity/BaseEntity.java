package ${package}.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseEntity {
	
    @Column(name="creation_date", updatable=false)
    private Calendar creationDate;

    @Column(name="last_modified_date", insertable=false)
    private Calendar lastModifiedDate;
    
    @PrePersist
	void onCreate() {
    	this.setCreationDate(Calendar.getInstance());
	}

	@PreUpdate
	void onPersist() {
		this.setLastModifiedDate(Calendar.getInstance());
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public Calendar getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Calendar lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}