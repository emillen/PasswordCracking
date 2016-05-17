package PasswordCracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCracker {

    public static void main(String[] args) {

        /*if (args.length != 2) {
            System.out.println("Usage: PasswordCracker <passwordFileName> <dictionaryFileName>");
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
        System.out.println("Creating le mangles\n");
        getMangles(wordList);
        System.out.println("Done with le mangles\n");
        hackPasswordsBreh(passwordList, wordList);
    }

    private static void getMangles(ArrayList<String> words){

        ArrayList<String> mangles = new ArrayList<>();
        for(String s : words)
            mangles.addAll(Mangler.createMangleList(s));

        words.addAll(mangles);

        for(String s : mangles)
            words.addAll(Mangler.createMangleList(s));
    }

    private static void addGCOS(ArrayList<Password> passwords, ArrayList<String> words){

        for(Password pass : passwords)
            words.addAll(pass.getGCOS());
    }

    private static void hackPasswordsBreh(ArrayList<Password> passwords, ArrayList<String> words){

        for(String s : words){
            ArrayList<Password> failed = new ArrayList<>();
            for(Password pass : passwords){
                if(isPassphrase(pass, s)){
                    System.out.println(s);
                    continue;
                }

                failed.add(pass);
            }

            passwords = failed;
        }
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
