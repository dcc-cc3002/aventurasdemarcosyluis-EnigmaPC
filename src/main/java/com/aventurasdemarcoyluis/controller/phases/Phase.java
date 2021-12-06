package com.aventurasdemarcoyluis.controller.phases;

import com.aventurasdemarcoyluis.controller.GameController;
import com.aventurasdemarcoyluis.model.interfaces.IAttacks;
import com.aventurasdemarcoyluis.model.interfaces.IEnemy;
import com.aventurasdemarcoyluis.model.interfaces.IObject;
import com.aventurasdemarcoyluis.model.interfaces.IPlayer;

import java.io.IOException;

/**
 * <b>Clase Phase:</b> <br>
 * Modela una Fase <br>
 * Los campos que posee son: <br>
 * <b>controller</b>: controlador asociado <br>
 * <b>canAttack</b>: Estado de pelea (si puede pelear o no) <br>
 * <b>canUseItem</b>: Estado de uso de item (si puede usar un item o no) <br>
 * <b>canIStart</b>: Estado de inicio del turno (si puede iniciar al turno o no) <br>
 * <b>canIChoose</b>: Estado de elección del jugador (si puede elegir entre atacar, usar item, pasar o no) <br>
 * <b>canIEndTurn</b>: Estado de termino del turno (si puede terminar el turno o no) <br>
 * <b>WaitToAttack</b>: Estado de eleccion de ataque (si puede elegir a quien atacar o no) <br>
 * <b>WaitToUseItem</b>: Estado de eleccion de item (si puede elegir un item o no) <br>
 *
 *
 * @author Andrea PC
 */
public class Phase {
    protected GameController controller ;
    public boolean canAttack;
    public boolean canUseItem;
    public boolean canIStart;
    public boolean canIChoose;
    public boolean canIEndTurn;
    public boolean WaitToAttack;
    public boolean WaitToUseItem;

    /**
     * Método que setea el controlador asociado
     * @param controller Controlador asociado
     */
    public void setController(GameController controller){
        this.controller=controller;
    }

    /**
     * Método para cambiar de Fase
     * @param phase Fase a cambiar
     */
    protected void changePhase(Phase phase){
        controller.setPhase(phase);
    }

    /**
     * Método que retorna el nombre de la fase actual
     * @return Nombre de la fase actual
     */
    public String toString(){
        return "Phase";
    }

    /**
     * Método para empezar el turno.
     * Si el que tiene el turno es un enemigo, pasa a la fase elección y elige como enemigo
     * (elige al jugador por atacar).
     * Si el que tiene el turno es jugador, pasa la fase de elección y elige como jugador
     * (siguiendo el State Pattern).
     * @throws InvalidStateException Si está en un estado incorrecto (por ej, si no puede empezar)
     * @throws InvalidTransitionException Si está en una fase incorrecta (por ejemplo en la fase EndTurnFase)
     */
    public void start() throws InvalidStateException, InvalidTransitionException {
        if (!controller.getTurnEntity().isPlayer()) {
            toElectionPhase();
            controller.enemyElection();
        }
        else if(!canIStart){
            throw new InvalidStateException("No puedes empezar en"+ toString());
        }
        else{
            toElectionPhase();
            controller.tryToChoose();
        }
    }

    /**
     * Método para empezar a elegir Atacar, Usar Item o defender.
     * @throws InvalidStateException Si está en un estado incorrecto
     * @throws IOException Excepción default
     * @throws InvalidElectionException Si usó una elección incorrecta
     */
    public void election() throws InvalidStateException, IOException, InvalidElectionException {
        if (!canIChoose) {
            throw new InvalidStateException("No puedes elegir en" + toString());
        }
        controller.electionTurn();
    }

    /**
     * Método para elegir Martillo o Salto
     * @throws InvalidStateException Si está en un estado incorrecto
     * @throws InvalidElectionException Si usó una elección incorrecta
     * @throws IOException Excepción default
     */
    public void selectAttack() throws InvalidStateException, InvalidElectionException, IOException {
        if(!WaitToAttack){
            throw new InvalidStateException("No puedes pelear en: " + toString());
        }
    }

    /**
     * Método para elegir RedMushroom o HoneySyrup
     * @throws InvalidStateException Si está en un estado incorrecto
     * @throws InvalidElectionException Si usó una elección incorrecta
     * @throws IOException Excepción default
     */
    public void selectItem() throws InvalidStateException, InvalidElectionException, IOException {
        if(!WaitToUseItem){
            throw new InvalidStateException("No seleccionar un item en: " + toString());
        }
    }

    /**
     * Método para terminar el turno.
     * Si la batalla se perdió entonces los jugadores perdieron y se termina el juego.
     * @throws InvalidStateException Si está en un estado incorrecto
     * @throws InvalidTransitionException Si está en una fase incorrecta
     */
    public void endTurn() throws InvalidStateException, InvalidTransitionException {
        if(!canIEndTurn){
            throw new InvalidStateException("No puedes terminar el turno en " + this.toString());
        }
        toStartPhase();
        controller.finishTurn();
    }

    /**
     * Método para atacar
     * @throws InvalidStateException Si está en un estado incorrecto
     */
    public void attack() throws InvalidStateException {
        if (!canAttack) {
            throw new InvalidStateException("No puedes atacar ahora.");
        }
    }

    /**
     * Método para usar un item
     * @throws InvalidStateException Si está en un estado incorrecto
     */
    public void useItem() throws InvalidStateException {
        if (!canUseItem) {
            throw new InvalidStateException("No puedes usar un item ahora.");
        }
    }

    /**
     * Método para ir a la fase de elección
     * @throws InvalidTransitionException Si está en una fase incorrecta
     */
    public void toElectionPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + " a la fase ElectionPhase");
    }

    /**
     * Método para ir a la fase de termino de turno
     * @throws InvalidTransitionException Si está en una fase incorrecta
     */
    public void toEndTurnPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + " a la fase EndTurn");
    }

    /**
     * Método para ir a la fase de Inicio de turno
     * @throws InvalidTransitionException Si está en una fase incorrecta
     */
    public void toStartPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase StartPhase");
    }

    /**
     * Método para ir a la fase de eleccion de ataque
     * @throws InvalidTransitionException Si está en una fase incorrecta
     * @throws InvalidElectionException Si usa una elección incorrecta
     */
    public void toWaitAttackPhase() throws InvalidTransitionException, InvalidElectionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase WaitAttackPhase");
    }

    /**
     * Método para ir a la fase de ataque
     * @param attacker atacante
     * @param opponent defensor
     * @param selectedAttack ataque seleccionado
     * @throws InvalidTransitionException Si está en una fase incorrecta
     */
    public void toAttackPhase(IPlayer attacker, IEnemy opponent, IAttacks selectedAttack) throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase AttackPhase");
    }

    /**
     * Método para ir a la fase de elección de item
     * @throws InvalidTransitionException Si está en una fase incorrecta
     */
    public void toWaitSelectItemPhase() throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase WaitSelectItemPhase");
    }

    /**
     * Método para ir a la fase de uso de item
     * @param jugador jugador que usa el item
     * @param object item
     * @throws InvalidTransitionException Si está en una fase incorrecta
     */
    public void toUseItemPhase(IPlayer jugador, IObject object) throws InvalidTransitionException {
        throw new InvalidTransitionException(
                "No se puede cambiar de " + this.toString() + "a la fase UseItemPhase");
    }



}
