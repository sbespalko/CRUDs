package ru.sbespalko.crud.file;

import org.junit.Before;

public class TestCharIO extends AbstractFileTest {
	String fileName = "./CharIOTest.txt";
	CRUD fileWrapper = new CharIO(fileName);
	String testText = "CharIO testing!qwertyuiop[]asdfghjkl;'zxcvbnm,./";
	
	@Before
	public void setter(){
		super.setFileName(fileName);
		super.setFileWrapper(fileWrapper);
		super.setTestText(testText);
	}

}
