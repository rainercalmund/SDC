package com.felsch.SDC.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.felsch.SDC.model.JavaClassGlobalVariable;
import com.felsch.SDC.model.JavaClassMethod;

public class JavaClassReader {

    private File fileToRead;
    private List<JavaClassMethod> classMethods;
    private BufferedReader fileReader;
    private LinkedList<JavaClassGlobalVariable> gloablVariables;

    public JavaClassReader(File file) throws FileNotFoundException {
        fileToRead = file;
        fileReader = new BufferedReader(new FileReader(fileToRead));
        classMethods = new LinkedList<JavaClassMethod>();
        gloablVariables = new LinkedList<JavaClassGlobalVariable>();
    }

    public boolean checkFileFormat() {
        if (fileToRead.exists()) {
            if (fileToRead.getAbsolutePath().endsWith(".java")) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean checkForMainMethod() {
        if (fileToRead.exists()) {
            Stream<String> linesOfCode = fileReader.lines();
            if (linesOfCode.anyMatch(s -> s.contains("public static void main")) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @returns the method heads of a java-class as a List (every index is a line of code -> method head);
     */
    public List<JavaClassMethod> checkForFileMethods() {
        if (fileToRead.exists()) {
            List<String> methodHeads = fileReader.lines()
                    .filter(p -> (p.contains("public") || p.contains("private") || p.contains("protected"))
                            && (p.contains("void") || p.contains("static")) && p.contains("(") && p.contains(")"))
                    .collect(Collectors.toList());
            return createJavaClassMethods(methodHeads);
        }
        return null;
    }

    private List<JavaClassMethod> createJavaClassMethods(List<String> methodHeads) {
        for (String methodHead : methodHeads) {
            classMethods.add(new JavaClassMethod(methodHead));
        }
        return classMethods;
    }

}
