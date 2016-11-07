package com.wd;

import java.util.Date;

public class ForecastJoinKey {

	private Date eventDate;
	private String facility;
	private String anlStructure;
	
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getAnlStructure() {
		return anlStructure;
	}
	public void setAnlStructure(String anlStructure) {
		this.anlStructure = anlStructure;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getEventDate() == null) ? 0 : getEventDate().hashCode());
		result = prime * result + ((getFacility() == null) ? 0 : getFacility().hashCode());
		result = prime * result + ((getAnlStructure() == null) ? 0 : getAnlStructure().hashCode());
		//result = prime * result + (Strings.isNullOrEmpty(getAnlStructure()) ? 0 : getAnlStructure().hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		 
		final ForecastJoinKey other = (ForecastJoinKey) obj;
		
		if (getEventDate() == null) {
			if (other.getEventDate() != null) {
				return false;
			}
		} else if (!getEventDate().equals(other.getEventDate())) {
			return false;
		}
		
		if (getFacility() == null) {
			if (other.getFacility() != null) {
				return false;
			}
		} else if (!getFacility().equals(other.getFacility())) {
			return false;
		}
		
		if (getAnlStructure() == null) {
			if (other.getAnlStructure() != null) {
				return false;
			}
		} else if (!getAnlStructure().equals(other.getAnlStructure())) {
			return false;
		}
		return true;
	}
	
}
