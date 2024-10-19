package com.example.bnls_box_rel0aded.model;

import java.util.*;

public class GameGrid {
	private final List<List<Square>> grid;
	private final int size;
	private final Map<Coord, Square> dic;
	private final double x;
	private final double y;

	public GameGrid(int size, double x, double y) {
		super();
		this.size = size;

		this.x = x / size;
		this.y = y / size;

		List<Square> temp = new LinkedList<Square>();
		grid = new LinkedList<List<Square>>();
		dic = new HashMap<Coord, Square>();
		Square square;
		Coord coord;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {

				coord = new Coord(j, i);
				square = new Square(coord, this.x, this.y);

				temp.add(square);
				dic.put(coord, square);
			}

			grid.add(temp);
			temp = new LinkedList<Square>();
		}
	}

	public void affiche() {
		for (List<Square> temp : grid) {
			for (Square uneSquare : temp) {
				System.out.print(uneSquare + "\t");
			}
			System.out.print("\n");
		}
	}

	public boolean getVert(Square square) {
		List<Square> temp = new LinkedList<Square>();
		List<Square> temp1 = new LinkedList<Square>();

		Coord coord = square.getCoord();
		Coord coordTemp;

		for (int i = coord.getY() - 2; i < coord.getY(); i++) {

			if (i >= 0 && i < size) {
				coordTemp = getCase(coord.getX(), i).getCoord();
				temp.add(dic.get(coordTemp));
			}
		}

		for (int i = coord.getY() + 1; i < coord.getY() + 3; i++) {

			if (i >= 0 && i < size) {
				coordTemp = getCase(coord.getX(), i).getCoord();
				temp1.add(dic.get(coordTemp));
			}
		}

		return check(coord, temp, temp1);
	}

	public boolean getHor(Square square) {
		List<Square> temp = new LinkedList<Square>();
		List<Square> temp1 = new LinkedList<Square>();

		Coord coord = square.getCoord();
		Coord coordTemp;

		for (int i = coord.getX() - 2; i < coord.getX(); i++) {

			if (i >= 0 && i < size) {
				coordTemp = getCase(i, coord.getY()).getCoord();
				temp.add(dic.get(coordTemp));
			}
		}

		for (int i = coord.getX() + 1; i < coord.getX() + 3; i++) {

			if (i >= 0 && i < size) {
				coordTemp = getCase(i, coord.getY()).getCoord();
				temp1.add(dic.get(coordTemp));
			}
		}

		return check(coord, temp, temp1);
	}

	public boolean getDiag1(Square square) {
		List<Square> temp = new LinkedList<Square>();
		List<Square> temp1 = new LinkedList<Square>();

		Coord coord = square.getCoord();
		Coord coordTemp;

		int count = 2;

		for (int i = coord.getY() - 2; i < coord.getY(); i++) {

			if (i >= 0 && i < size && coord.getX()- count >=0 && coord.getX()- count < size) {
				coordTemp = getCase(coord.getX()- count, i).getCoord();
				temp.add(dic.get(coordTemp));
				count--;
			}
		}

		count = 1;

		for (int i = coord.getY() + 1; i < coord.getY() + 3; i++) {

			if (i >= 0 && i < size && coord.getX()+ count >=0 && coord.getX()+ count < size) {
				coordTemp = getCase(coord.getX()+ count, i).getCoord();
				temp1.add(dic.get(coordTemp));
				count++;
			}
		}

		return check(coord, temp, temp1);
	}

	public boolean getDiag2(Square uneSquare) {
		List<Square> temp = new LinkedList<Square>();
		List<Square> temp1 = new LinkedList<Square>();

		Coord coord = uneSquare.getCoord();
		Coord coordTemp;

		int count = 2;

		for (int i = coord.getY() +2; i > coord.getY(); i--) {

			if (i >= 0 && i < size && coord.getX()-count >=0 && coord.getX()-count < size) {
				coordTemp = getCase(coord.getX()-count, i).getCoord();
				temp.add(dic.get(coordTemp));
				count--;
			}
		}

		count = 1;

		for (int i = coord.getY() -1; i > coord.getY() -3; i--) {

			if (i >= 0 && i < size && coord.getX()+count >=0 && coord.getX()+count < size) {
				coordTemp = getCase(coord.getX()+count, i).getCoord();
				temp1.add(dic.get(coordTemp));
				count++;
			}
		}

		return check(coord, temp, temp1);
	}

	public boolean check(Coord temp, List<Square> temp1, List<Square> temp2) {

		Square caseori = dic.get(temp);
		
		List<Square> solution = new LinkedList<Square>();
		Collections.reverse(temp1);

		int count = 0;

		for (Square coord : temp1) {
			if (coord.getValue().equals(caseori.getValue())) {
				count++;
				solution.add(coord);
			} else {
				break;
			}
		}

		for (Square coord : temp2) {
			if (coord.getValue().equals(caseori.getValue())) {
				count++;
				solution.add(coord);
			} else {
				break;
			}
		}
		
		if (count >= 2) {
			for (Square squareSoluce : solution) {
				squareSoluce.setValue("G");
			}
			
			caseori.setValue("G");
			
			return true;
		}

		return false;
	}

	public Square getCase(int x, int y) {
		return grid.get(y).get(x);
	}

	public boolean checkGame(Square uneSquare) {
		return getVert(uneSquare) || getHor(uneSquare) || getDiag1(uneSquare) || getDiag2(uneSquare);
	}

	public int getSize(){
		return size;
	}

	public boolean isFull(){
		for (List<Square> listeTemp : grid){
			for (Square squareTemp : listeTemp){
				if (squareTemp.getValue().equals("F")){
					return false;
				}
			}
		}

		return true;
	}

}
