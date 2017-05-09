package ru.sbespalko.crud.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import ru.sbespalko.crud.CRUD;

public abstract class AbstractFileNIO implements CRUD {
	protected String fileName;
	protected Path file;

	public AbstractFileNIO(String fileName) {
		this.fileName = fileName;
		file = Paths.get(fileName);
	}

	@Override
	public void create() throws IOException {
		if (!Files.exists(file)) {
			file = Files.createFile(file);
		}
	}

	abstract public void write(String str) throws IOException;

	abstract public String read() throws IOException;

	@Override
	public void delete() throws IOException {
		Files.deleteIfExists(file);
	}

	@Override
	public boolean isExist() {
		return Files.exists(file);
	}

}
