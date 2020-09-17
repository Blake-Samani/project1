package Test;

import java.util.ArrayList;

import Model.GuessGame;

public class Test {

    
    
    public static void main(String[] args){

    GuessGame geym = new GuessGame();
    geym.printArray();
    System.out.println(" Random Key is " + geym.getRandKey());
    int checker = 0;

    ArrayList<String> tester = new ArrayList<String>();

    tester = geym.getArray();

    for(var e: tester){
        System.out.println("INDEX: " + checker +"  " +  e);
        checker++;
    }

    System.out.println("Game key is " + geym.getWord() + " At location " + geym.getRandKey());

    String a = "four";
    String k = "";

    for(int i = 0; i < a.length(); i++){
        k += ".";
    }

    System.out.println(k);

    geym.setGuesser("a");

    System.out.println("GUESSER CHARACTER IS :  " + geym.getGuesser());

    System.out.println("CHARACTER GUESS ARRAY IS : " + new String(geym.getGuessArray()));

    }
    
}
