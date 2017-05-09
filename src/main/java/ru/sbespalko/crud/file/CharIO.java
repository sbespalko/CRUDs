package ru.sbespalko.crud.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharIO extends AbstractFileIO {

	public CharIO(String fileName) {
		super(fileName);
	}

	@Override
	public void write(String str) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			writer.write(str);
		}
	}

	@Override
	public String read() throws IOException {
		StringBuilder readStr = new StringBuilder();
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String next;
			while((next = reader.readLine()) != null){
				readStr.append(next);
			}
		}
		return readStr.toString();
	}

}
