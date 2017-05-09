package ru.sbespalko.crud.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;

public class CharNIO extends AbstractFileNIO {

	public CharNIO(String fileName) {
		super(fileName);
	}

	@Override
	public void write(String str) throws IOException {
		try(BufferedWriter writer = Files.newBufferedWriter(file)){
			writer.write(str);
		}
	}

	@Override
	public String read() throws IOException {
		StringBuilder readStr = new StringBuilder();
		try(BufferedReader reader = Files.newBufferedReader(file)){
			String line = null;
			while ((line = reader.readLine()) != null){
				readStr.append(line);
			}
		}
		return readStr.toString();
	}

}
