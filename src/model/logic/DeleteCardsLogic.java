package model.logic;

import java.util.List;

import model.dao.DeleteCardsDAO;

public class DeleteCardsLogic {
	public int execute(final List<Integer> idList) {
		DeleteCardsDAO deleteCardsDAO = new DeleteCardsDAO();
		int delteCount = deleteCardsDAO.execute(idList);
		return delteCount;
	}
}
