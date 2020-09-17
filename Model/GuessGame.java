package Model;

import java.util.ArrayList;
import java.util.Random;


public class GuessGame {

    private ArrayList<String> gameKey = new ArrayList<String>();
    private int randKey;
    private char guesser;
    private char[] currentGuess;
    private char[] toCompare;
    private String keyWord;


    public GuessGame(){
        gameKey.add("communication");
        gameKey.add("science");
        gameKey.add("programming");
        gameKey.add("language");
        gameKey.add("difficulty");
        gameKey.add("artificial");
        gameKey.add("intelligence");
        gameKey.add("attempts");
        gameKey.add("screenshot");
        gameKey.add("baseball");
        gameKey.add("windows");
        gameKey.add("learning");
        gameKey.add("electronics");
        gameKey.add("beautiful");
        gameKey.add("internet");
        gameKey.add("database");
        gameKey.add("organization");
        gameKey.add("application");
        gameKey.add("network");
        gameKey.add("friendly");
        gameKey.add("validation");
        gameKey.add("attempts");
        gameKey.add("statistics");
        gameKey.add("physics");
        gameKey.add("chemistry");
        gameKey.add("engineering");
        gameKey.add("school");
        gameKey.add("industry");
        gameKey.add("revolution");
        gameKey.add("progress");
        gameKey.add("characters");
        gameKey.add("heavily");
        gameKey.add("graphics");

        Random r = new Random();
        randKey = r.nextInt(gameKey.size());
        keyWord = gameKey.get(randKey);
        currentGuess = new char[keyWord.length()];
        toCompare = new char[keyWord.length()];
        for(int i = 0; i < keyWord.length(); i++){ //initialize current guess array as dots, will be same length as chosen KEY WORD
            currentGuess[i] ='.';
        }
        
       
    }

    public void printArray(){
        for (var e: gameKey){
            System.out.println(e);
        }
        
    }

    public ArrayList<String> getArray(){
        return gameKey;
    }

    public int getRandKey(){
        return randKey;
    }

    public String getWord(){ //returns GAME KEY at random location determined by randkey variable
        return gameKey.get(randKey);
    }

    public void setGuesser(String a){
        guesser = a.charAt(0);
    }

    public char getGuesser(){
        return guesser;
    }

    public void convertKeyToCharArray(){ //this function converts our keyword to a char array, then compares each element to our guesser, if the guesser has the same value as keyword,we update our guess array
        
        for(int i = 0; i < keyWord.length(); i++){
            toCompare[i] = keyWord.charAt(i);
            if(guesser == toCompare[i]){
                currentGuess[i] =  guesser;
            }
        }
    }

    public char[] getGuessArray(){ //return the char array, NOTE, must convert to string with new String(c)
        
        return currentGuess;
    }

    public boolean keyExists(){
        for(int i = 0; i < keyWord.length(); i++){
            toCompare[i] = keyWord.charAt(i);
            if(guesser == toCompare[i]){
                return true;
            }
        }
        return false;
    }

    

}  

    
    

    

