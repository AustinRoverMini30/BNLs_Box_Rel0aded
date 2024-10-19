package com.example.bnls_box_rel0aded;

import com.example.bnls_box_rel0aded.model.Version;

import java.io.*;
import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Test implements Serializable{

	public static void binary_saver(Version version, String filename) throws IOException {

		Version test = version;

		FileOutputStream fos = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		System.out.println(version.getVersionUpdate());

		oos.writeObject(test);

		oos.close();
		fos.close();
	}

	public static void main(String[] args) throws IOException {
		Version version = new Version("1", "0.9");

		binary_saver(version, "out/version.bin");

	}

}
