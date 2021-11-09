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

/**
 * <b>Controlador:</b> <br>
 * Ejecuta las operaciones que el jugador quisiera efectuar <br>
 * Los campos que posee son: <br>
 * <b>listOfCharacters</b>: lista de los Personajes del juego <br>
 * <b>listOfPlayers</b>: lista de los Jugadores en el juego <br>
 * <b>baul</b>: baul de objetos <br>
 * <b>nivelBatalla</b>: nivel de batalla que se encuentra el juego <br>
 * <b>turn</b>: turn que será de referencia para los personajes <br>
 * <b>turnEntity</b>: entidad que posee el turno <br>
 * <b>round</b>: ronda de juego <br>
 * <b>randomEnemy</b>: número que permitirá crear a los enemigos de manera aleatoria <br>
 * <b>in</b>: Buffered reader elegido<br>
 * <b>out</b>: Print Stream elegido <br>
 * <b>random</b>: número que permitirá a los enemigos atacar a un jugador aleatorio <br>
 *
 *
 * @author Andrea PC
 */
public class GameController {
    private ArrayList<IEntities> listOfCharacters;
    private ArrayList<IPlayer> listOfPlayers;
    private Baul baul;
    private int nivelBatalla;
    private int turn;
    private IEntities turnEntity;
    private int round;
    private Random randomEnemy;
    private BufferedReader in;
    private PrintStream out;
    private Random random;
    private HammerAttack hammerAttack = new HammerAttack();
    private JumpAttack jumpAttack = new JumpAttack();


    /**
     * Constructor del Controlador <br>
     * Modela al controlador. <br>
     * Posee una lista con los jugadores, una lista con los personajes,
     * el nivel de batalla, los números random, los turnos, las rondas y el baúl.
     */
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

    /**
     * Se establece la semilla para el ataque martillo. Creado exclusivamente para testeo.
     * @param seed Semilla a plantar
     */
    public void setSeedAttack(int seed) {
        hammerAttack.setSeed(seed);
    }

    /**
     * Se establece la semilla para el número random. Creado exclusivamente para testeo.
     * @param seed Semilla a plantar
     */
    public void setSeedRandom(int seed) {
        random.setSeed(seed);
    }

    /**
     * Se establece la semilla para el número random. Creado exclusivamente para testeo.
     * @param seed Semilla a plantar
     */
    public void setSeedRandomEnemy(int seed) {
        randomEnemy.setSeed(seed);
    }

    /**
     * Permite establecer el Buffered Reader elegido
     * @param inInit Buffered Reader elegido (InputStreamReader(System.in) o StringReader para testear)
     */
    public void setBufferedReader(BufferedReader inInit) {
        this.in = inInit;
    }

    /**
     * Permite establecer el Print Stream elegido
     * @param out1 Print Stream elegido (System.out o NullOutputStream para testear)
     */
    public void setPrintStream(PrintStream out1) {
        this.out = out1;
    }

    /**
     * Método que crea un Luis
     * @param level nivel
     * @param attack ataque
     * @param defense defesa
     * @param maxHealPoints puntos de vida máximos
     * @param maxFightPoints puntos de pelea máximos
     * @return Luis
     */
    public Luis addLuis(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        Luis luis = new Luis(level, attack, defense, maxHealPoints, maxFightPoints);
        listOfPlayers.add(luis);
        return luis;
    }

    /**
     * Método que crea un Marco
     * @param level nivel
     * @param attack ataque
     * @param defense defesa
     * @param maxHealPoints puntos de vida máximos
     * @param maxFightPoints puntos de pelea máximos
     * @return Marco
     */
    public Marco addMarco(int level, int attack, int defense, int maxHealPoints, int maxFightPoints) {
        Marco marco = new Marco(level, attack, defense, maxHealPoints, maxFightPoints);
        listOfPlayers.add(marco);
        return marco;
    }

    /**
     * Método que crea un Boo
     * @param level nivel
     * @param attack ataque
     * @param defense defesa
     * @param maxHealPoints puntos de vida máximos
     * @return Boo
     */
    public Boo addBoo(int level, int attack, int defense, int maxHealPoints) {
        Boo boo = new Boo(level, attack, defense, maxHealPoints);
        return boo;
    }

