package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.interfaces.IAttacks;
import com.aventurasdemarcoyluis.interfaces.IEnemy;
import com.aventurasdemarcoyluis.interfaces.IObject;
import com.aventurasdemarcoyluis.interfaces.IPlayer;

import java.util.Hashtable;

public abstract class AbstractPlayer extends AbstractEntities implements IPlayer {
    private boolean invincible;
    private Hashtable<IObject, Integer> inventory; // Variable to put Items

    public AbstractPlayer(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
        this.inventory = new Hashtable<>(3);
        this.invincible = false;
    }

    protected void addItem(IObject item, int amount) {
        if (this.hasItem(item)) {
            int amountFinal = inventory.get(item);
            amountFinal += amount;
            inventory.replace(item,amountFinal);
        } else {
            inventory.put(item, amount);
        }
    }

    protected int amountOfItem(IObject item) {
        if (this.hasItem(item)) {
            return inventory.get(item);
        } else {
            return 0;
        }
    }

    protected void removeItem(IObject item, int amount) {
        if (this.hasItem(item)) {
            int amountFinal = inventory.get(item);
            amountFinal -= amount;
            if (amountFinal <= 0) {
                inventory.remove(item);
            } else {
                inventory.replace(item, amountFinal);
            }
        }
    }

    protected boolean hasItem(IObject item) {
        return inventory.containsKey(item);
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean bool) {
        this.invincible = bool;
    }

    public void useHoneySyrup() {
        int newFP = this.getFP()+3;
        this.setFP(newFP);
    }

    public void useRedMushroom() {
        double amountOfHeal = this.getMaxHP()*0.1;
        int HP = this.getHP();
        int newHP = (int) (HP + amountOfHeal);
        this.setHP(newHP);
    }

    public void useStar() {
        this.setInvincible(true);
    }

    public double damageThornsSpiny() {
        return 0.05*this.getHP();
    }

    private void useItem(IObject item) {
        if (hasItem(item)) {
            item.use(this);
            this.removeItem(item, 1);
        }
    }

    public double enemyDoDamage(IEnemy enemy) {
        return 0.75*this.preDamage(enemy);
    }

    public void attackCost(IAttacks attack) {
        int nuevoFP = this.getFP() - attack.getFPCost();
        this.setFP(nuevoFP);
    }
}
