package com.samson.onlineshop.domain;

import java.util.Arrays;

public class Flaten {
    private static Integer[] output = new Integer[3];
    private static int j = 0;
    public static void main(String[] args) {
        System.out.println(Arrays.asList(flat(new Object[]{1,2,3})));

    }

    private static Integer[] flat(Object[] inputs){



        for(Object input: inputs){

            if(input instanceof Integer)
                output[j++] = (Integer) input;
            else
                flat(new Object[]{input});
        }

        return output;
    }
}
