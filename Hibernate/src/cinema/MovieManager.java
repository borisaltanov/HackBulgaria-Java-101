package cinema;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieManager {
	
	private Session session;
	
	public MovieManager(Session session) {
		this.session = session;
	}
	
	public Integer addMovie(String name, float rating) {
		// TODO Auto-generated method stub
		Integer movieID = null;

		Movie m = new Movie(name, rating);
		movieID = (Integer) session.save(m);

		return movieID;
	}
	
	public void listMovies() {
		// TODO Auto-generated method stub
		List movies = session.createQuery("FROM Movie").getResultList();
		for (Iterator iterator = movies.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			System.out.print("Name: " + movie.getName());
			System.out.println("Salary: " + movie.getRating());
		}

	}
	
	public void updateMovieRating(Integer movieID, float rating) {
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Movie movie = (Movie) session.get(Movie.class, movieID);
			movie.setRating(rating);
			session.update(movie);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

}
