package com.aventurasdemarcoyluis.controller;

import com.aventurasdemarcoyluis.model.attacks.HammerAttack;
import com.aventurasdemarcoyluis.model.attacks.JumpAttack;
import com.aventurasdemarcoyluis.model.enemies.Boo;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.interfaces.*;
import com.aventurasdemarcoyluis.model.items.Baul;
import com.aventurasdemarcoyluis.model.items.HoneySyrup;
import com.aventurasdemarcoyluis.model.items.RedMushroom;
import com.aventurasdemarcoyluis.model.players.Luis;
import com.aventurasdemarcoyluis.model.players.Marco;

import java.io.*;
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
    private PrintStream out;
    private Random random;



    public GameController() {
        listOfPlayers = new ArrayList<>();
        listOfCharacters = new ArrayList<>();
        nivelBatalla = 1;
        random = new Random();
        randomEnemy = new Random();
        turn = 1;
        round = 1;
        baul = new Baul(3, 3);
    }

    public void setBufferedReader(BufferedReader inInit) {
        this.in = inInit;
    }

    public void setPrintStream(PrintStream out1) {
        this.out = out1;
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
                out.println("Los jugadores han ganado el juego!");
                return;
            }
            out.println("Los jugadores han ganado la batalla!");
            Battle();
        }
        else if (looseBattle()) {
            out.println("Los jugadores han perdido ;(!");
            return;
        }
        else if (turn % listOfCharacters.size() == 0) {
            round++;
            out.println("Ronda "+round);
        }
        setTurn(turn + 1);
        tryToStart();
    }

    public void setTurn(int turn) {
        this.turn = turn;
        actualEntity = getTurnEntity();
    }

    public void Battle() {
        playersInGame();
        turn = 1;
        round = 1;
        playersSetNewBattle();
        listOfCharacters.clear();
        for (IPlayer player : listOfPlayers) {
            listOfCharacters.add(player);
        }
        IPlayer player = listOfPlayers.get(0);
        int lvl = player.getLVL();
        int atk = player.getATK();
        int def = player.getDEF();
        int hp = player.getMaxHP();
        if (nivelBatalla < 3) {
            for (int i = 0; i < 3; i++) {
                int amount = (random.nextInt(3)+1)*nivelBatalla;
                int lvle = lvl - amount;
                int atke = atk - amount;
                int defe = def - amount;
                int hpe = hp - amount;
                IEnemy enemy = generateEnemy(lvle, atke, defe, hpe);
                listOfCharacters.add(enemy);
            }
        }
        else if (nivelBatalla >= 3 && nivelBatalla < 5) {
            for (int i = 0; i < 5; i++) {
                int amount = (random.nextInt(3)+3)*nivelBatalla;
                int lvle = lvl - amount;
                int atke = atk - amount;
                int defe = def - amount;
                int hpe = hp - amount;
                IEnemy enemy = generateEnemy(lvle, atke, defe, hpe);
                listOfCharacters.add(enemy);
            }
        }
        else if (nivelBatalla == 5) {
            for (int i = 0; i < 6; i++) {
                int amount = (random.nextInt(3)+5)*nivelBatalla;
                int lvle = lvl - amount;
                int atke = atk - amount;
                int defe = def - amount;
                int hpe = hp - amount;
                IEnemy enemy = generateEnemy(lvle, atke, defe, hpe);
                listOfCharacters.add(enemy);
            }
        }
        setTurn(turn);
        tryToStart();
    }

    public void playersSetNewBattle() {
        for (IPlayer player : listOfPlayers) {
            player.levelUP();
            player.setHP(player.getMaxHP());
        }
    }

    public void removeKO() {
        ArrayList<IEntities> removedKO = new ArrayList<>();
        for (IEntities entity : listOfCharacters) {
            if (entity.isNotDead()) {
                removedKO.add(entity);
            }
        }
        this.listOfCharacters = removedKO;
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

    public IEnemy searchEnemyNum(int num) {
        int counter = 1;
        for (IEntities entity : listOfCharacters) {
            if (!entity.isPlayer()) {
                if (num == counter) {
                    IEnemy enemy = (IEnemy) entity;
                    return enemy;
                }
                counter++;
            }
        }
        return null;
    }

    public IPlayer searchPlayerNum(int num) {
        int counter = 0;
        for (IEntities entity : listOfCharacters) {
            if (entity.isPlayer()) {
                if (num == counter) {
                    IPlayer player = (IPlayer) entity;
                    return player;
                }
                counter++;
            }
        }
        return null;
    }

    public void enemiesToAttack() {
        int counter = 1;
        for (IEntities entity : listOfCharacters) {
            if (!entity.isPlayer()) {
                IEnemy enemy = (IEnemy) entity;
                out.println(counter+" "+enemy.enemyToString());
                counter++;
            }
        }
    }

    public void playersInGame() {
        for (IEntities entity : listOfCharacters) {
            if (entity.isPlayer()) {
                IPlayer player = (IPlayer) entity;
                out.println(player.playerToString());
            }
        }
    }

    public void itemsToUse() {
        HoneySyrup honeySyrup = new HoneySyrup();
        RedMushroom redMushroom = new RedMushroom();
        out.println("Inventario | HoneySyrup: "+getStorage().get(honeySyrup)+
                ", RedMushroom: "+getStorage().get(redMushroom));
    }

    /**
     * Se obtiene el BufferedReader ocupado: InputStreamReader o StringReader
     * @return BufferedReader ocupado.
     */
    public BufferedReader getIn() {
        return in;
    }

    public void electionTurn(String string) {
        try {
            int stringToInt = Integer.parseInt(string);
            if (stringToInt == 0) {
                out.println("Presiona cualquiera de las teclas desde" +
                        " 1 hasta "+amountOfEnemies()+" para elegir al enemigo por atacar");
                enemiesToAttack();
                String line = this.getIn().readLine();
                out.println("Elige el ataque: 1 para Martillo, 2 para Salto ");
                String line2 = this.getIn().readLine();
                this.electionAttack(line, line2);
                finishTurn();
            }
            else if (stringToInt == 1) {
                out.println("Presiona 1 para ocupar HoneySyrup o 2 para ocupar RedMushroom");
                itemsToUse();
                String line = this.getIn().readLine();
                this.electionUseItem(line);
                finishTurn();
            }
            else if (stringToInt == 2) {
                out.println("El jugador "+turnEntity.getName()+" ha pasado.");
                finishTurn();
            }
        }
        catch (IOError | IOException e) {
            e.printStackTrace();
        }
    }

    public void electionUseItem(String numItem) {
        int stringToInt = Integer.parseInt(numItem);
        HoneySyrup honeySyrup = new HoneySyrup();
        RedMushroom redMushroom = new RedMushroom();
        IPlayer player = (IPlayer) getTurnEntity();
        if (stringToInt == 1) {
            try {
                usePlayerItem(player, honeySyrup);
            } catch (IOError error) {
                error.printStackTrace();
            }
        }
        else if (stringToInt == 2) {
            try {
                usePlayerItem(player, redMushroom);
            }catch (IOError error) {
                error.printStackTrace();
            }
        }
    }

    public void electionAttack(String numEnemy, String numAttack) {
        try {
            int stringToInt = Integer.parseInt(numEnemy);
            int stringToInt2 = Integer.parseInt(numAttack);
            IEnemy enemy = searchEnemyNum(stringToInt);
            IPlayer player = (IPlayer) getTurnEntity();
            if (stringToInt2 == 1) {
                HammerAttack hammerAttack = new HammerAttack();
                attackEnemy(player, enemy, hammerAttack);
            }
            else if (stringToInt2 == 2) {
                JumpAttack jumpAttack = new JumpAttack();
                attackEnemy(player, enemy, jumpAttack);
            }
        }
        catch (IOError e) {
            e.printStackTrace();
        }
    }


    public void playerElection() {
        try {
            out.println("Presiona 0 para atacar, 1 para elegir un item y 2 para pasar");
            String line = this.getIn().readLine(); // InputStreamReader o StringReader (según lo seteado)
            if (line.length() == 0) return;
            this.electionTurn(line);
        }
        catch (IOException e) {
        }
    }

    public void enemyElection() {
        int amountOfPlayers = amountOfPlayers();
        int election = random.nextInt(amountOfPlayers);
        IPlayer player = searchPlayerNum(election);
        IEnemy enemy = (IEnemy) getTurnEntity();
        attackPlayer(enemy,player);
        finishTurn();
    }

    public void tryToStart() {
        IEntities entity = getTurnEntity();
        if (entity.isPlayer()) {
            playerElection();
        } else {
            enemyElection();
        }
    }

    public void escenario(PrintStream out) {
        GameController controller = this;
        controller.setPrintStream(out);
        controller.setBufferedReader(new BufferedReader(new InputStreamReader(System.in)));

        Marco marco = controller.addMarco(16,13,15,60,14);
        Luis luis = controller.addLuis(14,15,12,63,16);

        controller.listOfPlayers.add(marco);
        controller.listOfPlayers.add(luis);

        controller.Battle();
    }

}
