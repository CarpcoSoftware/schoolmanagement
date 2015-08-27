/**
 * 
 */
package co.com.carpcosoftware.schoolmanagement.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import co.com.carpcosoftware.schoolmanagement.hibernate.Cnaccess;

/**
 * Access business object
 * 
 * @author Carlos Rodriguez
 * @version 1.0
 * @since 24/03/2015
 */
@XmlRootElement(name = "access")
public class AccessBO extends AbstractBO implements Serializable {

	/**
	 * Auto generated serial version
	 */
	private static final long serialVersionUID = -5197649029321484212L;
	
	/**
	 * Default constructor
	 */
	public AccessBO() {	
		super();
	}

	public AccessBO(Cnaccess cnaccess) {
		super();
		this.id = cnaccess.getId();
		this.code = cnaccess.getCode();
		this.name = cnaccess.getName();
		this.creation = cnaccess.getCreation();
		this.updated = cnaccess.getUpdated();
		this.enabled = cnaccess.isEnabled();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AccessBO [id=" + id + ", code=" + code + ", name=" + name
				+ ", creation=" + creation + ", updated=" + updated
				+ ", enabled=" + enabled + "]";
	}	
}