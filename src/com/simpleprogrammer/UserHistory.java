package com.simpleprogrammer;

import java.util.Date;

public class UserHistory {

	private int id;
	private User user;

	private Date entryTime;
	private String entry;

	public UserHistory() {

	}

	public UserHistory(Date entryTime, String entry) {
		super();
		this.entryTime = entryTime;
		this.entry = entry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * Generate equals() and hashCode() : Because with all our collections
	 * Hibernates going to need to build and compare these value types to know
	 * if they're the same or not.
	 * 
	 * @Override public int hashCode() { final int prime = 31; int result = 1;
	 * result = prime * result + ((entry == null) ? 0 : entry.hashCode());
	 * result = prime * result + ((entryTime == null) ? 0 :
	 * entryTime.hashCode()); return result; }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return
	 * true; if (obj == null) return false; if (getClass() != obj.getClass())
	 * return false; UserHistory other = (UserHistory) obj; if (entry == null) {
	 * if (other.entry != null) return false; } else if
	 * (!entry.equals(other.entry)) return false; if (entryTime == null) { if
	 * (other.entryTime != null) return false; } else if
	 * (!entryTime.equals(other.entryTime)) return false; return true; }
	 */

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

}
