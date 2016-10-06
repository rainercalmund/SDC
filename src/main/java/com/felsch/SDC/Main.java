package com.felsch.SDC;

import java.io.File;
import java.io.FileNotFoundException;

import com.felsch.SDC.model.JavaClass;
import com.felsch.SDC.reader.JavaClassReader;

public class Main {

    private static JavaClass javaClass;

    public static JavaClass getJavaClass() {
        return javaClass;
    }

    public static void main(String[] args) throws FileNotFoundException {
        javaClass = new JavaClass();
        JavaClassReader javaClassReader = new JavaClassReader(
                new File("D:\\workspace\\SDC\\src\\main\\java\\com\\felsch\\SDC\\ReadableTestClass.java"));
        javaClass.setJavaReader(javaClassReader);
        javaClass.setFileMethods(javaClassReader.checkForFileMethods());
    }
}
