package edu.studying.junit.presentation.a.basic.annotations;

public class BasicAnnotationsExample {

    public String concat(String... args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg);
        }
        return sb.toString();
    }

    public String concatWithSpace(String... args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg).append(" ");
        }
        return sb.toString().trim();
    }

}
