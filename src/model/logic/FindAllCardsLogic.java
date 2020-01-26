package model.logic;

import java.util.List;

import model.beans.Card;
import model.dao.FindAllCardsDAO;;

public class FindAllCardsLogic {
	public List<Card> execute() {
		FindAllCardsDAO findAllCardsDAO = new FindAllCardsDAO();
		List<Card> cardList = findAllCardsDAO.execute();
		return cardList;
	}
}
