package model.entities;

import java.io.Serializable;

public class OS implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer OsId;
	private String OsName;
	private String OsDescription;
	private Integer OsSituation;
	
	public OS(){}

	public OS(Integer osId, String osName, String osDescription, Integer osSituation) {
		OsId = osId;
		OsName = osName;
		OsDescription = osDescription;
		OsSituation = osSituation;
	}

	public Integer getOsId() {
		return OsId;
	}

	public void setOsId(Integer osId) {
		OsId = osId;
	}

	public String getOsName() {
		return OsName;
	}

	public void setOsName(String osName) {
		OsName = osName;
	}

	public String getOsDescription() {
		return OsDescription;
	}

	public void setOsDescription(String osDescription) {
		OsDescription = osDescription;
	}

	public Integer getOsSituation() {
		return OsSituation;
	}

	public void setOsSituation(Integer osSituation) {
		OsSituation = osSituation;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((OsId == null) ? 0 : OsId.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OS other = (OS) obj;
		if (OsId == null) {
			if (other.OsId != null)
				return false;
		} else if (!OsId.equals(other.OsId))
			return false;
		return true;
	}

	public String toString() {
		return "OS Id=" + OsId + ", Nome=" + OsName + ", Descrição=" + OsDescription
				+ ", Situação="+ OsSituation + "]";
	}
}