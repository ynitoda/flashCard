package model.dao;

public class SelectMaxIdDAOTest {
	public static void main(String[] args) {
		SelectMaxIdDAO selextMaxIdDAO = new SelectMaxIdDAO();
		int maxId = selextMaxIdDAO.execute();
		System.out.println("maxId :" + maxId);
	}
}
