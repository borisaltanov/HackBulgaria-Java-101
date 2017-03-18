package friday_week11;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeManager {
	private Session session;

	public EmployeeManager(Session session) {
		// TODO Auto-generated constructor stub
		this.session = session;
	}

	public Integer addEmployee(String fname, String lname, int salary) {
		// TODO Auto-generated method stub
		Integer employeeID = null;

		Employee e = new Employee(fname, lname, salary);
		employeeID = (Integer) session.save(e);

		return employeeID;
	}

	public void listEmployees() {
		// TODO Auto-generated method stub
		List employees = session.createQuery("FROM Employee").list();
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			System.out.print("First Name: " + employee.getFirstName());
			System.out.print("  Last Name: " + employee.getLastName());
			System.out.println("  Salary: " + employee.getSalary());
		}

	}

	public void updateEmployee(Integer EmployeeID, int salary) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			employee.setSalary(salary);
			session.update(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}
	}

	public void deleteEmployee(Integer EmployeeID) {
		// TODO Auto-generated method stub
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Employee employee = (Employee) session.get(Employee.class, EmployeeID);
			session.delete(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

	}

}
