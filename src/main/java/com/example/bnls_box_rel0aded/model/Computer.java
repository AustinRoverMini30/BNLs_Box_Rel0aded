package com.example.bnls_box_rel0aded.model;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.util.Map;
import java.util.Random;

public class Computer extends Player {

	private final boolean clever;

	public Computer(String pseudo, String symbole, String image, boolean clever) {
		super(pseudo, symbole, image);
		this.clever = clever;
	}

	public Square play(GameGrid gameGrid, MouseEvent mouseEvent, Map<Node, Square> dic) {

		Random rand = new Random();
		int temp = rand.nextInt(gameGrid.getSize());
		int temp1 = rand.nextInt(gameGrid.getSize());

		return gameGrid.getCase(temp, temp1);
	}

}
