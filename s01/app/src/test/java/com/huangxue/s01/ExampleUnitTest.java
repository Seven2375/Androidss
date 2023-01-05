package com.huangxue.s01;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        String s = "/dev-api/profile/upload/2022/03/12/b3134a30-daac-4a85-acb1-8907b17122c4.jpeg";
        System.out.println(s.replace("dev","prod"));
    }
}