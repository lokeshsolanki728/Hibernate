package in.co.rays.dto;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class UserModel {
public void add(UserDTO dto) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 Session session = sf.openSession();
	 Transaction tx =session.beginTransaction();
	session.save(dto);
	tx.commit();
}

public void update(UserDTO dto) {
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 Session session = sf.openSession();
	 Transaction tx =session.beginTransaction();
	session.update(dto);
	tx.commit();
}

public UserDTO authenticate(String login,String pass) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	Query q =session.createQuery("from UserDTO where loginId=?and password=?");
	q.setString(0, login);
	q.setString(1, pass);
	List list=q.list();
	UserDTO dto = null;
	if(list.size()>0) {
		dto= (UserDTO) list.get(0);
	}
	session.close();
	return dto;
}

public List searchName(UserDTO dto) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();
	Criteria criteria = session.createCriteria(UserDTO.class);
	if(dto!=null) {
		if(dto.getFirstName()!=null&&dto.getFirstName().length()>0) {
			criteria.add(Restrictions.like("firstName", dto.getFirstName()+"%"));
		}
		
	}
	List list = criteria.list();
	return list;
}
public void delete(UserDTO dto) {
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session =sf.openSession();
	Transaction tx =session.beginTransaction();
	session.delete(dto);
	tx.commit();
	session.close();
}
public List search(UserDTO dto) {
	 SessionFactory sf=new Configuration().configure().buildSessionFactory();
	 Session session =sf.openSession();
	Query q= session.createQuery("from UserDTO");
	List list = q.list();
	return list;
}
}
