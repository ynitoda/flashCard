package model.logic;

import model.dao.SelectMaxIdDAO;

public class SelectMaxIdLogic {
	public int execute() {
		SelectMaxIdDAO selextMaxIdDAO = new SelectMaxIdDAO();
		int maxId = selextMaxIdDAO.execute();
		return maxId;
	}
}
