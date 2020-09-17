package View;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


import Controller.ButtonKeyListener;
import Model.GuessGame;

public class GameScreen {

    public enum GameState{
        READY, PLAYING, GAMEOVER, WIN
    }
    
    private JFrame window;
    private JTextField gameKeyField = new JTextField(); 
    private JTextField guessField = new JTextField();
    private JButton[] buttons;
    private JButton newButton = new JButton("New");
    private String abc = "abcdefghijklmnopqrstuvwxyz";
    private String guesser = "";
    private int clickCounter = 5;
 
    private GameCanvas canvas;
    private GameState gameState = GameState.READY;
    private GuessGame game = new GuessGame();
    
    public GameScreen(JFrame window) {
        this.window = window;
    }



    public void init(){
        Container cp = window.getContentPane(); //container to hold

        JPanel northPanel = new JPanel(); //northpanel
        northPanel.setLayout(new GridLayout(2,1));

        gameKeyField.setText(game.getWord()); //sets text of our field to our randomly generated word from game
        gameKeyField.setVisible(false);
        gameKeyField.setFont(new Font("Courier", Font.BOLD, 16));
        gameKeyField.setForeground(Color.red);

        northPanel.add(gameKeyField);
        northPanel.add(guessField);
        northPanel.setLayout(new GridLayout(2, 1));
        guessField.setFont(new Font("Courier", Font.BOLD, 16));
        guessField.setText(new String(game.getGuessArray())); //sets our jtext guess field to our getGuessArray
        guessField.setVisible(false);
 
        System.out.println(guesser);

        guessField.setEditable(false);
        

        cp.add(BorderLayout.NORTH, northPanel);

        canvas = new GameCanvas(this); // MUST PASS THIS PANEL INTO GAMECANVAS!!!!!!!

        cp.add(BorderLayout.CENTER, canvas);

        JPanel southPanel = new JPanel();//southpanel
        southPanel.setLayout(new GridLayout(4,7));
        buttons = new JButton[abc.length()];

        ButtonKeyListener keyListener = new ButtonKeyListener(this);

        for(int i = 0; i < abc.length(); i++) {
            buttons[i] = new JButton("" + abc.charAt(i)); //here, each alpabet letter will be put onto the button, the "" converts to string
            southPanel.add(buttons[i]); //add all the buttons to southpanel
            buttons[i].addActionListener(keyListener); //give all the buttons actions
            buttons[i].setEnabled(false);
        }
        

        newButton.addActionListener(keyListener);
        southPanel.add(newButton);
        cp.add(BorderLayout.SOUTH, southPanel);

    }

    public GameState getGameState(){
        return gameState;
    }

    public JButton[] getButtons(){
        return buttons;
    }

    public JButton getNewButton(){
        return newButton;
    }

    public void setGameState(GameState state){
        this.gameState = state;
    }

    public GameCanvas getGameCanvas(){
        return canvas;
    }

    public JTextField getGameKeyField(){
        return gameKeyField;
    }

    public JTextField getGuessField(){
        return guessField;
    }

    public void setGuessField(){
        guessField.setText(new String(game.getGuessArray()));
    }

    public JFrame getWindow(){
        return window;
    }
    public GameCanvas getCanvas(){
        return canvas;
    }

    public void setClicks(int k){
        clickCounter = k;
    }

    public int getClicks(){
        return clickCounter;
    }

    public void setGame(GuessGame g){
        game = g;
    }

    public GuessGame getGame(){
        return game;
    }

}
