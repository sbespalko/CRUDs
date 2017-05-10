package ru.sbespalko.crud.file;

public interface CRUD {
	void create() throws Exception;
	void write(String str) throws Exception;
	String read() throws Exception;
	void delete() throws Exception;
	boolean isExist();
}
