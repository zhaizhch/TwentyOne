package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {
    public static int[][] cards=new int[52][2];
    public static ArrayList<Integer> Gamer=new ArrayList<>();
    public static ArrayList<Integer> Computer=new ArrayList<>();
    public static int GamerScore=0;
    public static int ComputerScore=0;
    public static void cardsInit(){
        for(int i=0;i<52;i++){
            cards[i][0]=i%13+1;
            cards[i][1]=1;
            if(cards[i][0]>10){
                cards[i][0]=10;
            }
        }
        Gamer.clear();
        Computer.clear();
        GamerScore=0;
        ComputerScore=0;

    }
    public static int getCard(){
        int card;
        while(true){
            int random=(int) (Math.random()*52);
            if(cards[random][1]==1){
                card=cards[random][0];
                cards[random][1]=0;
                break;
            }
        }
        return card;
    }
    public static int Game(){
        System.out.println("游戏正式开始：");
        int isVictory=0;

        while(true){
            Scanner in = new Scanner(System.in);
            int flag=in.nextInt();
            if(flag==1)
            {
                int number=getCard();
                Gamer.add(number);
                GamerScore+=number;
                System.out.print("玩家牌为："+Gamer);
                System.out.println(" 玩家得分为:"+GamerScore);
            }
            else{
                break;
            }
        }
        while(true){
            int number=getCard();
            Computer.add(number);
            ComputerScore+=number;
            System.out.print("电脑牌为："+Computer);
            System.out.println(" 电脑得分为:"+ComputerScore);
            if(ComputerScore>=GamerScore)
            {
                break;
            }
        }
        if(ComputerScore>21&&GamerScore<=21)
        {
            System.out.println("玩家胜利");
            return 1;
        }
        else if(ComputerScore==GamerScore)
        {
            System.out.println("平局");
            return 0;
        }
        else if(GamerScore>21||ComputerScore<=21)
        {
            System.out.println("电脑胜利");
            return -1;
        }
        return 0;
    }


    public static void main(String[] args) {
        int num=0;
        for(int i=0;i<10000;i++){
            cardsInit();
            num+=Game();
        }
        System.out.println(num);

    }

}
