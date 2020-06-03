package com.company;

import org.apache.commons.lang3.ArrayUtils;


public class CRC {
    int[] datafcs;
    public CRC(int[] data,int[] p) {
        int pl=p.length-1;
        int fcs[]=new int[pl];
        fcs=divide(data, p);
        System.out.println("\nThe CRC code generated is:");
        datafcs= ArrayUtils.addAll(data,fcs);
        for(int i=0;i<datafcs.length;i++){
            System.out.println(datafcs[i]);
        }
    }
    int[] divide(int data[], int p[]) {
        int[] datad=new int[data.length];
        int pl=p.length;
        int[] rem=new int[pl];
        System.arraycopy(data,0,datad,0,data.length);
        for (int i=0;i<pl-1;i++){
            datad=addX(datad.length,datad,0);
        }
        System.arraycopy(datad,0,rem,0,pl);
        int pick=pl;
        while (pick<datad.length){
            for(int i=0;i<pl;i++){
                rem[i]=exor(p[i],rem[i]);
            }
            while ((rem[0]==0)&&(pick<datad.length)){
                for (int i=0;i<pl-1;i++){
                    rem[i]=rem[i+1];
                }
                pick++;
                rem[pl-1]=datad[pick-1];
            }
        }
        for(int i=0;i<rem.length;i++){
            System.out.println(rem[i]);
        }
        int[] fcs=new int[pl-1];
        for (int i=0;i<fcs.length;i++){
            fcs[i]=rem[i+1];
        }
        return fcs;
    }

    int exor(int a, int b) {
        // This function returns the exor of two bits
        if (a == b) {
            return 0;
        }
        return 1;
    }

    public int[] addX(int n, int arr[], int x)
    {
        int newarr[] = new int[n + 1];
        for (int i = 0; i < n; i++){
            newarr[i] = arr[i];
        }
        newarr[n] = x;
        return newarr;
    }
    int[] getDataFcs(){
        return datafcs;
    }
}