    /**
     * Método que crea un Goomba
     * @param level nivel
     * @param attack ataque
     * @param defense defesa
     * @param maxHealPoints puntos de vida máximos
     * @return Goomba
     */
    public Goomba addGoomba(int level, int attack, int defense, int maxHealPoints) {
        Goomba goomba = new Goomba(level, attack, defense, maxHealPoints);
        return goomba;
    }

    /**
     * Método que crea un Spiny
     * @param level nivel
     * @param attack ataque
     * @param defense defesa
     * @param maxHealPoints puntos de vida máximos
     * @return Spiny
     */
    public Spiny addSpiny(int level, int attack, int defense, int maxHealPoints) {
        Spiny spiny = new Spiny(level, attack, defense, maxHealPoints);
        return spiny;
    }

    /**
     * Método que crea un HoneySyrup
     * @return HoneySyrup
     */
    public HoneySyrup addHoneySyrup() {
        HoneySyrup honeySyrup = new HoneySyrup();
        return honeySyrup;
    }

    /**
     * Método que crea un RedMushroom
     * @return RedMushroom
     */
    public RedMushroom addRedMushroom() {
        RedMushroom redMushroom = new RedMushroom();
        return redMushroom;
    }

    /**
     * Método que añade cierca cantidad de items al baúl
     * @param item Item a añadir
     * @param amount Cantidad del item
     */
    public void addItemBaul(IObject item, int amount) {
        baul.addItem(item, amount);
    }

    /**
     * Método que permite a un jugador usar un item.
     * @param player Jugador que quiere usar el item
     * @param item Item a utilizar
     */
    public void usePlayerItem(IPlayer player, IObject item) {
        player.useItem(item,baul);
    }

    /**
     * Método que entrega el inventario del baúl como Hashtable
     * @return Inventario del baúl como Hashtable
     */
    public Hashtable<IObject, Integer> getStorage() {
        return baul.getStorage();
    }

    /**
     * Método que genera de forma aleatoria un enemigo (ya sea Goomba, Boo o Spiny)
     * @param level nivel del enemigo
     * @param attack ataque del enemigo
     * @param defense defensa del enemigo
     * @param maxHealPoints puntos de vida máximos del enemigo
     * @return Enemigo aleatorio creado según las estadísticas entregadas
     */
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

