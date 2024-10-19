package com.example.bnls_box_rel0aded.model;

//import com.fasterxml.jackson.databind.KeyDeserializer;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.util.Map;

public class Player {
	private final String pseudo;
	private int score;
	private String symbole;
	private String image;
	private int win;

	public Player(String pseudo, String symbole, String image) {
		super();
		this.pseudo = pseudo;
		this.symbole = symbole;
		this.score = 0;
		this.image = image;
		this.win = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	
	public String getSymbole() {
		return symbole;
	}

	@Override
	public String toString() {
		return pseudo;
	}

	public String getImage() {
		return image;
	}

	public boolean equals(Player unPlayer) {
		return this.symbole.equals(unPlayer.getSymbole());
	}

	public Square play(GameGrid gameGrid, MouseEvent mouseEvent, Map<Node, Square> dic) {

		return null;

	}

	public int getNbWin() {
		return win;
	}

	public void win(){
		this.win++;
	}

	public void setImage(String pathImagePlayer) {
		this.image = pathImagePlayer;
	}
}
