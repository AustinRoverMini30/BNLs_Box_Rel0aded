package com.example.bnls_box_rel0aded.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

	public Player player1;
	public Player player2;
	
	int current;

	String status;
	
	List<Player> playerList;
	
	GameGrid gameGrid;
	
	public boolean running;

	public Game(Player player1, Player player2, int gridSize, double x, double y, int choice) {
		super();
		this.player1 = player1;
		this.player2 = player2;
		
		playerList = new ArrayList<Player>();
		
		playerList.add(player1);
		playerList.add(player2);

		if (choice == 0){
			this.current = choice;
		}
		if (choice == 1){
			this.current = choice;
		}
		if (choice == 2){
			Random rand = new Random();
			this.current = rand.nextInt(playerList.size());
		}

		this.running = true;

		status = "C'est à " + playerList.get(current) + " de commencer";
		
		gameGrid = new GameGrid(gridSize, x, y);
	}
	
	public void run(Coord coord) {

		Square selectedSquare = gameGrid.getCase(coord.getX(), coord.getY());

		if (selectedSquare.getValue().equals("F") && running){
			selectedSquare.setValue(playerList.get(current).getSymbole());
			selectedSquare.setImage(playerList.get(current).getImage());

			if (gameGrid.checkGame(selectedSquare)){
				status = playerList.get(current) + " a gagné !";
				running = false;
				playerList.get(current).setScore(getPlayer().getScore()+1);
				playerList.get(current).win();
			} else if (gameGrid.isFull()) {
				status = "Match nul !";

				running = false;
			} else{
				current = (current+1) % playerList.size();
				status = "C'est à " + playerList.get(current) + " de jouer";
			}
		}

	}

	public GameGrid getGrid(){
		return gameGrid;
	}

	public Player getPlayer(){
		return playerList.get(current);
	}

	public String getStatus() {
		return status;
	}
}
