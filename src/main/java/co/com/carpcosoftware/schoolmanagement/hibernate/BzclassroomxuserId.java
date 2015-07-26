package co.com.carpcosoftware.schoolmanagement.hibernate;

// Generated 19-abr-2015 18:35:39 by Hibernate Tools 4.3.1

/**
 * BzclassroomxuserId generated by hbm2java
 */
public class BzclassroomxuserId implements java.io.Serializable {

	private int idClassRoom;
	private int idUser;

	public BzclassroomxuserId() {
	}

	public BzclassroomxuserId(int idClassRoom, int idUser) {
		this.idClassRoom = idClassRoom;
		this.idUser = idUser;
	}

	public int getIdClassRoom() {
		return this.idClassRoom;
	}

	public void setIdClassRoom(int idClassRoom) {
		this.idClassRoom = idClassRoom;
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BzclassroomxuserId))
			return false;
		BzclassroomxuserId castOther = (BzclassroomxuserId) other;

		return (this.getIdClassRoom() == castOther.getIdClassRoom())
				&& (this.getIdUser() == castOther.getIdUser());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdClassRoom();
		result = 37 * result + this.getIdUser();
		return result;
	}

}
