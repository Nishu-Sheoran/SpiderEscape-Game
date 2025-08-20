package com.Nishu.gaming.sprites;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class spider extends Sprite {
	
    public spider(int x, int speed) {
    	y=10;
    	this.x=x;
    	this.speed= speed;
    	w=150;
    	h=150;
    	image = new ImageIcon(spider.class.getResource("spider.gif"));
    	
    }
    public void move() {
    	if(y>870) {
    		y=0;
    	}
    	y=y+speed; 
    }
    
}
