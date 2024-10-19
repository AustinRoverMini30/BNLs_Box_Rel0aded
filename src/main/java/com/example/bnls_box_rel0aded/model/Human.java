package com.example.bnls_box_rel0aded.model;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

import java.util.Map;

public class Human extends Player {

	public Human(String pseudo, String symbole, String image) {
		super(pseudo, symbole, image);
		// TODO Auto-generated constructor stub
	}

	public Square play(GameGrid gameGrid, MouseEvent mouseEvent, Map<Node, Square> dic) {

		return dic.get(mouseEvent.getSource());

	}

}
