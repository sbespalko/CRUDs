package ru.sbespalko.crud.file;

import org.junit.Before;

import ru.sbespalko.crud.CRUD;

public class TestCharNIO extends AbstractFileTest {
	String fileName = "./FileTests/CharNIOTest.txt";
	CRUD fileWrapper = new CharNIO(fileName);
	String testText = "CharNIO testing!qwertyuiop[]asdfghjkl;'zxcvbnm,./";
	
	@Before
	public void setter(){
		super.setFileName(fileName);
		super.setFileWrapper(fileWrapper);
		super.setTestText(testText);
	}

}
