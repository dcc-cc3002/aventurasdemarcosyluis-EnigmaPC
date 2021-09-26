package com.aventurasdemarcoyluis;

import java.util.Hashtable;

public abstract class Player extends Entities implements IObject {
    private boolean invincible;
    private Hashtable<Item, Integer> inventory; // Variable to put Items

    public Player(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
        this.inventory = new Hashtable<>(3);
        this.invincible = false;
    }

    public abstract void attack(Enemy enemy, AttackType attack);

    public Hashtable<Item, Integer> getInventory() {
        return inventory;
    }

    public void addItem(Item item) {
        if (hasItem(item)) {
            int amount = inventory.get(item);
            amount += 1;
            inventory.replace(item,amount);
        } else {
            inventory.put(item, 1);
        }
    }

    public int amountOfItem(Item item) {
        if (hasItem(item)) {
            int amount = inventory.get(item);
            return amount;
        } else {
            return 0;
        }
    }

    public void removeItem(Item item) {
        if (hasItem(item)) {
            int amount = inventory.get(item);
            amount -= 1;
            if (amount == 0) {
                inventory.remove(item);
            } else {
                inventory.replace(item, amount);
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

    public void thornsSpiny(Player player) {
        double damageDeal = 0.05*player.getHP();
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }

    public void useItem(Item item) {
        item.use(this);
    }
    public void isAttacked(Enemy enemy) {
        double damageDeal = enemy.getK()*enemy.getATK()*((double) enemy.getLVL()/this.getDEF());
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }
}
