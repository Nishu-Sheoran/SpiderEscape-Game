package com.Nishu.gaming;

import javax.swing.JFrame;

public class GameFrame extends JFrame{

	public GameFrame() {
		Board board= new Board();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(" Game Dev in Java");
        setResizable(false);
        setSize(1600,870);
        setLocationRelativeTo(null);
        add(board);
        setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new GameFrame();
        
	}

}
