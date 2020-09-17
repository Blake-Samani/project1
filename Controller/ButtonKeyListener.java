package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import Model.GuessGame;
import View.GameScreen;
import View.GameScreen.GameState;


public class ButtonKeyListener implements ActionListener{

    private GameScreen panel;
    private GuessGame game;
    private String guessCharSt;
    private String guess;
    private String key;
    private ArrayList<String> guessAr;
    private String keyAr;

    public ButtonKeyListener(GameScreen panel){
        this.panel = panel;
        game = panel.getGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        System.out.println(button.getText());

        if(button == panel.getNewButton()){
            
           game = new GuessGame();
           JFrame window = panel.getWindow();
           window.getContentPane().removeAll();
           panel = new GameScreen(window);
           panel.init();
           panel.setGameState(GameScreen.GameState.PLAYING);
           panel.getGameKeyField().setVisible(true);
           key = panel.getGameKeyField().getText();
           panel.getGuessField().setVisible(true); 
           guess = panel.getGuessField().getText();

           for (var b: panel.getButtons()) {
            b.setEnabled(true); 
            }

           window.pack();
           window.revalidate();
           panel.getCanvas().repaint();

        } 

        if(button.getText().length() <= 1){
           game.setGuesser(button.getText()); //sets our guesser to the text of the button
           game.convertKeyToCharArray();//this function converts our keyword to a char array, then compares each element to our guesser, if the guesser has the same value as keyword,we update our guess array
           panel.setGuessField(); // update jtextfield

        }
        
            
    }

}
       

    

    
    

