package com.wfx.util;

import java.util.Random;

public class VerifyCodeUtil {
    public static final String VERIFY_CODES = "asdfsxf12312ad335432wqwe";

    public static String generateVerifyCode(int verifySize) {

        int codesLen = VERIFY_CODES.length();
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder verifyCode = new StringBuilder(verifySize);
        for (int i = 0; i < verifySize; i++) {
            verifyCode.append(VERIFY_CODES.charAt(rand.nextInt(codesLen - 1)));
        }
        return verifyCode.toString();
    }

    public static void main(String[] args) {
        System.out.println(VerifyCodeUtil.generateVerifyCode(4));

    }
} 