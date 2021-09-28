package com.aventurasdemarcoyluis;

import java.util.Hashtable;

public abstract class AbstractPlayer extends AbstractEntities implements IPlayer {
    private boolean invincible;
    private Hashtable<IObject, Integer> inventory; // Variable to put Items

    public AbstractPlayer(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
        this.inventory = new Hashtable<>(3);
        this.invincible = false;
    }

    public abstract void attack(IEnemy enemy, AttackType attack);

    public Hashtable<IObject, Integer> getInventory() {
        return inventory;
    }

    public void addItem(IObject item, int amount) {
        if (this.hasItem(item)) {
            int amountFinal = inventory.get(item);
            amountFinal += amount;
            inventory.replace(item,amount);
        } else {
            inventory.put(item, amount);
        }
    }

    public int amountOfItem(IObject item) {
        if (this.hasItem(item)) {
            int amount = inventory.get(item);
            return amount;
        } else {
            return 0;
        }
    }

    public void removeItem(IObject item, int amount) {
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

    public boolean hasItem(IObject item) {
        return inventory.containsKey(item);
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean bool) {
        this.invincible = bool;
    }

    public void thornsSpiny(IPlayer player) {
        double damageDeal = 0.05*player.getHP();
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }

    public void useItem(IObject item) {
        if (hasItem(item)) {
            item.use(this);
            this.removeItem(item, 1);
        }
    }

    public void isAttacked(IEnemy enemy) { // Acá arreglar lo de enemy abstracto con interfaz
        double damageDeal = enemy.getK()*enemy.getATK()*((double) enemy.getLVL()/this.getDEF());
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }
}
