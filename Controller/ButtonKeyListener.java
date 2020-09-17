package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Model.GuessGame;
import View.GameScreen;



public class ButtonKeyListener implements ActionListener{

    private GameScreen panel;
    private GuessGame game;
    private int clicks = 5;

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
           panel.getGuessField().setVisible(true); 
       
           for (var b: panel.getButtons()){
            b.setEnabled(true); 
            }

           window.pack();
           window.revalidate();
           panel.getCanvas().repaint();

        } 

        if(button.getText().length() <= 1){
           button.setEnabled(false);
           game.setGuesser(button.getText()); //sets our guesser to the text of the button
           game.convertKeyToCharArray();//this function converts our keyword to a char array, then compares each element to our guesser, if the guesser has the same value as keyword,we update our guess array
           panel.setGuessField(); // update jtextfield
           if(game.keyExists() == false){
           clicks--;
           panel.setClicks(clicks);
           panel.getCanvas().repaint(); 
           }
           
        }
        if(panel.getGuessField().getText().equals(panel.getGameKeyField().getText())){ // this .equals compares the two textfields
            panel.setGameState(GameScreen.GameState.WIN);
            panel.getCanvas().repaint();
            for (var b: panel.getButtons()){
                b.setEnabled(false); 
            }
            
        } 
        if(clicks == 0){
            panel.setGameState(GameScreen.GameState.GAMEOVER); //disable all buttons except new on gameover condition
            for (var b: panel.getButtons()){
                b.setEnabled(false); 
            }
            panel.getCanvas().repaint();
        }   
            
            
    }

   
       

}
       

    

    
    

