package in.co.rays.sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestSqlGropBy {
public static void main(String[] args) {
	SessionFactory sf =new Configuration().configure().buildSessionFactory();
	Session session =sf.openSession();
	Query q =session.createSQLQuery("select firstName,count(*) from userdto group by firstName");
	List<Object> list =q.list();
	Iterator<Object> it =list.iterator();
	while(it.hasNext()) {
		Object [] dto  =(Object[]) it.next();
		System.out.print("\t"+dto[0]);
		System.out.print("\t"+dto[1]);
	}
}
}
