package in.co.rays.sql;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestSqlOrderdBy {
public static void main(String[] args) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	Query q =session.createSQLQuery("select * from userdto order by firstName");
	List list =q.list();
	Iterator it = list.iterator();
	while(it.hasNext()) {
		
	Object	[] dto=(Object[]) it.next();
	System.out.println(dto[0]);
	System.out.println(dto[1]);
	System.out.println(dto[3]);
	System.out.println(dto[4]);
	System.out.println(dto[5]);
	System.out.println(dto[6]);
	}
	
}
}
