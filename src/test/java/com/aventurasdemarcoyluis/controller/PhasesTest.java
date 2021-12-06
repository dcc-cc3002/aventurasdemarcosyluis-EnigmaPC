package com.aventurasdemarcoyluis.controller;

import com.aventurasdemarcoyluis.controller.phases.*;
import com.aventurasdemarcoyluis.model.abstract_classes.BaseTest;
import com.aventurasdemarcoyluis.model.attacks.HammerAttack;
import com.aventurasdemarcoyluis.model.attacks.JumpAttack;
import com.aventurasdemarcoyluis.model.enemies.Boo;
import com.aventurasdemarcoyluis.model.enemies.Goomba;
import com.aventurasdemarcoyluis.model.enemies.Spiny;
import com.aventurasdemarcoyluis.model.interfaces.IEntities;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;
import com.aventurasdemarcoyluis.model.players.Luis;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhasesTest extends BaseTest {
    private GameController controller;

    @BeforeEach
    void setUp() {
        controller = new GameController();
        // Luis
        luis = controller.addLuis(20,23,17,60,12);

        // Enemigos
        goomba = controller.addGoomba(25,27,30,50);
        spiny = controller.addSpiny(13,6,15,20);
        boo = controller.addBoo(15,17,20,20);

        // Ataques
        hammer = new HammerAttack();
        jump = new JumpAttack();

        controller.setSeedRandomEnemy(10);
        controller.setSeedRandom(12);
        controller.setSeedAttack(8);
        // Combinación de numeros:
        // Primer número: 0 ataque, 1 seleccion de item, 2 pasar
        // Si primer número 0:
        // Segundo número: Se elige el enemigo según el número (los enemigos se eliminan a medida que mueren)
        // Tercer número: 1 para Martillo, 2 para Salto
        // Si primer número es 1:
        // Segundo número: 1 para HoneySyrup, 2 para RedMushroom
        // Si primer número es 2:
        // El jugador pasa.

        // Personajes:
        // Marco | nivel: 17, ataque: 90, defensa: 17, vida: 69, fp: 8
        // Luis | nivel: 15, ataque: 100, defensa: 14, vida: 72, fp: 10

        // Nivel de Batalla: 1
        // Boo | nivel: 16, ataque: 91, defensa: 16, vida: 35
        // Boo | nivel: 14, ataque: 93, defensa: 14, vida: 37
        // Boo | nivel: 15, ataque: 92, defensa: 15, vida: 36



    }

    @Test
    void electionPhase() throws InvalidElectionException {
        // Marco:
        // ElectionPhase 0 - Ataca,
        // WaitAttackPhase 1 - Boo, 2 - Salto (Attack Phase)
        // Termina turno
        // Luis:
        // ElectionPhase 0 - Ataca,
        // WaitAttackPhase 1 - Boo, 2 - Salto (Attack Phase)
        // Termina turno
        // Debe elegir, 0 - 1 - 2:
        // Marco:
        // ElectionPhase 3 - ERROR

        escenary("0\n1\n2\n0\n2\n1\n3");
        assertEquals("ElectionPhase",controller.getCurrentPhase());

        // Marco:
        // ElectionPhase 1 - Item,
        // WaitSelectItem 2 - Boo, 2 - Salto (Attack Phase)
        // Termina turno
        // Luis:
        // ElectionPhase 0 - Ataca,
        // WaitAttackPhase 1 - Boo, 2 - Salto (Attack Phase)
        // Termina turno
        // Debe elegir, 0 - 1 - 2:
        // Marco:
        // ElectionPhase 3 - ERROR

        escenary("0\n1\n2\n0\n2\n1\n3");
        assertEquals("ElectionPhase",controller.getCurrentPhase());
    }

    @Test
    void waitSelectItemPhase() throws InvalidElectionException {
        // Marco:
        // ElectionPhase 1 - Item,
        // WaitSelectItemPhase 2 - RedMushroom (UseItemPhase)
        // Termina turno
        // Luis:
        // ElectionPhase 1 - Item,
        // WaitSelectItemPhase 1 - HoneySyrup (UseItemPhase)
        // Termina turno
        // Debe elegir, 0 - 1 - 2:
        // Marco:
        // ElectionPhase 1 - Item,
        // WaitSelectItemPhase 0 - ERROR

        escenary("1\n2\n1\n1\n1\n0\n");
        assertEquals("WaitSelectItemPhase",controller.getCurrentPhase());
    }

    @Test
    void waitAttackPhase() throws InvalidElectionException {
        // Marco:
        // ElectionPhase 0 - Ataca,
        // WaitAttackPhase 1 - Boo, 2 - Salto (Attack Phase)
        // Termina turno
        // Luis:
        // ElectionPhase 0 - Ataca,
        // WaitAttackPhase 5 - ERROR

        escenary("0\n1\n5\n");
        assertEquals("WaitAttackPhase",controller.getCurrentPhase());
    }

    @Test
    void testSELECTItemXAtaque() throws InvalidElectionException, IOException {
        controller.setPhase(new WaitSelectItem());
        assertEquals("WaitSelectItemPhase",controller.getCurrentPhase());

        controller.setTurn(1);

        controller.addMarco(17,15,17,69,8);
        controller.addLuis(15,17,14,72,10);

        for (IPlayer player : controller.getListTurnPlayers()) {
            controller.getListTurn().add(player);
        }

        controller.getListTurn().add(goomba);
        controller.getListTurn().add(spiny);

        controller.setTurnEntity();
        controller.setPrintStream(System.out);
        controller.setBufferedReader(new BufferedReader(new StringReader("1\n2\n")));

        // QUEREMOS SELECCIONAR UN ENEMIGO PERO ESTAMOS EN LA FASE DE SELECCIONAR UN ITEM
        controller.electionAttack();

        assertEquals("WaitSelectItemPhase",controller.getCurrentPhase());
    }

    @Test
    void testSELECTAtaqueXItem() throws InvalidElectionException, IOException {
        controller.setPhase(new WaitAttackPhase());
        assertEquals("WaitAttackPhase",controller.getCurrentPhase());

        controller.setTurn(2);

        controller.addMarco(17,15,17,69,8);
        controller.addLuis(15,17,14,72,10);

        for (IPlayer player : controller.getListTurnPlayers()) {
            controller.getListTurn().add(player);
        }

        controller.getListTurn().add(goomba);
        controller.getListTurn().add(spiny);

        controller.setTurnEntity();
        controller.setPrintStream(System.out);
        controller.setBufferedReader(new BufferedReader(new StringReader("1\n2\n")));

        // QUEREMOS USAR UN ITEM PERO ESTAMOS EN LA FASE DE SELECCION DE ENEMIGO
        controller.electionUseItem();

        assertEquals("WaitAttackPhase",controller.getCurrentPhase());
    }

    @Test
    void testSTARTxUSEItem() throws InvalidElectionException, IOException {
        controller.setPhase(new StartPhase());
        assertEquals("StartPhase",controller.getCurrentPhase());

        controller.setTurn(1);

        controller.addMarco(17,15,17,69,8);
        controller.addLuis(15,17,14,72,10);

        for (IPlayer player : controller.getListTurnPlayers()) {
            controller.getListTurn().add(player);
        }

        controller.getListTurn().add(boo);

        controller.setTurnEntity();
        controller.setPrintStream(System.out);
        controller.setBufferedReader(new BufferedReader(new StringReader("1\n2\n")));

        // QUEREMOS USAR UN ITEM PERO ESTAMOS EN LA FASE DE INICIO
        controller.electionUseItem();

        assertEquals("StartPhase",controller.getCurrentPhase());
    }

    @Test
    void testSTARTxATTACK() {
        controller.setPhase(new StartPhase());
        assertEquals("StartPhase",controller.getCurrentPhase());

        controller.setTurn(1);

        controller.addMarco(17,15,17,69,8);
        controller.addLuis(15,17,14,72,10);

        for (IPlayer player : controller.getListTurnPlayers()) {
            controller.getListTurn().add(player);
        }

        controller.getListTurn().add(boo);

        controller.setTurnEntity();
        controller.setPrintStream(System.out);
        controller.setBufferedReader(new BufferedReader(new StringReader("1\n2\n")));

        // QUEREMOS USAR UN ITEM PERO ESTAMOS EN LA FASE DE INICIO
        controller.tryToAttack();

        assertEquals("StartPhase",controller.getCurrentPhase());
    }

    @Test
    void testENDTURNxChoose() {
        controller.setPhase(new EndTurn());
        assertEquals("EndTurnPhase",controller.getCurrentPhase());

        controller.setTurn(1);

        controller.addMarco(17,15,17,69,8);
        controller.addLuis(15,17,14,72,10);

        for (IPlayer player : controller.getListTurnPlayers()) {
            controller.getListTurn().add(player);
        }

        controller.getListTurn().add(boo);

        controller.setTurnEntity();
        controller.setPrintStream(System.out);
        controller.setBufferedReader(new BufferedReader(new StringReader("1\n2\n")));

        // QUEREMOS ELEGIR PERO ESTAMOS EN UN TURNO DE TERMINO
        controller.tryToChoose();

        assertEquals("EndTurnPhase",controller.getCurrentPhase());
    }

    @Test
    void testElectionXSTART() {
        controller.setPhase(new ElectionPhase());
        assertEquals("ElectionPhase",controller.getCurrentPhase());

        controller.setTurn(1);

        controller.addMarco(17,15,17,69,8);
        controller.addLuis(15,17,14,72,10);

        for (IPlayer player : controller.getListTurnPlayers()) {
            controller.getListTurn().add(player);
        }

        controller.getListTurn().add(boo);

        controller.setTurnEntity();
        controller.setPrintStream(System.out);
        controller.setBufferedReader(new BufferedReader(new StringReader("1\n2\n")));

        // QUEREMOS EMPEZAR PERO ESTAMOS EN UN TURNO DE ELECCION
        controller.tryToStart();

        assertEquals("ElectionPhase",controller.getCurrentPhase());
    }

    @Test
    void testElectionXENDTURN() {
        controller.setPhase(new ElectionPhase());
        assertEquals("ElectionPhase",controller.getCurrentPhase());

        controller.setTurn(1);

        controller.addMarco(17,15,17,69,8);
        controller.addLuis(15,17,14,72,10);

        for (IPlayer player : controller.getListTurnPlayers()) {
            controller.getListTurn().add(player);
        }

        controller.getListTurn().add(boo);

        controller.setTurnEntity();
        controller.setPrintStream(System.out);
        controller.setBufferedReader(new BufferedReader(new StringReader("1\n2\n")));

        // QUEREMOS TERMINAR PERO ESTAMOS EN UN TURNO DE ELECCION
        controller.tryToEndTurn();

        assertEquals("ElectionPhase",controller.getCurrentPhase());
    }

    // Creado para el escenario
    public void escenary(String stringNum) {
        controller.escenaryTestAttack(new PrintStream(new NullOutputStream()),new BufferedReader(new StringReader(stringNum)));
    }
}
