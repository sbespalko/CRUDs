package ru.sbespalko.crud.file;

import java.io.File;
import java.io.IOException;

import ru.sbespalko.crud.CRUD;

public abstract class AbstractFileIO implements CRUD {
	protected String fileName;
	protected File file;

	public AbstractFileIO(String fileName) {
		this.fileName = fileName;
		file = new File(this.fileName);
	}

	@Override
	public void create() throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
	}
	
	abstract public void write(String str) throws IOException;

	abstract public String read() throws IOException;

	@Override
	public void delete() {
		if (file.exists()) {
			file.delete();
		}
	}

	@Override
	public boolean isExist() {
		return file.exists();
	}

}
