/**
 * Testing file NIO in bytes mode
 */
package ru.sbespalko.crud.file;

import org.junit.Before;

public class TestByteNIO extends AbstractFileTest{
	String fileName = "./ByteNIOTest.txt";
	CRUD fileWrapper = new ByteNIO(fileName);
	String testText = "ByteNIO testing!qwertyuiop[]asdfghjkl;'zxcvbnm,./";
	
	@Before
	public void setter(){
		super.setFileName(fileName);
		super.setFileWrapper(fileWrapper);
		super.setTestText(testText);
	}
}
