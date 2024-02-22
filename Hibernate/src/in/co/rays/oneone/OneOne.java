package in.co.rays.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneOne {
	public static void main(String[] args) {

		Address empAddress = new Address();

		empAddress.setId(1);
		empAddress.setStreet("street1");
		empAddress.setCity("Indore");

		Employee e = new Employee();
		e.setId(1);
		e.setName("xyz");
		e.setEmpAddress(empAddress);

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(e);

		tx.commit();

		session.close();

	}

}

