package ru.sbespalko.crud;

import java.io.IOException;

public interface CRUD {
	void create() throws IOException;
	void write(String str) throws IOException;
	String read() throws IOException;
	void delete() throws IOException;
	boolean isExist();
}
