package com.company;


import java.util.Scanner;

public class Sender {
    Scanner scan = new Scanner(System.in);
    int[][] data;
    int[][] datafcs;
    int a;
    int k;
    int pl;
    int[] p;
    public Sender(){
        System.out.println("Type the number of messages:");
        a = scan.nextInt();
        System.out.println("Type the number of each message's length");
        k = scan.nextInt();
        dataFiller(a,k);
        System.out.println("Type the length of the divider used for error check (WARNING:length must be shorter than the given message length.):");
        pl=scan.nextInt();
        dividerScan(pl);
        for (int i=0;i<a;i++){
            CRC x = new CRC(data[i],p);
            datafcs[i]=x.getDataFcs();
        }
    }
    void dataFiller(int a, int k){
        for (int i=0;i<a;i++){
            Message msg = new Message(k);
            data[i]=msg.getD();
        }
    }
    void dividerScan(int pl){
        System.out.println("Type the divider bits one by one:");
        for (int i=0;i<pl;i++){
            p[i]=scan.nextInt();
        }
    }
}