    /**
     * Método que entrega la cantidad de jugadores activos en juego.
     * @return Cantidad de jugadores activos (vivos) en juego.
     */
    public int amountOfPlayers() {
        int counter = 0;
        for (IEntities entity : listOfCharacters) {
            if (entity.isPlayer()) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Método que entrega la cantidad de enemigos activos en juego.
     * @return Cantidad de enemigos activos (vivos) en juego.
     */
    public int amountOfEnemies() {
        int counter = 0;
        for (IEntities entity : listOfCharacters) {
            if (!entity.isPlayer()) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Método que entrega el personaje que posee en turno (ya sea jugador o enemigo)
     * @return Personaje al que le toca jugar
     */
    public IEntities getTurnEntity() {
        turnEntity = listOfCharacters.get((turn - 1) % listOfCharacters.size());
        return turnEntity;
    }

    /**
     * Método para finalizar un turno.
     * Una vez finalizado el turno pueden pasar 4 situaciones: <br>
     * 1) Se gana la batalla por lo que se debe aumentar el nivel de batalla. <br>
     * 2) Si se gana la batlla y el nivel de batalla es 6 termina el juego (el tope es 5) <br>
     * 3) Se puede perder la batalla, es decir mueren todos los jugadores. <br>
     * 4) Aún no se gana ni pierde la batalla por lo que se continúa jugando y se pasa a la
     * siguiente ronda. <br>
     */
    public void finishTurn() {
        removeKO();
        if (winBattle()) {
            nivelBatalla++;
            if (winGame()) {
                out.println("Los jugadores han ganado el juego!");
                return;
            }
            out.println("Los jugadores han ganado la batalla!");
            out.println("=======================================================");
            out.println("Nivel de Batalla: "+nivelBatalla);
            Battle();
        }
        else if (looseBattle()) {
            out.println("Los jugadores han perdido ;(!");
            return;
        }
        else if (turn % listOfCharacters.size() == 0) {
            round++;
            out.println("=======================================================");
            out.println("Ronda "+round);
            setTurn(1);
            playersInGame();
            tryToStart();
        } else {
            setTurn(turn + 1);
            tryToStart();
        }
    }

    /**
     * Método para setear el turno
     * @param turn Turno a establecer
     */
    public void setTurn(int turn) {
        this.turn = turn;
    }

    /**
     * Método que simula los niveles de batalla según lo pedido en el enunciado.
     * Además genera aleatoriamente los enemigos.
     */
    public void Battle() {
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
        HoneySyrup honeySyrup = addHoneySyrup();
        RedMushroom redMushroom = addRedMushroom();
        addItemBaul(honeySyrup, 1);
        addItemBaul(redMushroom, 1);
        if (nivelBatalla < 3) {
            for (int i = 0; i < 3; i++) {
                int amount = ((random.nextInt(3)+1));
                int lvle = lvl - amount;
                int atke = atk + amount;
                int defe = def - amount;
                int hpe = hp/2 + amount;
                IEnemy enemy = generateEnemy(lvle, atke, defe, hpe);
                listOfCharacters.add(enemy);
            }
        }
        else if (nivelBatalla >= 3 && nivelBatalla < 5) {
            for (int i = 0; i < 5; i++) {
                int amount = ((random.nextInt(3)+5));
                int lvle = lvl - amount;
                int atke = atk + amount/3;
                int defe = def - amount/3;
                int hpe = hp/2 - amount;
                IEnemy enemy = generateEnemy(lvle, atke, defe, hpe);
                listOfCharacters.add(enemy);
            }
        }
        else if (nivelBatalla == 5) {
            for (int i = 0; i < 6; i++) {
                int amount = (random.nextInt(7)+3);
                int lvle = lvl - amount;
                int atke = atk + amount/3;
                int defe = def - amount/3;
                int hpe = hp/2 - amount;
                IEnemy enemy = generateEnemy(lvle, atke, defe, hpe);
                listOfCharacters.add(enemy);
            }
        }
        setTurn(turn);
        playersInGame();
        tryToStart();
    }

    /**
     * Método que permite a los jugadores regenerar vida y (para los no activos) volver al juego para
     * la siguiente batalla.
     */
    public void playersSetNewBattle() {
        for (IPlayer player : listOfPlayers) {
            player.levelUP();
            player.setHP(player.getMaxHP());
            player.setFP(player.getMaxFP());
        }
    }

    /**
     * Método que permite eliminar a los personajes que han muerto (no activos) de la
     * lista de personajes en juego.
     */
    public void removeKO() {
        ArrayList<IEntities> removedKO = new ArrayList<>();
        for (IEntities entity : listOfCharacters) {
            if (entity.isNotDead()) {
                removedKO.add(entity);
            }
        }
        this.listOfCharacters = removedKO;
    }

    /**
     * Método que permite saber si se ha ganado la batalla o no.
     * @return Verdadero si se ganó la batalla, Falso sino.
     */
    public boolean winBattle() {
        return amountOfEnemies() == 0 && amountOfPlayers() >= 1;
    }

    /**
     * Método que permite saber si se ha perdido la batalla o no.
     * @return Verdadero si se perdió la batalla, Falso sino.
     */
    public boolean looseBattle() {
        return amountOfPlayers() == 0;
    }

    /**
     * Método que permite saber si se ha ganado el juego o no.
     * @return Si se llega al nivel 6 retorna Verdadero, sino Falso.
     */
    public boolean winGame() {
        return nivelBatalla == 6;
    }

    /**
     * Método que permite a un jugador atacar a un enemigo con cierto ataque
     * @param attacker Jugador que ataca
     * @param defender Enemigo
     * @param attack Ataque elegido
     */
    public void attackEnemy(IPlayer attacker, IEnemy defender, IAttacks attack) {
        if (attacker.isLuis()) {
            Luis luis = (Luis) attacker;
            if (!defender.isBoo()) {
                IAttackedByLuis enemy = (IAttackedByLuis) defender;
                int hpprev = enemy.getHP();
                int hpprevA = luis.getHP();
                luis.attack(enemy, attack);
                int hpnew = enemy.getHP();
                int hpnewA = luis.getHP();
                out.println("Luis ataca a "+enemy.getName()+" con "+attack.getName()+
                        " | Vida Previa Enemigo: "+hpprev+", Vida Nueva Enemigo: "+hpnew);
                if (defender.isSpiny()) {
                    if (!attack.hurtsSpiny()) {
                        out.println("Spiny se defiende con sus pinchos!" +
                                " | Vida Previa Luis: "+hpprevA+", Vida Nueva Luis: "+hpnewA);
                    }
                }
            } else {
                out.println("Luis no puede atacar a Boo!");
            }
        } else {
            int hpprev = defender.getHP();
            int hpprevA = attacker.getHP();
            Marco marco = (Marco) attacker;
            marco.attack(defender, attack);
            int hpnew = defender.getHP();
            int hpnewA = marco.getHP();
            out.println("Marco ataca a "+defender.getName()+" con "+attack.getName()+
                    " | Vida Previa Enemigo: "+hpprev+", Vida Nueva Enemigo: "+hpnew);
            if (defender.isSpiny()) {
                if (!attack.hurtsSpiny()) {
                    out.println("Spiny se defiende con sus pinchos!" +
                            " | Vida Previa Marco: "+hpprevA+", Vida Nueva Marco: "+hpnewA);
                }
            }
        }
    }

    /**
     * Método que permite a un enemigo atacar a un jugador
     * @param attacker Enemigo que ataca
     * @param defender Jugador atacado
     */
    public void attackPlayer(IEnemy attacker, IPlayer defender) {
        if (attacker.isBoo()) {
            Boo boo = (Boo) attacker;
            if (defender.isLuis()) {
                Luis luis = (Luis) defender;
                int hpprev = luis.getHP();
                boo.attack(luis);
                int hpnew = luis.getHP();
                out.println("Boo ataca a "+luis.getName()+
                        " | Vida Previa Luis: "+hpprev+", Vida Nueva Luis: "+hpnew);
            } else {
                out.println("Boo no puede atacar a Marco!");
            }
        } else {
            int hpprev = defender.getHP();
            IAttackedByLuis enemy = (IAttackedByLuis) attacker;
            enemy.attack(defender);
            int hpnew = defender.getHP();
            out.println(enemy.getName()+" ataca a "+defender.getName()+
                    " | Vida Previa "+defender.getName()+": "+hpprev+
                    ", Vida Nueva "+defender.getName()+": "+hpnew);
        }
    }

    /**
     * Método que permite buscar a un enemigo activo por número según su aparición en la lista pero
     * solo contando a los enemigos.
     * @param num Número del enemigo a buscar
     * @return Enemigo que posee el número
     */
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

    /**
     * Método que permite buscar a un jugador activo por número según su aparición en la lista pero
     * solo contando a los jugadores activos.
     * @param num Número del jugador a buscar
     * @return Jugador que posee el número
     */
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

    /**
     * Método que imprime en pantalla los enemigos que se pueden atacar y sus atributos
     */
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

    /**
     * Método que imprime en pantalla los jugadores que se pueden atacar y sus atributos
     */
    public void playersInGame() {
        for (IEntities entity : listOfCharacters) {
            if (entity.isPlayer()) {
                IPlayer player = (IPlayer) entity;
                out.println(player.playerToString());
            }
        }
    }

    /**
     * Método que imprime en pantalla los items que hay en el baúl y la cantidad de estos.
     */
    public void itemsToUse() {
        HoneySyrup honeySyrup = addHoneySyrup();
        RedMushroom redMushroom = addRedMushroom();
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

    /**
     * Turno de elección para los jugadores.
     * Se recibe un string numérico y según ese string es lo que hará el jugador. <br>
     * Si recibe 0 significa que el jugador entrará al modo ataque.
     * Si recibe 1 significa que el jugador entrará al modo elegir item.
     * Si recibe 2 significa que el jugador pasará el turno
     * @param string Número de la elección
     */
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

    /**
     * Elección del item a usar para el jugador.
     * Se recibe un string numérico que representa el item a usar.
     * Si recibe 1 se usará honeySyrup
     * Si recibe 2 se usará redMushroom
     * @param numItem Número que representa el item a usar
     */
    public void electionUseItem(String numItem) {
        int stringToInt = Integer.parseInt(numItem);
        IPlayer player = (IPlayer) getTurnEntity();
        if (stringToInt == 1) {
            IObject item = addHoneySyrup();
            usePlayerItem(player, item);
            out.println(player.getName()+" ha usado "+item.getName());
        }
        else if (stringToInt == 2) {
            IObject item = addRedMushroom();
            usePlayerItem(player, item);
            out.println(player.getName()+" ha usado "+item.getName());
        }
    }

    /**
     * Elección del ataque a usar para el jugador sobre cierto enemigo.
     * Se recibe un string numérico que representa el número del enemigo a atacar y otro
     * string numérico para el ataque a utilizar. <br>
     * Se buscar el enemigo según el string del número del enemigo.
     * Si se recibe 1 para el parámetro de ataque se utilizará Martillo
     * Si se recibe 2 para el parámetro de ataque se utilizará Salto
     * @param numEnemy Número del enemigo a atacar
     * @param numAttack Número del ataque elegido
     */
    public void electionAttack(String numEnemy, String numAttack) {
        try {
            int stringToInt = Integer.parseInt(numEnemy);
            int stringToInt2 = Integer.parseInt(numAttack);
            IEnemy enemy = searchEnemyNum(stringToInt);
            IPlayer player = (IPlayer) getTurnEntity();
            if (stringToInt2 == 1) {
                attackEnemy(player, enemy, hammerAttack);
            }
            else if (stringToInt2 == 2) {
                attackEnemy(player, enemy, jumpAttack);
            }
        }
        catch (IOError e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que introduce la elección de atacar, elegir un item o pasar.
     * Para posteriormente ocupar los métodos de elección correspondientes.
     */
    public void playerElection() {
        try {
            out.println("Estas ocupando a "+getTurnEntity().getName());
            out.println("Presiona 0 para atacar, 1 para elegir un item y 2 para pasar");
            String line = this.getIn().readLine(); // InputStreamReader o StringReader (según lo seteado)
            if (line.length() == 0) return;
            this.electionTurn(line);
        }
        catch (IOException e) {
        }
    }

    /**
     * Método que permite elegir aleatoriamente un jugador para que un enemigo lo ataque.
     */
    public void enemyElection() {
        int amountOfPlayers = amountOfPlayers();
        int election = random.nextInt(amountOfPlayers);
        IPlayer player = searchPlayerNum(election);
        IEnemy enemy = (IEnemy) getTurnEntity();
        attackPlayer(enemy,player);
        finishTurn();
    }

    /**
     * Método que permite a la entidad que posee el turno elegir lo que hará según si es
     * jugador o enemigo.
     */
    public void tryToStart() {
        IEntities entity = getTurnEntity();
        if (entity.isPlayer()) {
            playerElection();
        } else {
            enemyElection();
        }
    }

    /**
     * Modelamiento del escenario de juego fijo.
     * @param out PrintStream elegido.
     * @param inInit BufferedReader elegido.
     */
    public void escenario(PrintStream out, BufferedReader inInit) {
        GameController controller = this;
        controller.setPrintStream(out);
        controller.setBufferedReader(inInit);

        //Datos fijos, pueden ir cambiando según se requiera pero mientras se quedarán así.
        controller.addMarco(16,13,15,60,7);
        controller.addLuis(14,15,12,63,9);

        out.println("=======================================================");
        out.println("Nivel de Batalla: "+nivelBatalla);
        controller.Battle();
    }

}
