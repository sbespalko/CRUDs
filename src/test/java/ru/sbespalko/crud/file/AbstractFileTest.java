package ru.sbespalko.crud.file;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
abstract public class AbstractFileTest {

	String fileName;
	CRUD fileWrapper;
	String testText;

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void setFileWrapper(CRUD fileWrapper) {
		this.fileWrapper = fileWrapper;
	}

	public void setTestText(String testText) {
		this.testText = testText;
	}

	@Test
	public void test0Create() throws Exception {
		fileWrapper.create();
		Assert.assertTrue(fileWrapper.isExist());
	}
	@Test
	public void test1Write() throws Exception {
		fileWrapper.write(testText);
	}

	@Test
	public void test2Read() throws Exception {
		String readStr = fileWrapper.read();
		Assert.assertTrue(readStr.equals(testText));
		System.out.println(readStr);
	}

	@Test
	public void test3Delete() throws Exception {
		fileWrapper.delete();
		Assert.assertFalse(fileWrapper.isExist());
	}
}
