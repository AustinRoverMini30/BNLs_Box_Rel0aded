package com.example.bnls_box_rel0aded.model;

import java.util.*;

public class Leaderboard {
    Map<String, Player> playerList;
    List<Game> gameList;

    public Leaderboard(){
        playerList = new HashMap<>();
        gameList = new LinkedList<>();
    }

    public void addPlayer(Player player){
        if (!playerList.containsKey(player.toString())){
            playerList.put(player.toString(), player);
        }
    }

    public void addGame(Game game){
        gameList.add(game);
    }

    public Map<String, Player> getPlayer(){
        return playerList;
    }

    public List<Game> getGame(){
        return gameList;
    }

    public int getNbPlayer() {
        return playerList.size();
    }

    public Player getPlayer(String playerName){
        if (playerList.containsKey(playerName)){
            return playerList.get(playerName);
        }
        else{
            return null;
        }
    }
}
