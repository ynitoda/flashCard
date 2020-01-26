package model.dao;

import java.util.ArrayList;
import java.util.List;

public class DeleteCardsDAOTest {
	public static void main(String[] args) {
		DeleteCardsDAO deleteCardsDao = new DeleteCardsDAO();
		List<Integer> idList = new ArrayList<>();
		idList.add(7);
		idList.add(8);
		idList.add(9);
		int deleteCount = deleteCardsDao.execute(idList);
		System.out.println("削除件数" + deleteCount);
	}
}
