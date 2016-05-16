package PasswordCracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCracker {

    public static void main(String[] args){

        Password pwd = new Password("tyler:<qt0.GlIrXuKs:503:503:Tyler Jones:/home/tyler:/bin/tcsh");

        System.out.println(pwd.getSalt());
        System.out.println(pwd.getDigestString());
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
