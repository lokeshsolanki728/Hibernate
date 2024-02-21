package in.co.rays.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUser {
	
public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	
public static void main(String[] args) throws ParseException {
	testSearch();
	//testAdd();
	//testUpdate();
	//testAuthenicate();
	//testSearchName();
	//testDelete();
}

private static void testSearch() {
	UserDTO dto=new UserDTO();
	UserModel model=new UserModel();
	List list=model.search(dto);
	Iterator it = list.iterator();
	while (it.hasNext()) {
		dto = (UserDTO) it.next();
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLoginId());
		System.out.print("\t" + dto.getPassword());
		System.out.print("\t" + dto.getDob());
		System.out.println("\t" + dto.getAddress());
	}
}

private static void testDelete() {
	UserDTO dto = new UserDTO();
	dto.setId(2);
	UserModel model = new UserModel();
	model.delete(dto);
}

private static void testSearchName() {
	UserModel model = new UserModel();
	UserDTO dto = new UserDTO();
	dto.setFirstName("lok");
	List list = model.searchName(dto);
	Iterator it =list.iterator();
	if(it.hasNext()) {
		dto = (UserDTO) it.next();
		System.out.println();
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		System.out.println(dto.getDob());
		System.out.println(dto.getAddress());
	}
}
private static void testAuthenicate() {
	UserModel model = new UserModel();
	UserDTO dto = model.authenticate("nikhil@gmail.com", "1121212");
	if(dto!=null) {
		System.out.println();
		System.out.println(dto.getId());
		System.out.println(dto.getFirstName());
		System.out.println(dto.getLastName());
		System.out.println(dto.getLoginId());
		System.out.println(dto.getPassword());
		System.out.println(dto.getDob());
		System.out.println(dto.getAddress());
	}
	else {
		System.out.println("Authencation Failed...!!!");
	}
}

private static void testUpdate() {
	UserDTO dto = new UserDTO();
	UserModel model = new UserModel();
	dto.setFirstName("Nikhil");
	dto.setLastName("Khandait");
	dto.setLoginId("nikhil@gmail.com");
	dto.setPassword("1121212");
	dto.setAddress("Tilak Nagar");
	dto.setId(1);
	try {
		dto.setDob(sdf.parse("10-1-2001"));
	} catch (ParseException e) {
		e.printStackTrace();
	}
	model.update(dto);
}

private static void testAdd() {
	
	UserModel model = new UserModel();
	UserDTO dto = new UserDTO();
	
	dto.setFirstName("Lokesh");
	dto.setLastName("Solanki");
	dto.setLoginId("lokesh@gmail.com");
	dto.setPassword("1122");
	dto.setAddress("Bhainsdehi");
	try {
		dto.setDob(sdf.parse("15-4-2002"));
	} catch (ParseException e) {
		e.printStackTrace();
	}
	model.add(dto);
}

}
