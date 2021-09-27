package com.aventurasdemarcoyluis;

import java.util.Hashtable;

public abstract class AbstractPlayer extends AbstractEntities implements IObject {
    private boolean invincible;
    private Hashtable<Item, Integer> inventory; // Variable to put Items

    public AbstractPlayer(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
        this.inventory = new Hashtable<>(3);
        this.invincible = false;
    }

    public abstract void attack(AbstractEnemy enemy, AttackType attack);

    public Hashtable<Item, Integer> getInventory() {
        return inventory;
    }

    public void addItem(Item item, int amount) {
        if (this.hasItem(item)) {
            int amountFinal = inventory.get(item);
            amountFinal += amount;
            inventory.replace(item,amount);
        } else {
            inventory.put(item, amount);
        }
    }

    public int amountOfItem(Item item) {
        if (this.hasItem(item)) {
            int amount = inventory.get(item);
            return amount;
        } else {
            return 0;
        }
    }

    public void removeItem(Item item, int amount) {
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

    public boolean hasItem(Item item) {
        return inventory.containsKey(item);
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean bool) {
        this.invincible = bool;
    }

    public void thornsSpiny(AbstractPlayer player) {
        double damageDeal = 0.05*player.getHP();
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }

    public void useItem(Item item) {
        if (hasItem(item)) {
            item.use(this);
            this.removeItem(item, 1);
        }
    }

    public void isAttacked(AbstractEnemy enemy) { // Acá arreglar lo de enemy abstracto con interfaz
        double damageDeal = enemy.getK()*enemy.getATK()*((double) enemy.getLVL()/this.getDEF());
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }
}
