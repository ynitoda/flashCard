package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Card;

public class FindAllCardsDAO {
	public List<Card> execute() {
		Connection conn = null;
		// 返却用のカードリストを生成
		List<Card> cardList = new ArrayList<>();
		try {
			// データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flash_card?characterEncoding=UTF-8&serverTimezone=JST", "root", "password");

			// 全権検索のSQLを準備
			String sql = "select * from card";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// 全権検索を実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表から出力用のCard Listを作成
			while (rs.next()) {
				int id = rs.getInt("ID");
				String word = rs.getString("WORD");
				String meaning = rs.getString("MEANING");
				boolean checkflag = rs.getBoolean("CHECKFLAG");
				String unit = rs.getString("UNIT");
				String day = rs.getString("DAY");
				Card card = new Card(id, word, meaning, checkflag, unit, day);
				cardList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return cardList;
	}
}
