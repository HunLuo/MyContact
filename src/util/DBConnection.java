package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBConnection {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private void getDBConnction() {
		Context context;
		try {
			context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/DBCP");
			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void closeDBConnction() {

		try {
			this.conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ResultSet execQuery(final String strSQL, Object... params) {

		this.getDBConnction();

		System.out.println("\nSQL:" + strSQL);
		try {
			this.pstmt = conn.prepareStatement(strSQL);

			for (int i = 0; i < params.length; i++) {
				this.pstmt.setObject(i + 1, params[i]);
			}

			this.rs = this.pstmt.executeQuery();
			return this.rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int execUpdate(final String strSQL, Object... params) {

		this.getDBConnction();

		System.out.println("\nSQL:" + strSQL);
		try {
			this.pstmt = conn.prepareStatement(strSQL);

			for (int i = 0; i < params.length; i++) {
				this.pstmt.setObject(i + 1, params[i]);
			}

			int affectRows = this.pstmt.executeUpdate();
			return affectRows;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
}