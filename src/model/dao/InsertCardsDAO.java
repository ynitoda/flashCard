package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.logic.SelectMaxIdLogic;

public class InsertCardsDAO {
	public int execute(final String word, final String meaning, final String unit, final String day) {
		Connection conn = null;

		// 返却用の登録件数
		int insertCount = 0;
		try {
			// データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flash_card?characterEncoding=UTF-8&serverTimezone=JST", "root", "password");

			// IDの最大値を調べる
			SelectMaxIdLogic selectMaxIdLogic = new SelectMaxIdLogic();
			int maxID = selectMaxIdLogic.execute();

			// カード登録用のSQLを準備
			String sql = " INSERT INTO CARD VALUES (?, ?, ?, false, ?, ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, ++maxID);
			pStmt.setString(2, word);
			pStmt.setString(3, meaning);
			pStmt.setString(4, unit);
			pStmt.setString(5, day);

			// カード登録を実行し、登録件数を取得
			insertCount = pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return 0;
				}
			}
		}
		return insertCount;
	}
}
