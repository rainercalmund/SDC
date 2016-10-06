package com.felsch.SDC.model;

import java.util.List;

import com.felsch.SDC.reader.JavaClassReader;

public class JavaClass {

    private List<JavaClassMethod> fileMethod;
    private JavaClassReader javaReader;
    private List<JavaClassGlobalVariable> globalVariables;

    public List<JavaClassMethod> getFileMethod() {
        return fileMethod;
    }

    public void setFileMethods(List<JavaClassMethod> list) {
        this.fileMethod = list;
    }

    public JavaClassReader getJavaReader() {
        return javaReader;
    }

    public void setJavaReader(JavaClassReader javaReader) {
        this.javaReader = javaReader;
    }

    public List<JavaClassGlobalVariable> getGlobalVariables() {
        return globalVariables;
    }

    public void setGlobalVariables(List<JavaClassGlobalVariable> globalVariables) {
        this.globalVariables = globalVariables;
    }

}
