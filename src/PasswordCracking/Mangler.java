package PasswordCracking;

import java.util.ArrayList;

/**
 * Created by daseel on 2016-05-16.
 */
public class Mangler {

    static ArrayList<String> singleMangledList(ArrayList<String> dict) {

        // Not implemented since it might be too slow

        return null;
    }

    static ArrayList<String> doubleMangledList(ArrayList<String> dict) {

        // Not implemented since it might be too slow
        return singleMangledList(singleMangledList(dict));
    }

    private static ArrayList<String> deleteFirst(ArrayList<String> wordlist) {

        ArrayList<String> delFirstList = new ArrayList<>();

        for (String s : wordlist)
            delFirstList.add(s.substring(1));

        return delFirstList;
    }

    private static ArrayList<String> deleteLast(ArrayList<String> wordlist) {

        ArrayList<String> delLastList = new ArrayList<>();

        for (String s : wordlist)
            delLastList.add(s.substring(0, s.length() - 1));

        return delLastList;

    }

    private static ArrayList<String> reverse(ArrayList<String> wordlist) {

        ArrayList<String> reverseList = new ArrayList<>();

        for (String s : wordlist) {
            reverseList.add(new StringBuilder(s).reverse().toString());
        }

        return reverseList;
    }

    private static ArrayList<String> duplicate(ArrayList<String> wordlist) {
        ArrayList<String> duplicateList = new ArrayList<>();

        for (String s : wordlist)
            duplicateList.add(s + s);

        return duplicateList;
    }

    private static ArrayList<String> reflect(ArrayList<String> wordlist) {

        ArrayList<String> reflectList = new ArrayList<>();

        for (String s : wordlist) {

            String rev = new StringBuilder(s).reverse().toString();

            reflectList.add(s + rev);
            reflectList.add(rev + s);
        }
        return reflectList;
    }

    private static ArrayList<String> uppercase(ArrayList<String> wordlist) {

        ArrayList<String> uppercaseList = new ArrayList<>();

        for (String s : wordlist)
            uppercaseList.add(s.toUpperCase());

        return uppercaseList;
    }

    private static ArrayList<String> lowerCase(ArrayList<String> wordlist) {
        ArrayList<String> lowercase = new ArrayList<>();

        for (String s : wordlist)
            lowercase.add(s.toLowerCase());

        return lowercase;
    }

    private static ArrayList<String> nCapitalize(ArrayList<String> wordlist) {

        ArrayList<String> nCapList = new ArrayList<>();

        for (String s : wordlist) {

            char first = Character.toLowerCase(s.charAt(0));
            nCapList.add(first + s.substring(1).toUpperCase());
        }

        return nCapList;
    }

    private static ArrayList<String> toggleCase(ArrayList<String> wordlist) {

        ArrayList<String> toggleCaseList = new ArrayList<>();

        for (String s : wordlist) {
            s = s.toLowerCase();
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
        }

        return toggleCaseList;
    }

    private static ArrayList<String> prepend(ArrayList<String> worldlist){

        ArrayList<String> prependList = new ArrayList<>();

        for(int i = 33; i <= 126; i++){
            for(String s : worldlist){

                prependList.add(Character.toChars(i)[0] +  s);
            }

        }

        return prependList;
    }

    private static ArrayList<String> append(ArrayList<String> worldlist){

        ArrayList<String> prependList = new ArrayList<>();

        for(int i = 33; i <= 126; i++){
            for(String s : worldlist){

                prependList.add(s + Character.toChars(i)[0]);
            }

        }

        return prependList;
    }
}
