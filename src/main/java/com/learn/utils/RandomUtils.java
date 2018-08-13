package com.learn.utils;

import java.security.SecureRandom;

public class RandomUtils {
    private static SecureRandom random=new SecureRandom();
    public String getRandomFileName(){
        long millis=System.currentTimeMillis();
        int end3=random.nextInt(999);
        return  millis+String.format("%03d",end3);
    }
}
