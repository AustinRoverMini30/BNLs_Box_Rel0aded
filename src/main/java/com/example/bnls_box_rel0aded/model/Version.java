package com.example.bnls_box_rel0aded.model;

import java.io.Serializable;

public class Version implements Serializable {

	private String versionGame;
	private String versionUpdate;

	public Version(String versionGame, String versionUpdate){
		this.versionGame = versionGame;
		this.versionUpdate = versionUpdate;
	}
	
	public String getVersionGame() {
		return versionGame;
	}
	public void setVersionGame(String versionGame) {
		this.versionGame = versionGame;
	}
	public String getVersionUpdate() {
		return versionUpdate;
	}
	public void setVersionUpdate(String versionUpdate) {
		this.versionUpdate = versionUpdate;
	}
	
	public boolean comparatorGame(Version version) {
		String temp = version.getVersionGame();
		
		return versionGame.equals(temp);
	}


	public boolean comparatorUpdate(Version version) {
		String temp = version.getVersionUpdate();

		return versionUpdate.equals(temp);
	}
}
