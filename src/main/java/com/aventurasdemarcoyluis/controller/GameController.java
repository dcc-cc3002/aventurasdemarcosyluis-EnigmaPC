package com.aventurasdemarcoyluis.controller;

import com.aventurasdemarcoyluis.model.enemies.Boo;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.interfaces.IEntities;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;

import java.util.*;


public class GameController {
    private final ArrayList<IEntities> listOfCharacters;
    private int nivelBatalla;
    private int turn;
    private IEntities turnEntity;
    private IEntities actualEntity;
    private int round;


    public GameController() {
        listOfCharacters = new ArrayList<>();
        nivelBatalla = 1;
        turn = 1;
        round = 1;
    }

    public Luis addLuis(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        Luis luis = new Luis(level, attack, defense, maxHealPoints, maxFightPoints);
        listOfCharacters.add(luis);

        return luis;
    }

    public Marco addMarco(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        Marco marco = new Marco(level, attack, defense, maxHealPoints, maxFightPoints);
        listOfCharacters.add(marco);

        return marco;
    }

    public Boo addBoo(int level, int attack, int defense, int maxHealPoints) {
        Boo boo = new Boo(level, attack, defense, maxHealPoints);
        listOfCharacters.add(boo);

        return boo;
    }

    public Goomba addGoomba(int level, int attack, int defense, int maxHealPoints) {
        Goomba goomba = new Goomba(level, attack, defense, maxHealPoints);
        listOfCharacters.add(goomba);

        return goomba;
    }

    public Spiny addSpiny(int level, int attack, int defense, int maxHealPoints) {
        Spiny spiny = new Spiny(level, attack, defense, maxHealPoints);
        listOfCharacters.add(spiny);

        return spiny;
    }

    public List<IEntities> getListOfCharacters() {
        return listOfCharacters;
    }

    public IEntities getTurnEntity() {
        turnEntity = listOfCharacters.get((turn - 1) % listOfCharacters.size());
        return turnEntity;
    }

    public void finishTurn() {
        if (turn % listOfCharacters.size() == 0) {
            round++;
        }
        setTurn(turn + 1);
    }

    public void setTurn(int turn) {
        this.turn = turn;
        actualEntity = getTurnEntity();
    }

    public int getRound() {
        return round;
    }

    public int personalDice() {
        int dice = getTurnEntity().roll();
        return dice;
    }

}
