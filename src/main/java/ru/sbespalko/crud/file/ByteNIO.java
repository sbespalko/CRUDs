package ru.sbespalko.crud.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

public class ByteNIO extends AbstractFileNIO {

	public ByteNIO(String fileName) {
		super(fileName);
	}

	@Override
	public void write(String str) throws IOException {
		try(OutputStream writer = Files.newOutputStream(file)){
			writer.write(str.getBytes());
		}
	}

	@Override
	public String read() throws IOException {
		StringBuilder readStr = new StringBuilder();
		try(InputStream reader = Files.newInputStream(file)){
			int ch;
			while ((ch = reader.read()) != -1){
				readStr.append((char)ch);
			}
		}
		return readStr.toString();
	}

}
