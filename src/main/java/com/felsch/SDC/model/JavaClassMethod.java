package com.felsch.SDC.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.felsch.SDC.misc.SDCConstants;

public class JavaClassMethod {

    private List<String> methodHeadWords;
    private String methodReturnType;
    private List<String> methodParameterList;
    private Map<String, String> methodParameterMap;
    private String methodHead;
    private int methodID;
    private String methodName;

    public JavaClassMethod(String methodHead) {
        this.methodHead = methodHead;
        this.methodName = "";
        methodHeadWords = new ArrayList<>();
        methodReturnType = "";
        methodParameterList = new ArrayList<>();
        methodParameterMap = new HashMap<>();
        initMethod();
    }

    private void initMethod() {
        methodID = (int) ((10 * Math.random()) + 50);
        setMethodBasicInformations();
        setMethodParameters();
        System.out.println("Dies ist die neue Methode " + methodName + " mit der ID: " + methodID
                + " und dem Return-Typ " + methodReturnType);
    }

    /**
     * FIRST: It creates a list with all words, that are given in the method head. SECOND: It checks the words and
     * sets the methodReturnType. THIRD: It checks the words again and sets the methodName.
     */
    private void setMethodBasicInformations() {
        String dummyWord = "";
        for (char s : methodHead.toCharArray()) {
            if ((s == ' ') || (s == '(') || (s == ')')) {
                methodHeadWords.add(dummyWord);
                dummyWord = "";
            } else {
                dummyWord = dummyWord + "" + s;
            }
        }
        List<String> emptyWordsToDelete = new ArrayList<>();
        for (String word : methodHeadWords) {
            if (word.equals("") || word.equals(" ")) {
                emptyWordsToDelete.add(word);
            } else if (!SDCConstants.checkWordIsPartOfToken(word)) {
                methodReturnType = word;
                methodName = methodHeadWords.get(methodHeadWords.indexOf(word) + 1);
                break;
            }
        }
        methodHeadWords.removeAll(emptyWordsToDelete);
    }

    /**
     * Creates a MethodParameterList with all Parameter-Words of the MethodHead (e.g. ["String","name","int","zahl"]
     * .. ). With this List, a ParameterMap will be created, where the name of the Parameter is the key and the Type
     * is the value (e.g. <name,String>).
     * 
     * @param methodHead
     */
    private void setMethodParameters() {
        String parameters = methodHead.substring(methodHead.indexOf(SDCConstants.JAVATOKEN_BRACKETOPEN),
                methodHead.indexOf(SDCConstants.JAVATOKEN_BRACKETCLOSED));
        String dummyParameter = "";

        for (char s : parameters.toCharArray()) {
            if ((s == ' ') || (s == '(') || (s == ')')) {
                methodParameterList.add(dummyParameter);
                dummyParameter = "";
            } else {
                dummyParameter = dummyParameter + "" + s;
            }
        }
        methodParameterList.add(dummyParameter);

        List<String> emptyWordsToDelete = new ArrayList<>();
        for (String parameter : methodParameterList) {
            if (parameter.equals("") || parameter.equals(" ")) {
                emptyWordsToDelete.add(parameter);
            }
        }
        methodParameterList.removeAll(emptyWordsToDelete);

        for (int i = 0; i < methodParameterList.size(); i++) {
            if (i % 2 == 0) {
                methodParameterMap.put(methodParameterList.get(i + 1), methodParameterList.get(i));
            }
        }
        System.out.println("Die Parameter dieser Methode sind : " + methodParameterMap);
    }

    public String getMethodReturnType() {
        return methodReturnType;
    }

    public Map<String, String> getMethodParameterMap() {
        return methodParameterMap;
    }

    public int getMethodID() {
        return methodID;
    }

    public String getMethodName() {
        return methodName;
    }

}
