package PasswordCracking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCracker {


    private static String getSalt(String string) {

        int index = string.indexOf(":") + 1;

        return string.substring(index, index + 2);
    }

    private static ArrayList<String> getWordList(String fileName) throws FileNotFoundException {

        Scanner s = new Scanner(new File("filepath"));
        ArrayList<String> list = new ArrayList<>();
        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }
        s.close();

        return list;
    }
}
