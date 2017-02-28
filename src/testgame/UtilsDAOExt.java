package testgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UtilsDAOExt {

	Connection connection;

	private Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/ashenone?user=root&password=root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void deleteTable() {
		Connection conn = getConnection();
		try {
			Statement statement = conn.createStatement();
			String sql = "DROP TABLE IF EXISTS Game";
			statement.executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTwoRows() {
		Connection conn = getConnection();
		Statement stmt;
		PreparedStatement ps = null;
		try {
			String sql = "CREATE TABLE `game` ("
					+ " `gameid` int(11) NOT NULL AUTO_INCREMENT, "
					+ " `gamename` varchar(255) DEFAULT NULL,"
					+ " `gamecompany` varchar(255) DEFAULT NULL,"
					+ " `gameplatform` varchar(255) DEFAULT NULL,"
					+ " `gameyear` varchar(255) DEFAULT NULL,"
					+ " `gamefeedback` varchar(255) DEFAULT NULL,"
					+ " PRIMARY KEY (`gameid`))";
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			ps = conn
					.prepareStatement(
							"INSERT INTO `game` (gamename, gamecompany, gameplatform, gameyear, gamefeedback) VALUES (?, ?, ?, ?, ?)",
							new String[] { "ID" });
			
			ps.setString(1, "WATCHDOGS 888");
			ps.setString(2, "UBISOFT");
			ps.setString(3, "PS4, XBOXONE, PC");
			ps.setString(4, "2016");
			ps.setString(5, "9 STAR");
			ps.executeUpdate();
			
			ps = conn
					.prepareStatement(
							"INSERT INTO `game` (gamename, gamecompany, gameplatform, gameyear, gamefeedback) VALUES (?, ?, ?, ?, ?)",
							new String[] { "ID" });
			
			ps.setString(1, "WATCHDOGS 3");
			ps.setString(2, "UBISOFT");
			ps.setString(3, "PS4, XBOXONE, PC");
			ps.setString(4, "2016");
			ps.setString(5, "9 STAR");
			ps.executeUpdate();
			
			ps = conn
					.prepareStatement(
							"INSERT INTO `game` (gamename, gamecompany, gameplatform, gameyear, gamefeedback) VALUES (?, ?, ?, ?, ?)",
							new String[] { "ID" });
			
			ps.setString(1, "WATCHDOGS 4");
			ps.setString(2, "UBISOFT");
			ps.setString(3, "PS4, XBOXONE, PC");
			ps.setString(4, "2016");
			ps.setString(5, "9 STAR");
			ps.executeUpdate();
			
			ps = conn
					.prepareStatement(
							"INSERT INTO `game` (gamename, gamecompany, gameplatform, gameyear, gamefeedback) VALUES (?, ?, ?, ?, ?)",
							new String[] { "ID" });
			
			ps.setString(1, "MA");
			ps.setString(2, "LAYERS");
			ps.setString(3, "WII");
			ps.setString(4, "2017");
			ps.setString(5, "10 STAR");	
			ps.executeUpdate();
			
			
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
