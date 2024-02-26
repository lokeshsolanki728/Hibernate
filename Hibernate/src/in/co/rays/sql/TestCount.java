package in.co.rays.sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCount {
public static void main(String[] args) {
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	Query q= session.createSQLQuery("select count(*) from userdto");
	List list =q.list();
	Iterator it = list.iterator();
	while(it.hasNext()){
		Object dto= it.next();
		System.out.println(dto);
	}
	
	
}
}
