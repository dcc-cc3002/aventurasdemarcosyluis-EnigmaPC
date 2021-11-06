package com.aventurasdemarcoyluis.controller;

import com.aventurasdemarcoyluis.model.enemies.Boo;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IEntities;
import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;
import com.aventurasdemarcoyluis.model.items.Baul;
import com.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.aventurasdemarcoyluis.model.items.RedMushroom;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;
import java.util.Random;

import java.util.*;


public class GameController {
    private ArrayList<IEntities> listOfCharacters;
    private ArrayList<IPlayer> listOfPlayers;
    private Baul baul;
    private int nivelBatalla;
    private int turn;
    private IEntities turnEntity;
    private IEntities actualEntity;
    private int round;
    private Random randomEnemy;


    public GameController() {
        listOfPlayers = new ArrayList<>();
        listOfCharacters = new ArrayList<>();
        nivelBatalla = 1;
        turn = 1;
        round = 1;
        baul = new Baul(3,3);
    }

    public Luis addLuis(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        Luis luis = new Luis(level, attack, defense, maxHealPoints, maxFightPoints);
        return luis;
    }

    public Marco addMarco(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        Marco marco = new Marco(level, attack, defense, maxHealPoints, maxFightPoints);

        return marco;
    }

    public Boo addBoo(int level, int attack, int defense, int maxHealPoints) {
        Boo boo = new Boo(level, attack, defense, maxHealPoints);
        return boo;
    }

    public Goomba addGoomba(int level, int attack, int defense, int maxHealPoints) {
        Goomba goomba = new Goomba(level, attack, defense, maxHealPoints);
        return goomba;
    }

    public Spiny addSpiny(int level, int attack, int defense, int maxHealPoints) {
        Spiny spiny = new Spiny(level, attack, defense, maxHealPoints);
        return spiny;
    }

    public HoneySyrup addHoneySyrup() {
        HoneySyrup honeySyrup = new HoneySyrup();
        return honeySyrup;
    }

    public RedMushroom addRedMushroom() {
        RedMushroom redMushroom = new RedMushroom();
        return redMushroom;
    }

    public void addItemBaul(IObject item, int amount) {
        baul.addItem(item, amount);
    }

    public void usePlayerItem(IPlayer player, IObject item) {
        player.useItem(item,baul);
    }

    public Hashtable<IObject, Integer> getStorage() {
        return baul.getStorage();
    }

    public List<IEntities> getListOfCharacters() {
        return listOfCharacters;
    }

    public IEnemy generateEnemy(int level, int attack, int defense, int maxHealPoints) {
        int dice = randomEnemy.nextInt(3);
        if (dice == 0) {
            Boo boo = addBoo(level, attack, defense, maxHealPoints);
            return boo;
        }
        else if (dice == 1) {
            Goomba goomba = addGoomba(level, attack, defense, maxHealPoints);
            return goomba;
        }
        else {
            Spiny spiny = addSpiny(level, attack, defense, maxHealPoints);
            return spiny;
        }
    }

    public int amountOfPlayers() {
        int counter = 0;
        for (IEntities entity : listOfCharacters) {
            if (entity.isPlayer()) {
                counter++;
            }
        }
        return counter;
    }

    public int amountOfEnemies() {
        int counter = 0;
        for (IEntities entity : listOfCharacters) {
            if (!entity.isPlayer()) {
                counter++;
            }
        }
        return counter;
    }

    public IEntities getTurnEntity() {
        turnEntity = listOfCharacters.get((turn - 1) % listOfCharacters.size());
        return turnEntity;
    }

    public void finishTurn() {
        removeKO();
        if (winBattle()) {
            nivelBatalla++;
            if (winGame()) {
                return;
            }
            nextBattle();
        }
        else if (looseBattle()) {
            return;
        }
        else if (turn % listOfCharacters.size() == 0) {
            round++;
        }
        setTurn(turn + 1);
    }

    public void setTurn(int turn) {
        this.turn = turn;
        actualEntity = getTurnEntity();
    }

    public void nextBattle() {
        turn = 1;
        round = 1;


    }

    public void playersSetNewBattle() {
        for (IPlayer player : listOfPlayers) {
            player.levelUP();
            player.setHP(player.getMaxHP());
        }
    }

    public int personalDice() {
        int dice = getTurnEntity().roll();
        return dice;
    }

    public void removeKO() {
        for (IEntities entity : listOfCharacters) {
            if (!entity.isNotDead()) {
                listOfCharacters.remove(entity);
            }
        }
    }

    public boolean winBattle() {
        if (amountOfEnemies() == 0 && amountOfPlayers() >= 1) {
            return true;
        }
        return false;
    }

    public boolean looseBattle() {
        if (amountOfPlayers() == 0) {
            return true;
        }
        return false;
    }

    public boolean winGame() {
        return nivelBatalla == 6;
    }




}
