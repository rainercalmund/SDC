package com.felsch.SDC.misc;

import java.util.ArrayList;
import java.util.List;

public class SDCConstants {

    public static final String JAVATOKEN_PUBLIC = "public";
    public static final String JAVATOKEN_PROTECTED = "protected";
    public static final String JAVATOKEN_PRIVATE = "private";
    public static final String JAVATOKEN_STATIC = "static";
    public static final String JAVATOKEN_BRACKETOPEN = "(";
    public static final String JAVATOKEN_BRACKETCLOSED = ")";

    public static List<String> getJavaTokenConstants() {
        List<String> javaToken = new ArrayList<>();
        javaToken.add(JAVATOKEN_PUBLIC);
        javaToken.add(JAVATOKEN_PRIVATE);
        javaToken.add(JAVATOKEN_PROTECTED);
        javaToken.add(JAVATOKEN_STATIC);
        javaToken.add(JAVATOKEN_BRACKETOPEN);
        javaToken.add(JAVATOKEN_BRACKETCLOSED);
        return javaToken;
    }

    public static boolean checkWordIsPartOfToken(String word) {
        if ((word.equals(SDCConstants.JAVATOKEN_PRIVATE) || word.equals(SDCConstants.JAVATOKEN_PROTECTED)
                || word.equals(SDCConstants.JAVATOKEN_PUBLIC) || word.equals(SDCConstants.JAVATOKEN_STATIC))
                || (word.contains(SDCConstants.JAVATOKEN_BRACKETOPEN)
                        || word.contains(SDCConstants.JAVATOKEN_BRACKETCLOSED))) {
            return true;
        }
        return false;
    }

}
