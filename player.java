package com.Nishu.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class player extends Sprite {
      
      public player() {
    	  w=200;
    	  h=250;
    	  x=50;
    	  y=500;
    	  image= new ImageIcon(player.class.getResource("player.gif"));
    	  
      }
      public void move() {
    	  x=x+speed;
    	  
      }
      public boolean outOfScreen() {
    	  return x>1600;
      }
}
