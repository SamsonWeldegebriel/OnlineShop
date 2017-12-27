package com.samson.onlineshop.domain;

import java.util.Arrays;

public class Flaten {
    static Integer[] output = new Integer[3];
    static int j = 0;
    public static void main(String[] args) {
        System.out.println(Arrays.asList(flat(new Object[]{1,2,3})));

    }

    public static Integer[] flat(Object[] input){



        for(int i=0; i< input.length; i++){

            if(input[i] instanceof Integer)
                output[j++] = (Integer) input[i];
            else
                flat(new Object[]{input[i]});
        }

        return output;
    }
}
