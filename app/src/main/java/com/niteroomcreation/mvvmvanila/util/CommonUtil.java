package com.niteroomcreation.mvvmvanila.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Septian Adi Wijaya on 01/04/2021.
 * please be sure to add credential if you use people's code
 */
public class CommonUtil {

    public static final String TAG = CommonUtil.class.getSimpleName();


    public static String constructRandomAlphabet(int length) {
        List<String> characters = new ArrayList<>();
        //space character
        characters.add(Character.toString((char) 32));

        for (int i = 65; i < 91; i++) {
            characters.add(Character.toString((char) i));
        }

        String sb = constructWithSpace(characters, length);
        while (!sb.contains(" ")) {
            sb = constructWithSpace(characters, length);
        }

        return sb;
    }

    private static String constructWithSpace(List<String> characters, int length) {

        //5 + (int)(Math.random() * ((10 - 5) + 1))
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(characters.get(0 + (int) (Math.random() * (26 - 0) /*+ 1*/)));
        }

        return sb.toString();
    }

}
