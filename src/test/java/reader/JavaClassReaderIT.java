package reader;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.felsch.SDC.reader.JavaClassReader;

public class JavaClassReaderIT {

    private JavaClassReader javaClassReader;

    @Before
    public void setUp() throws Exception {
        javaClassReader = new JavaClassReader(
                new File("D:\\workspace\\SDC\\src\\main\\java\\com\\felsch\\SDC\\ReadableTestClass.java"));
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Checks if the File that is read by the JavaClassReader is a .java - file.
     */
    @Test
    public void checkFileForJavaFormat() {
        assertTrue(javaClassReader.checkFileFormat());
    }

    /**
     * Checks if the File includes a main method.
     * 
     * @throws IOException
     */
    @Test
    public void checkFileForMainMethod() throws IOException {
        assertTrue(javaClassReader.checkForMainMethod());
    }

    @Test
    public void checkFileForExistingMethods() throws FileNotFoundException {
        assertEquals(4, javaClassReader.checkForFileMethods().size());
    }

    @Test
    public void readAndSaveMethodCallHierarchy() {

    }

}
