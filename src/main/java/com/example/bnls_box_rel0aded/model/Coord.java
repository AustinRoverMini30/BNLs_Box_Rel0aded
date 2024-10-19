package com.example.bnls_box_rel0aded.model;

public class Coord {

	private final int x;
	private final int y;
	public Coord(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
