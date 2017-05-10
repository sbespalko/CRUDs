/**
 * Testing file IO in bytes mode
 */
package ru.sbespalko.crud.file;

import org.junit.Before;

public class TestByteIO extends AbstractFileTest {
	String fileName = "./FileTests/ByteIOTest.txt";
	CRUD fileWrapper = new ByteIO(fileName);
	String testText = "ByteIO testing!qwertyuiop[]asdfghjkl;'zxcvbnm,./";
	
	@Before
	public void setter(){
		super.setFileName(fileName);
		super.setFileWrapper(fileWrapper);
		super.setTestText(testText);
	}

}
