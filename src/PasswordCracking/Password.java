package PasswordCracking;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by daseel on 2016-05-16.
 */
public class Password {

    private String salt;
    private String digestString;
    private ArrayList<String> GCOS;

    Password(String passWordFileEntry) {

        String[] strings = passWordFileEntry.split(":");
        salt = strings[1].substring(0, 2);
        digestString = strings[1];
        GCOS = new ArrayList<String>(Arrays.asList(strings[4].split(" ")));

    }


    String getSalt() {
        return salt;
    }


    String getDigestString() {

        return digestString;
    }

    ArrayList<String> getGCOS() {

        return GCOS;
    }
}
