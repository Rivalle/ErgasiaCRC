package com.company;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Scanner;

public class CRC {
    int[] datafcs;
    Scanner scan = new Scanner(System.in);
    public CRC(int[] data,int[] p) {
        int fcs[] = divide(data, p);
        System.out.println("\nThe CRC code generated is:");
        datafcs= ArrayUtils.addAll(data,fcs);
        for(int i=0;i<datafcs.length;i++){
            System.out.println(datafcs[i]);
        }

    }
    int[] divide(int old_data[], int p[]) {
        int remainder[] , i;
        int data[] = new int[old_data.length + p.length];
        System.arraycopy(old_data, 0, data, 0, old_data.length)
        // Remainder array stores the remainder
        remainder = new int[p.length];
        // Initially, remainder's bits will be set to the data bits
        System.arraycopy(data, 0, remainder, 0, p.length);
        // Loop runs for same number of times as number of bits of data
        // This loop will continuously exor the bits of the remainder and
        // p
        for(i=0 ; i < old_data.length ; i++) {
            if(remainder[0] == 1) {
                // We have to xor the remainder bits with p bits
                for(int j=1 ; j < p.length ; j++) {
                    remainder[j-1] = exor(remainder[j], p[j]);
                }
            }
            else {
                // We have to xor the remainder bits with 0
                for(int j=1 ; j < p.length ; j++) {
                    remainder[j-1] = exor(remainder[j], 0);
                }
            }
            // The last bit of the remainder will be taken from the data
            // This is the 'carry' taken from the dividend after every step
            // of division
            remainder[p.length-1] = data[i+p.length];
        }
        return remainder;
    }

    int exor(int a, int b) {
        // This function returns the xor of two bits
        if (a == b) {
            return 0;
        }
        return 1;
    }
    int[] getDataFcs(){
        return datafcs;
    }
}