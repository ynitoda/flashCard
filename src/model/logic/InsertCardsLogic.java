package model.logic;

import model.dao.InsertCardsDAO;

public class InsertCardsLogic {
	public int execute(final String word, final String meaning, final String unit, final String day) {
		InsertCardsDAO insertCardsDAO = new InsertCardsDAO();
		int insertCont = insertCardsDAO.execute(word, meaning, unit, day);
		return insertCont;
	}
}
