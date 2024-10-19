package com.example.bnls_box_rel0aded.model;

import com.example.bnls_box_rel0aded.Main;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Square {
	private final Boolean win;
	private final Coord coord;
	private final double x;
	private final double y;
	private String value;
	private Image image;

	public Square(Coord coord, double x, double y) {
		super();
		this.coord = coord;
		this.value = "F";
		this.win = false;
		this.x = x;
		this.y = y;
        this.image = new Image(Main.class.getResourceAsStream("Image/Square Default.png"), x, y, false, true);

	}

	@Override
	public String toString() {
		return value;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public Coord getCoord() {
		return coord;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(String image) {
        try {
            this.image = new Image(new FileInputStream(image), x, y, false, true);
        } catch (FileNotFoundException e) {
			this.image = new Image(Main.class.getResourceAsStream(image), x, y, false, true);
        }
    }
}
