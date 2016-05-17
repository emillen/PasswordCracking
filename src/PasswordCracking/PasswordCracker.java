package PasswordCracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCracker {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: PasswordCracker <passwordFileName> <dictionaryFileName>");
            return;
        }
        ArrayList<String> wordList;
        ArrayList<Password> passwordList;

        try {
            wordList = getWordList(args[1]);
            passwordList = getPasswordList(args[0]);

        } catch (Exception e) {

            System.out.println("File not found");
            return;
        }
    }

    private static ArrayList<Password> getPasswordList(String fileName) throws FileNotFoundException {

        ArrayList<String> stringList = getWordList(fileName);
        ArrayList<Password> passwordList = new ArrayList<>();
        for (String s : stringList)
            passwordList.add(new Password(s));

        return passwordList;
    }

    private static ArrayList<String> getWordList(String fileName) throws FileNotFoundException {

        Scanner s = new Scanner(new File(fileName));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();

        return list;
    }
}
