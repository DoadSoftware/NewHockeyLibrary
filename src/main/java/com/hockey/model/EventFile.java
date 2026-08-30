package com.hockey.model;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EventFile")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventFile {

  @XmlElementWrapper(name = "Events")
  @XmlElement(name = "event")
  private ArrayList<Event> events;

public ArrayList<Event> getEvents() {
	return events;
}

public void setEvents(ArrayList<Event> events) {
	this.events = events;
}

}
