package com.company;
import java.util.Random;
public class Message {
    int[] d;
    public Message(int k){
        d=new int[k];
        create(k);
    }
    int[] getD(){
        return d;
    }

    void create(int k){
        Random rand = new Random();
        for(int i=0;i<k;i++){
            d[i]=rand.nextInt(2);
            System.out.println(d[i]);
        }

    }
}
