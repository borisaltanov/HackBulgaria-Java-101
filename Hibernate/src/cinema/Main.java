package cinema;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;




public class Main {
	private static SessionFactory factory;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			factory = new Configuration().configure("/resources/cinema.cfg.xml").buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		MovieManager ME = new MovieManager(session);

		/* Add few employee records in database */
		//Integer movieID1 = ME.addMovie("Kralicata", (float)4.7);

		// List down all the employees 
		ME.listMovies();

//		 Update employee's records 
		ME.updateMovieRating(10, (float) 6.4);

	/*	 Delete an employee from the database 
		ME.deleteEmployee(empID2);

		 List down new list of the employees 
		System.out.println();
		ME.listEmployees();*/

		session.close();

	}

}
