package PasswordCracking;

/**
 * Created by daseel on 2016-05-16.
 */
public class Password {

    private String salt;
    private String digestString;
    private String surname;
    private String lastname;

    Password(String passWordFileEntry){

        String[] strings = passWordFileEntry.split(":");
        salt = strings[1].substring(0, 2);
        digestString = strings[1].substring(2);
        surname = strings[4].split(" ")[0];
        lastname= strings[4].split(" ")[1];
    }


    String getSalt(){
        return salt;
    }


    String getDigestString(){

        return digestString;
    }

    String getSurName(){
        return surname;
    }

    String getLastName(){

        return lastname;
    }
}
