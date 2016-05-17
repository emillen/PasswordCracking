package PasswordCracking;

import java.util.ArrayList;

/**
 * Created by daseel on 2016-05-16.
 */

class Mangler {

    static ArrayList<String> createMangleList(String s) {

        ArrayList<String> mangleList = new ArrayList<>();
        mangleList.add(deleteFirst(s));
        mangleList.add(deleteLast(s));


        mangleList.add(reverse(s));
        mangleList.add(duplicate(s));
        mangleList.addAll(reflect(s));

        mangleList.add(uppercase(s));
        mangleList.add(lowerCase(s));

        mangleList.add(capitalize(s));
        mangleList.add(nCapitalize(s));
        mangleList.addAll(toggleCase(s));

        mangleList.addAll(append(s));
        mangleList.addAll(prepend(s));

        mangleList.add(s);

        return mangleList;
    }

    static String deleteFirst(String s) {

        return s.substring(1);
    }

    static String deleteLast(String s) {

        return s.substring(0, s.length() - 1);
    }

    static String reverse(String s) {


        return new StringBuilder(s).reverse().toString();
    }

    static String duplicate(String s) {

        return stripToEight(s + s);
    }

    static ArrayList<String> reflect(String s) {

        ArrayList<String> reflectList = new ArrayList<>();

        String rev = new StringBuilder(s).reverse().toString();

        reflectList.add(stripToEight(s + rev));
        reflectList.add(stripToEight(rev + s));

        return reflectList;
    }

    static String uppercase(String s) {
        return s.toUpperCase();
    }

    static String lowerCase(String s) {
        return s.toUpperCase();
    }

    static String capitalize(String s){
        char first = Character.toUpperCase(s.charAt(0));
        return first + s.substring(1);
    }

    static String nCapitalize(String s) {

        char first = s.charAt(0);
        return first + s.substring(1).toUpperCase();
    }

    static ArrayList<String> toggleCase(String s) {

        ArrayList<String> toggleCaseList = new ArrayList<>();

        StringBuilder toggled1 = new StringBuilder(s.length());
        StringBuilder toggled2 = new StringBuilder(s.length());
        for (int i = 0; i < s.length(); i++) {
            char letter1, letter2;
            letter1 = letter2 = s.charAt(i);
            if (i % 2 == 0)
                letter1 = Character.toUpperCase(letter1);
            else
                letter2 = Character.toUpperCase(letter2);
            toggled1.append(letter1);
            toggled2.append(letter2);
        }

        toggleCaseList.add(toggled1.toString());
        toggleCaseList.add(toggled2.toString());

        return toggleCaseList;
    }

    static ArrayList<String> prepend(String s) {

        ArrayList<String> prependList = new ArrayList<>();

        if (s.length() >= 8) {
            prependList.add(s);
            return prependList;
        }

        for (int i = 33; i <= 126; i++) {
            prependList.add(Character.toChars(i)[0] + s);
        }


        return prependList;
    }

    static ArrayList<String> append(String s) {

        ArrayList<String> appendList = new ArrayList<>();

        if (s.length() >= 8) {
            appendList.add(s);
            return appendList;
        }

        for (int i = 33; i <= 126; i++) {
            appendList.add(Character.toChars(i)[0] + s);
        }


        return appendList;
    }

    private static String stripToEight(String s) {

        if (s.length() > 8)
            return s.substring(0, 8);
        return s;
    }
}
