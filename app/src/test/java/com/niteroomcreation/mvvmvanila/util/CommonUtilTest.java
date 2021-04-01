package com.niteroomcreation.mvvmvanila.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Septian Adi Wijaya on 01/04/2021.
 * please be sure to add credential if you use people's code
 */
public class CommonUtilTest {

    @Test
    public void constructRandomAlphabet() {

        String ex = "";
        String ac = CommonUtil.constructRandomAlphabet(15);

        Assert.assertEquals(ex, ac);

    }
}