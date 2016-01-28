package co.com.soinsoftware.schoolmanagement.hibernate;

// Generated 19-abr-2015 18:35:39 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Bzschool generated by hbm2java
 */
@SuppressWarnings({ "serial", "rawtypes" })
public class Bzschool implements java.io.Serializable {

	private Integer id;
	private String code;
	private String name;
	private Date creation;
	private Date updated;
	private boolean enabled;
	private Set bzschoolxusers = new HashSet(0);
	private Set bzclassrooms = new HashSet(0);

	public Bzschool() {
	}

	public Bzschool(String code, String name, Date creation, Date updated,
			boolean enabled) {
		this.code = code;
		this.name = name;
		this.creation = creation;
		this.updated = updated;
		this.enabled = enabled;
	}

	public Bzschool(String code, String name, Date creation, Date updated,
			boolean enabled, Set bzschoolxusers, Set bzclassrooms) {
		this.code = code;
		this.name = name;
		this.creation = creation;
		this.updated = updated;
		this.enabled = enabled;
		this.bzschoolxusers = bzschoolxusers;
		this.bzclassrooms = bzclassrooms;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreation() {
		return this.creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set getBzschoolxusers() {
		return this.bzschoolxusers;
	}

	public void setBzschoolxusers(Set bzschoolxusers) {
		this.bzschoolxusers = bzschoolxusers;
	}

	public Set getBzclassrooms() {
		return this.bzclassrooms;
	}

	public void setBzclassrooms(Set bzclassrooms) {
		this.bzclassrooms = bzclassrooms;
	}

}