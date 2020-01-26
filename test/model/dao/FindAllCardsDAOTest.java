package model.dao;

import java.util.List;

import model.beans.Card;

public class FindAllCardsDAOTest {
	public static void main(String[] args) {
		FindAllCardsDAO findAllCardsDAO = new FindAllCardsDAO();
		List<Card> cardList = findAllCardsDAO.execute();
		cardList.forEach(e -> {
			System.out.println(e.getId());
			System.out.println(e.getWord());
			System.out.println(e.getMeaning());
			System.out.println(e.isCheckflag());
		});
	}
}
