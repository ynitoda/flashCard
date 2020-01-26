package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMaxIdDAO {
	public int execute() {
		Connection conn = null;
		// 返却用のIDの最大値を格納する変数
		int maxId = 0;
		try {
			// データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flash_card?characterEncoding=UTF-8&serverTimezone=JST", "root", "password");

			// IDの最大値を調べるSQLを準備
			String sql = "SELECT MAX(ID) FROM CARD";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// IDの最大値を調べるSQLを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表からIDの最大値を取得
			while (rs.next()) {
				maxId = rs.getInt("MAX(ID)");
			}


		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return maxId;
				}
			}
		}
		return maxId;
	}
}
