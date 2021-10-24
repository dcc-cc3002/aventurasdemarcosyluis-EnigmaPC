package com.aventurasdemarcoyluis.controller;

import com.aventurasdemarcoyluis.model.enemies.Boo;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.interfaces.IEntities;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;

import java.util.*;


public class GameController {
    private final ArrayList<IEntities> listOfCharacter;
    private int nivelBatalla;


    public GameController() {
        listOfCharacter = new ArrayList<>();
        nivelBatalla = 1;
    }

    public Luis addLuis(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        Luis luis = new Luis(level, attack, defense, maxHealPoints, maxFightPoints);
        listOfCharacter.add(luis);

        return luis;
    }

    public Marco addMarco(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        Marco marco = new Marco(level, attack, defense, maxHealPoints, maxFightPoints);
        listOfCharacter.add(marco);

        return marco;
    }

    public Boo addBoo(int level, int attack, int defense, int maxHealPoints) {
        Boo boo = new Boo(level, attack, defense, maxHealPoints);
        listOfCharacter.add(boo);

        return boo;
    }

    public Goomba addGoomba(int level, int attack, int defense, int maxHealPoints) {
        Goomba goomba = new Goomba(level, attack, defense, maxHealPoints);
        listOfCharacter.add(goomba);

        return goomba;
    }

    public Spiny addSpiny(int level, int attack, int defense, int maxHealPoints) {
        Spiny spiny = new Spiny(level, attack, defense, maxHealPoints);
        listOfCharacter.add(spiny);

        return spiny;
    }


}
