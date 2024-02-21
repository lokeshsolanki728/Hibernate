package in.co.rays.auction;

import java.util.Set;

public class AuctionItem {
int id;
Set bids;
String description;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Set getBids() {
	return bids;
}
public void setBids(Set bids2) {
	this.bids = bids2;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}

}
