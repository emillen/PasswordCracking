package PasswordCracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCracker {

    public static void main(String[] args) {

        /*if (args.length != 1) {
            System.out.println("Usage: PasswordCracker <passwordFileName>");
            return;
        }*/

        String dict = "/home/daseel/cracker/dict.txt";
        String pwdfile = "/home/daseel/cracker/passwd2.txt";

        ArrayList<String> wordList;
        ArrayList<Password> passwordList;

        try {
            wordList = getWordList(dict);
            passwordList = getPasswordList(pwdfile);
        } catch (Exception e) {

            System.out.println("File not found");
            return;
        }


        addGCOS(passwordList, wordList);
        System.out.println("First round!  Passwords left: " + passwordList.size() + "  words to try: " + wordList.size());
        passwordList = hackPasswordsBreh(passwordList, wordList);

        System.out.println("Second round!  Passwords left: " + passwordList.size() + "  words to try: " + wordList.size());
        wordList = getMangles(wordList);
        passwordList = hackPasswordsBreh(passwordList, wordList);

        System.out.println("Third round!  Passwords left: " + passwordList.size() + "  words to try: " + wordList.size());
        wordList = getMangles(wordList);
        passwordList = hackPasswordsBreh(passwordList, wordList);

    }

    private static ArrayList<String> getMangles(ArrayList<String> words) {

        ArrayList<String> mangles = new ArrayList<>();
        for (String s : words)
            mangles.addAll(Mangler.createMangleList(s));

        return mangles;
    }

    private static void addGCOS(ArrayList<Password> passwords, ArrayList<String> words) {

        for (Password pass : passwords)
            words.addAll(pass.getGCOS());
    }

    private static ArrayList<Password> hackPasswordsBreh(ArrayList<Password> passwords, ArrayList<String> words) {

        for (String s : words) {
            ArrayList<Password> failed = new ArrayList<>();
            for (Password pass : passwords) {
                if (isPassphrase(pass, s)) {
                    System.out.println(s);
                    continue;
                }

                failed.add(pass);
            }

            passwords = failed;
        }

        return passwords;

    }

    private static boolean isPassphrase(Password pass, String passphrase) {

        return JCrypt.crypt(pass.getSalt(), passphrase).equals(pass.getDigestString());
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
