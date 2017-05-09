package ru.sbespalko.crud.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class ByteIO extends AbstractFileIO {
	
	public ByteIO(String fileName) {
		super(fileName);
	}

	@Override
	public void write(String str) throws IOException {
		try(OutputStream out = new BufferedOutputStream(new FileOutputStream(file))){
			out.write(str.getBytes());
		}
	}

	@Override
	public String read() throws IOException {
		StringBuilder readStr = new StringBuilder();
		try(InputStream in = new BufferedInputStream(new FileInputStream(file))){
			int ch; 
			while((ch = in.read()) != -1){
				readStr.append((char)ch);
			}
		}
		return readStr.toString();
	}
}
