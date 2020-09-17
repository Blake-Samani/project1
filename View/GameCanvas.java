package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import View.GameScreen.GameState;

public class GameCanvas extends JPanel {

    public static int WIDTH = 500;
    public static int HEIGHT = 500;

    private GameScreen panel;

    public GameCanvas(GameScreen panel){
        this.panel = panel;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void paintComponent(Graphics g){ //must overide this method of JPanel which takes a graphics object// 
        super.paintComponent(g);    //must pass the graphics to the paint component function , then you can add your own custom stuff // super is used to call a superclass method, where JPanel is the superclass, and paint compennt is the superclass's method

        Graphics2D g2 = (Graphics2D) g; //typecasts g to a 2d graphics type

        GameScreen.GameState state = panel.getGameState();

        if(state == GameScreen.GameState.READY){
            g2.setColor(Color.blue);
            g2.setFont(new Font("Courier", Font.BOLD, 30));
            g2.drawString("Press <New> to Start", 100, 160);
            
        }else if(state == GameScreen.GameState.PLAYING){
            g2.setColor(Color.blue);
            g2.setFont(new Font("Courier", Font.BOLD, 40));
            g2.drawString("Health Level", 50, 50);
            for(int i = 0; i < 5; i++){
            g2.drawRect(i * 60 + 50, 80, 50, 50);
            g2.fillRect(i * 60 + 50, 80, 50, 50);
          
            }
            
        }

    }
    
}
