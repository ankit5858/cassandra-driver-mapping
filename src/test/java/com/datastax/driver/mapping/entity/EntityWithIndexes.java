package com.datastax.driver.mapping.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="TEST_ENTITY", 
	   indexes = {
		@Index(name="TEST_ENTITY_email_idx", columnList="email" ), 
		@Index(name="TEST_ENTITY_timestamp_idx", columnList="timestamp" ) 
})
public class EntityWithIndexes {
	
	@Id
	private UUID uuid;
	private String email;
	private Date timestamp;
	
	@Column(name="counter") // override default name
	private long count;
	
	private String name;
	
	@Transient
	private UUID ref; // do not persist
	
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public long getCount() {
		return count;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public UUID getRef() {
		return ref;
	}
	public void setRef(UUID ref) {
		this.ref = ref;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (count ^ (count >>> 32));
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((timestamp == null) ? 0 : timestamp.hashCode());
		result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntityWithIndexes other = (EntityWithIndexes) obj;
		if (count != other.count)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (timestamp == null) {
			if (other.timestamp != null)
				return false;
		} else if (!timestamp.equals(other.timestamp))
			return false;
		if (uuid == null) {
			if (other.uuid != null)
				return false;
		} else if (!uuid.equals(other.uuid))
			return false;
		return true;
	}
	

}