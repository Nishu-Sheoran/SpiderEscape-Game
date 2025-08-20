package com.Nishu.gaming;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.Nishu.gaming.sprites.player;
import com.Nishu.gaming.sprites.spider;

public class Board extends JPanel{
	Timer timer;
	BufferedImage backgroundImage;
	player player;
	spider spiders[] = new spider[3];
     public Board() {
    	 setSize(1600,870);
    	 loadBackgroundImage();
    	 player= new player();
    	 loadSpiders();
    	 gameLoop();
    	 
    	 bindEvents(); 
    	 setFocusable(true);
    	 
     }
     private void gameOver(Graphics pen) {
    	 if(player.outOfScreen()) {
    		 pen.setFont(new Font("times", Font.BOLD, 30));
			 pen.setColor(Color.RED);
			 
			 pen.drawString("Game Win", 1600/2, 870/2 );
			 timer.stop();
			 return;
    	 }
        for(spider enemy: spiders) {
    		 if(isCollide(enemy)) {
    			 pen.setFont(new Font("times", Font.BOLD, 30));
    			 pen.setColor(Color.RED);
    			 
    			 pen.drawString("Game Over", 1600/2, 870/2 );
    			 timer.stop();
    			 return;
    		 }
    	 }
     }
     
     private boolean isCollide(spider enemy) {
    	 int xDistance = Math.abs(player.x- enemy.x);
    	 int yDistance = Math.abs(player.y - enemy.y);
    	 int maxH= Math.max(player.h,  enemy.h);
    	 int maxW= Math.max(player.w,  enemy.w);
    	 return xDistance<= maxW-150 && yDistance <= maxH-150;
    	 
     }
     
     private void bindEvents() {
    	    addKeyListener(new KeyListener() {
    	        @Override
    	        public void keyTyped(KeyEvent e) {
    	            // handle keyTyped event
    	        }

    	        @Override
    	        public void keyPressed(KeyEvent e) {
    	        	// handle keyPressed event
    	        	if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
    	        		player.speed=10;
    	        	}
    	        	else if(e.getKeyCode() == KeyEvent.VK_LEFT){
    	        		player.speed= -10;
    	        	}
    	            
    	        }

    	        @Override
    	        public void keyReleased(KeyEvent e) {
    	        	player.speed=0;
    	            // handle keyReleased event
    	        }
    	    });
    	}

     private void loadSpiders() {
    	 int x= 400;
    	 int gap=400;
    	 int speed= 5;
    	for(int i=0; i<spiders.length; i++) {
    		spiders[i]= new spider(x, speed);
    		x=x+gap;
    		speed= speed+5;
    	}
     }
     private void gameLoop() {
    	 timer = new Timer(50, (e)->repaint());
    	 timer.start();
     }
     private void loadBackgroundImage() {
    	 try {
    		 backgroundImage = ImageIO.read(Board.class.getResource("game-bg.jpg"));
		 } catch (IOException e) {
			 System.out.println("Background Image not Found..");
			 System.exit(1);
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
     }
     
     private void printSpiders(Graphics pen) {
    	 for(spider enemy: spiders) {
    		 enemy.draw(pen);
    		 enemy.move();
    	 }
     }
     @Override
     public void paintComponent(Graphics pen){
    	 
    	super.paintComponent(pen); // cleanup
    	// all printing logic will be here
    	 pen.drawImage(backgroundImage,0,0,1600, 870,null);
    	 gameOver(pen);
         player.draw(pen);
         player.move();
         printSpiders(pen);
         
         
     }
}
