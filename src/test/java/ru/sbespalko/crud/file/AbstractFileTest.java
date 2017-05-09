package ru.sbespalko.crud.file;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import ru.sbespalko.crud.CRUD;

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
	public void testCreate() throws IOException {
		fileWrapper.create();
		Assert.assertTrue(fileWrapper.isExist());
	}

	@Test
	public void testWrite() throws IOException {
		fileWrapper.write(testText);
	}

	@Test
	public void testRead() throws IOException {
		String readStr = fileWrapper.read();
		Assert.assertTrue(readStr.equals(testText));
		System.out.println(readStr);
	}

	@Test
	@Ignore
	public void testDelete() throws IOException {
		fileWrapper.delete();
		Assert.assertFalse(fileWrapper.isExist());
	}
}
