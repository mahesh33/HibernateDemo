package com.simpleprogrammer;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class Programmer {

	public static void main(String[] args) {
		System.out.println("Hello World...");

		PopulateSampleData();

		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		// Query query = session.getNamedQuery("AllGoalAlerts");

		// Query query = session.createQuery(
		// "select new com.simpleprogrammer.UserTotal(user.name,
		// user.proteinData.total)" + "from User user");

		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.or(Restrictions.eq("name", "Mahesh"), Restrictions.eq("name", "Bob"))).setProjection(
						Projections.projectionList().add(Projections.property("id")).add(Projections.property("name")));

		List<Object[]> results = criteria.list();

		for (Object[] result : results) {
			for (Object o : result) {
				System.out.println(o.toString());
			}
		}

		session.getTransaction().commit();
		session.close();

		HibernateUtilities.getSessionFactory().close();

		/*
		 * // Opening a new session. Session session =
		 * HibernateUtilities.getSessionFactory().openSession();
		 * System.out.println("Connected...");
		 * 
		 * // Transaction/work session.beginTransaction();
		 * 
		 * // Actual code User user = new User(); user.setName("Mahesh");
		 * 
		 * 
		 * Map : We've to use put instead of add and need to specify the key
		 * user.getHistory().add(new UserHistory(new Date(),
		 * "Set name to Mahesh"));
		 * 
		 * 
		 * user.addHistory(new UserHistory(new Date(), "Set name to Mahesh"));
		 * 
		 * user.getProteinData().setGoal(250); user.addHistory(new
		 * UserHistory(new Date(), "Set the goal to 250"));
		 * 
		 * // user.setGoalAlert(new GoalAlert("Congratulations!"));
		 * 
		 * user.getGoalAlerts().add(new GoalAlert("Congratulations!"));
		 * user.getGoalAlerts().add(new GoalAlert("You did it!"));
		 * 
		 * session.save(user); // Saving User to the database.
		 * 
		 * session.getTransaction().commit();
		 * 
		 * session.beginTransaction();
		 * 
		 * // Specifying what we're going to get out..Here we'll get User
		 * object. // Since get doesnot know the type so we've to cast it. User
		 * loadedUser = (User) session.get(User.class, 1);
		 * System.out.println(loadedUser.getName());
		 * System.out.println(loadedUser.getProteinData().getGoal());
		 * 
		 * 
		 * // Loop to see for (UserHistory history : loadedUser.getHistory()) {
		 * 
		 * System.out.println(history.getEntryTime().toString() + " " +
		 * history.getEntry()); }
		 * 
		 * 
		 * 
		 * for (Entry<String, UserHistory> history :
		 * loadedUser.getHistory().entrySet()) {
		 * 
		 * System.out.println("Key value : " + history.getKey());
		 * System.out.println(history.getValue().getEntryTime().toString() + " "
		 * + history.getValue().getEntry()); }
		 * 
		 * loadedUser.getProteinData().setTotal(loadedUser.getProteinData().
		 * getTotal() + 50); loadedUser.getHistory().put("GL125", new
		 * UserHistory(new Date(), "Added 50 protein"));
		 * 
		 * 
		 * 
		 * for (UserHistory history : loadedUser.getHistory()) {
		 * 
		 * System.out.println(history.getEntryTime().toString() + " " +
		 * history.getEntry()); }
		 * 
		 * loadedUser.getProteinData().setTotal(loadedUser.getProteinData().
		 * getTotal() + 50); loadedUser.addHistory(new UserHistory(new Date(),
		 * "Added 50 protein"));
		 * 
		 * user.setProteinData(new ProteinData());
		 * 
		 * session.getTransaction().commit();
		 * 
		 * // Closing session session.close();
		 */
	}

	private static void PopulateSampleData() {

		Session session = HibernateUtilities.getSessionFactory().openSession();
		session.beginTransaction();

		User mahesh = CreateUser("Mahesh", 500, 50, "Good job", "You made it!");
		session.save(mahesh);

		User bob = CreateUser("Bob", 300, 20, "Taco time!");
		session.save(bob);

		User amy = CreateUser("Amy", 250, 200, "Yes!!!");
		session.save(amy);

		session.getTransaction().commit();

		session.close();
	}

	private static User CreateUser(String name, int goal, int total, String... alerts) {

		User user = new User();

		user.setName(name);

		user.getProteinData().setGoal(goal);
		user.addHistory(new UserHistory(new Date(), "Set goal to " + goal));

		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(), "Set total to " + total));

		for (String alert : alerts) {
			user.getGoalAlerts().add(new GoalAlert(alert));
		}
		return user;
	}
}