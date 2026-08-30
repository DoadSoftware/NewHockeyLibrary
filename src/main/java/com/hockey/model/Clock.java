package com.hockey.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Clock")
@XmlAccessorType(XmlAccessType.FIELD)
public class Clock {
	 @XmlElement(name = "matchHalves")
	  private String matchHalves;
	  
	  @XmlElement(name = "matchTimeStatus")
	  private String matchTimeStatus;

	  @XmlElement(name = "matchTotalMilliSeconds")
	  private long matchTotalMilliSeconds;

	public String getMatchHalves() {
		return matchHalves;
	}

	public void setMatchHalves(String matchHalves) {
		this.matchHalves = matchHalves;
	}

	public String getMatchTimeStatus() {
		return matchTimeStatus;
	}

	public void setMatchTimeStatus(String matchTimeStatus) {
		this.matchTimeStatus = matchTimeStatus;
	}

	public long getMatchTotalMilliSeconds() {
		return matchTotalMilliSeconds;
	}

	public void setMatchTotalMilliSeconds(long matchTotalMilliSeconds) {
		this.matchTotalMilliSeconds = matchTotalMilliSeconds;
	}
	  
		/*
		 * @XmlElement(name = "matchHalves") private String matchHalves;
		 * 
		 * @XmlElement(name = "matchStartTime") private String matchStartTime;
		 * 
		 * @XmlElement(name = "matchTimeStatus") private String matchTimeStatus;
		 * 
		 * @XmlElement(name = "matchTotalSeconds") private long matchTotalSeconds;
		 */

}