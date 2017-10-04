package com.simpleprogrammer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {

	private int id;
	private String name;

	// private ProteinData proteinData = new ProteinData();

	private ProteinData proteinData;

	/*
	 * Set : it doesn't have order. private Set<UserHistory> history = new
	 * HashSet<UserHistory>();
	 */

	/*
	 * List : it can have any number of elements and can be duplicate but in
	 * specific order. private List<UserHistory> history = new ArrayList
	 * <UserHistory>();
	 */

	/*
	 * Map : we're going to have entry id. We use put instead of add and also
	 * the key. private Map<String, UserHistory> history = new HashMap<String,
	 * UserHistory>();
	 */

	/*
	 * Collection : We can also map a plain collection in Hibernate using either
	 * a bag or id bag. private Collection<UserHistory> history = new
	 * ArrayList<UserHistory>();
	 */

	private List<UserHistory> history = new ArrayList<UserHistory>();

	// private GoalAlert goalAlert;

	private Set<GoalAlert> goalAlerts = new HashSet<GoalAlert>();

	// Setting up the protein data
	public User() {

		setProteinData(new ProteinData());
		// proteinData.setUser(this);
	}

	/*
	 * public GoalAlert getGoalAlert() { return goalAlert; }
	 * 
	 * public void setGoalAlert(GoalAlert goalAlert) { this.goalAlert =
	 * goalAlert; }
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProteinData getProteinData() {
		return proteinData;
	}

	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}

	public List<UserHistory> getHistory() {
		return history;
	}

	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}

	// Creating Method : When we add User history to our User that we enforce
	// this relationship

	public void addHistory(UserHistory historyItem) {

		historyItem.setUser(this); // Relationship go from history item to user
		history.add(historyItem); // Adding to our history item
	}

	public Set<GoalAlert> getGoalAlerts() {
		return goalAlerts;
	}

	public void setGoalAlerts(Set<GoalAlert> goalAlerts) {
		this.goalAlerts = goalAlerts;
	}

}
