package servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.beans.Card;
import model.logic.DeleteCardsLogic;
import model.logic.FindAllCardsLogic;
import model.logic.InsertCardsLogic;

/**
 * Servlet implementation class ShowCardServlet
 */
@WebServlet("/ShowCardServlet")
public class ShowCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowCardServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 全てのカードを取得し、カードリストを作成
		FindAllCardsLogic findAllCardsLogic = new FindAllCardsLogic();
		List<Card> cardList = findAllCardsLogic.execute();

		// カード数を数える
		int cardCount = cardList.size();

		// リクエストパラメータの設定
		request.setAttribute("cardCount", cardCount);
		request.setAttribute("cardList", cardList);

		// カードリスト画面に遷移
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cardList.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 削除と登録を振り分けるアクションを取得する
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if (action != null) {
			// 登録の場合
			if (action.equals("登録")) {
				// 登録用のカード情報を取得
				String word = (String) request.getParameter("word");
				String meaning  =(String) request.getParameter("meaning");
				String unit  =(String) request.getParameter("unit");
				String day  =(String) request.getParameter("day");

				// カード情報を登録
				InsertCardsLogic isnertCardsLogic = new InsertCardsLogic();
				int insertCount = isnertCardsLogic.execute(word, meaning, unit, day);
			} else if (action.equals("削除")) {
				// 削除対象のカードIDリストを取得
				System.out.println("request.getParameterValues(\"deleteCardIds\") :" + request.getParameterValues("deleteCardIds"));
				List<Integer> idList = Arrays.stream(request.getParameterValues("deleteCardIds"))
						.peek(System.out::println)
						.map(str -> Integer.valueOf(str))
						.collect(Collectors.toList());
				// カードを削除
				DeleteCardsLogic deleteCardsLogic = new DeleteCardsLogic();
				int deleteCount = deleteCardsLogic.execute(idList);
			}
		}



		this.doGet(request, response);

	}

}
