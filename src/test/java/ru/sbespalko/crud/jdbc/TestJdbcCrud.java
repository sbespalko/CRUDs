/**
 * Testing JDBC SQLite
 */
package ru.sbespalko.crud.jdbc;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestJdbcCrud {
	String dbName = "./TestDB/test.db";
	JdbcCrud dbCrud = new JdbcCrud("jdbc:sqlite:" + dbName);

	@BeforeClass
	public static void setUp() {
		try {
			Class.forName("org.sqlite.JDBC");
			System.out.println("Driver loaded.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testWork() throws Exception {
		dbCrud.create();
		Assert.assertTrue(Files.exists(Paths.get(dbName)));
		dbCrud.createTable();
		dbCrud.insert("Sergey", 35.0);
		dbCrud.insert("Leonid", 7.5);
		dbCrud.update(1, "Sergey", 30.0);
		dbCrud.update(2, "Leonid", 5.5);
		String str = dbCrud.read(1);
		Assert.assertTrue(str.equals("Sergey, 30.0"));
		str = dbCrud.read(2);
		Assert.assertTrue(str.equals("Leonid, 5.5"));
		dbCrud.deleteTable();
	}
}
