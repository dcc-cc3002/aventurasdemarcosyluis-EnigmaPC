package com.aventurasdemarcoyluis.controller;

import com.aventurasdemarcoyluis.model.enemies.Boo;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.interfaces.*;
import com.aventurasdemarcoyluis.model.items.Baul;
import com.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.aventurasdemarcoyluis.model.items.RedMushroom;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintStream;
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
    private BufferedReader in;


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

    public IEntities getActualEntity() {
        return actualEntity;
    }

    public void setActualEntity(IEntities entity) {
        this.actualEntity = entity;
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
        actualEntity.tryToStart();
    }

    public void setTurn(int turn) {
        this.turn = turn;
        actualEntity = getTurnEntity();
    }

    //Falta generar los enemigos
    public void nextBattle() {
        turn = 1;
        round = 1;
        playersSetNewBattle();
        setTurn(turn);
        actualEntity.tryToStart();
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

    public void attackEnemy(IPlayer attacker, IEnemy defender, IAttacks attack) {
        if (attacker.isLuis()) {
            Luis luis = (Luis) attacker;
            if (!defender.isBoo()) {
                IAttackedByLuis enemy = (IAttackedByLuis) defender;
                luis.attack(enemy, attack);
            }
        } else {
            Marco marco = (Marco) attacker;
            marco.attack(defender, attack);
        }
    }

    public void attackPlayer(IEnemy attacker, IPlayer defender) {
        if (attacker.isBoo()) {
            Boo boo = (Boo) attacker;
            if (defender.isLuis()) {
                Luis luis = (Luis) defender;
                boo.attack(luis);
            }
        } else {
            IAttackedByLuis enemy = (IAttackedByLuis) attacker;
            enemy.attack(defender);
        }
    }

    public void enemiesToAttack(PrintStream out) {
        int counter = 1;
        for (IEntities entity : listOfCharacters) {
            if (!entity.isPlayer()) {
                IEnemy enemy = (IEnemy) entity;
                out.println(counter+" "+enemy.enemyToString());
                counter++;
            }
        }
    }

    /**
     * Se obtiene el BufferedReader ocupado: InputStreamReader o StringReader
     * @return BufferedReader ocupado.
     */
    public BufferedReader getIn() {
        return in;
    }

    public void electionTurn(String string, PrintStream out) {
        try {
            int stringToInt = Integer.parseInt(string);
            if (stringToInt == 0) {
                out.println("Presiona cualquiera de las teclas desde" +
                        " 1 hasta "+amountOfEnemies()+" para elegir al enemigo por atacar");
                enemiesToAttack(out);
                String line = this.getIn().readLine();
                this.electionAttack(line, out);
            }
            if (stringToInt == 1) {
                out.println("Presiona 1 para ocupar HoneySyrup o 2 para ocupar RedMushroom");
                String line = this.getIn().readLine();

            }
        }
        catch (IOError | IOException e) {
        }
    }

    public void electionAttack(String string, PrintStream  out) {
        try {
            int stringToInt = Integer.parseInt(string);

        }
        catch (IOError e) {
        }
    }


    public void playerElection(PrintStream out) {
        try {
            out.println("Presiona 0 para atacar, 1 para elegir un item y 2 para pasar");
            String line = this.getIn().readLine(); // InputStreamReader o StringReader (según lo seteado)
            if (line.length() == 0) return;
            this.electionTurn(line, out);
        }
        catch (IOException e) {
        }
    }



}
