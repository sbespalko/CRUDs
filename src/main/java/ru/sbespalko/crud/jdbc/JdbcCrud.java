package ru.sbespalko.crud.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcCrud {
	protected String url;

	public JdbcCrud(String url) {
		this.url = url;
	}

	public void create() throws SQLException {
		try (Connection conn = DriverManager.getConnection(url)) {
			System.out.println("DB opened.");
		}
	}

	public void createTable() throws SQLException {
		String sql = "CREATE TABLE test_table ( \n" + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, \n"
				+ "name TEXT NOT NULL, \n" + "parameter REAL NOT NULL \n" + ");";
		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
		}
	}

	public void insert(String name, double parameter) throws SQLException {
		String sql = "INSERT INTO test_table (name, parameter) VALUES (?,?); ";
		try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setDouble(2, parameter);
			pstmt.executeUpdate();
		}
	}

	public void update(int ID, String newName, double newParameter) throws Exception {
		String sql = "UPDATE test_table SET name=?, parameter=? WHERE id=?; ";
		try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, newName);
			pstmt.setDouble(2, newParameter);
			pstmt.setInt(3, ID);
			pstmt.executeUpdate();
		}
	}

	public void deleteRow(int ID) throws Exception {
		String sql = "DELETE FROM test_table WHERE id=?; ";
		try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ID);
			pstmt.executeUpdate();
		}
	}

	public String read(int ID) throws SQLException {
		String sql = "SELECT name, parameter FROM test_table WHERE id=? ;";
		String result = "";
		try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, ID);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				result += rs.getString("name") + ", ";
				result += rs.getString("parameter");
			}
		}
		return result;
	}

	public void deleteTable() throws SQLException {
		String sql = "DROP TABLE test_table";
		try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
			stmt.execute(sql);
		}
	}

}