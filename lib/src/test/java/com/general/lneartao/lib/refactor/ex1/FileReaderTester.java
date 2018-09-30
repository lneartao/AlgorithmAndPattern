package com.general.lneartao.lib.refactor.ex1;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author lneartao
 * @date 2018/9/29.
 */
public class FileReaderTester extends TestCase {

    private FileReader input;
    private FileReader empty;

    public static void main(String[] args) {
        TestRunner.run(new TestSuite(FileReaderTester.class));
    }

    public FileReaderTester(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        try {
            input = new FileReader("data.txt");
            empty = newEmptyFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void tearDown() throws Exception {
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testRead() throws IOException {
        char ch = '&';
        for (int i = 0; i < 4; i++) {
            ch = (char) input.read();
        }
        assertEquals('d', ch);
    }

    public void testReadAtEnd() throws IOException {
        int ch = -1234;
        for (int i = 0; i < 141; i++) {
            ch = input.read();
        }
        assertEquals(-1, input.read());
    }

    public void testReadBoundaries() throws IOException {
        assertEquals("read first char", 'B', input.read());
        int ch;
        for (int i = 1; i < 140; i++) {
            ch = input.read();
        }
        assertEquals("read last char", -1, input.read());
        assertEquals("read at end", -1, input.read());
        assertEquals("read past end", -1, input.read());
    }

    public void testEmptyRead() throws IOException {
        assertEquals(-1, empty.read());
    }

    private FileReader newEmptyFile() throws IOException {
        File empty = new File("empty.txt");
        FileOutputStream out = new FileOutputStream(empty);
        out.close();
        return new FileReader(empty);
    }

    public void testReadAfterClose() throws IOException {
        input.close();
        try {
            input.read();
            fail("no exception for read past end");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
