package co.com.carpcosoftware.schoolmanagement.hibernate;

// Generated 19-abr-2015 18:35:39 by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Bzperiod generated by hbm2java
 */
public class Bzperiod implements java.io.Serializable {

	private Integer id;
	private Bzyear bzyear;
	private String name;
	private Date creation;
	private Date updated;
	private boolean enabled;
	private Set bznotedefinitions = new HashSet(0);

	public Bzperiod() {
	}

	public Bzperiod(Bzyear bzyear, String name, Date creation, Date updated,
			boolean enabled) {
		this.bzyear = bzyear;
		this.name = name;
		this.creation = creation;
		this.updated = updated;
		this.enabled = enabled;
	}

	public Bzperiod(Bzyear bzyear, String name, Date creation, Date updated,
			boolean enabled, Set bznotedefinitions) {
		this.bzyear = bzyear;
		this.name = name;
		this.creation = creation;
		this.updated = updated;
		this.enabled = enabled;
		this.bznotedefinitions = bznotedefinitions;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Bzyear getBzyear() {
		return this.bzyear;
	}

	public void setBzyear(Bzyear bzyear) {
		this.bzyear = bzyear;
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

	public Set getBznotedefinitions() {
		return this.bznotedefinitions;
	}

	public void setBznotedefinitions(Set bznotedefinitions) {
		this.bznotedefinitions = bznotedefinitions;
	}

}
