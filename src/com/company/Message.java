package com.company;
import java.util.Random;
public class Message {
    int [] d;
    int fcs;
    public Message(int k){
        create(k);
    }
    int[] getD(){
        return d;
    }

    void create(int k){
        Random rand = new Random();
        for(int i=0;i<k;i++){
            d[i]=rand.nextInt(2);
        }
    }
}
