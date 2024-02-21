package in.co.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAuction {
public static void main(String[] args) {
	Bid bid1 = new Bid();
	bid1.setId(1);
	bid1.setAmount("150");
	bid1.setTimeStamp("@@@");
	
	Bid bid2 = new Bid();
	bid2.setId(2);
	bid2.setAmount("175");
	bid2.setTimeStamp("!!!!");
	
	Bid bid3 = new Bid();
	bid3.setId(3);
	bid3.setAmount("187");
	bid3.setTimeStamp("***");
	
	Set bids  = new HashSet(); 
	bids.add(bid1);
	bids.add(bid2);
	bids.add(bid3);
	
	AuctionItem item = new AuctionItem();
	item.setId(1);
	item.setBids(bids);
	item.setDescription("auction 1");
	
	
	  SessionFactory sf=new Configuration().configure().buildSessionFactory();
	   Session session =sf.openSession();
	    Transaction tx= session.beginTransaction();
	    session.save(item);
	    tx.commit();
	    session.close();
	    
	    
	   
	
}
}
