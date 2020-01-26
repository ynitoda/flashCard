package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DeleteCardsDAO {
	public int execute(final List<Integer> idList) {
		Connection conn = null;

		// 返却用の登録件数
		int deleteCount = 0;
		try {
			// データベース接続
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flash_card?characterEncoding=UTF-8&serverTimezone=JST", "root", "password");

			// 削除件数を調べる
			int count = idList.size();
			// カード削除のSQLを準備
			StringBuilder sb = new StringBuilder();
			sb.append("delete from flash_card.card where id IN (");
			for (int i = 0; i < count; i++) {
				sb.append(idList.get(i));
				if (i != count - 1) {
					sb.append(",");
				} else {
					sb.append(")");
				}
			}
			String sql = sb.toString();
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// カードを削除し、削除件数を取得
			deleteCount = pStmt.executeUpdate();

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
		return deleteCount;
	}
}
