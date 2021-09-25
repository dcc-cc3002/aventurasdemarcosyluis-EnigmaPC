package com.aventurasdemarcoyluis;

import java.util.Hashtable;

public class Player extends Entities {
    private Hashtable<Item, Integer> inventory; // Variable to put Items

    public Player(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
        this.inventory = new Hashtable<>(3);
    }

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

    public Item extractItem(Item item) {
        if (hasItem(item)) {
            int amount = inventory.get(item);
            amount -= 1;
            if (amount == 0) {
                inventory.remove(item);
            } else {
                inventory.replace(item, amount);
            }
            return item;
        } else {
            return null;
        }
    }

    public boolean hasItem(Item item) {
        return inventory.containsKey(item);
    }

    @Override
    public void attack(IEntities entities) {
        entities.playerAttack(this);
    }

    @Override
    public void enemyAttack(Enemy enemy) {
        double damageDeal = enemy.getK()*enemy.getATK()*((double) enemy.getLVL()/this.getDEF());
        int nuevoHP = (int) (this.getHP() - damageDeal);
        this.setHP(nuevoHP);
    }

    @Override
    public void playerAttack(Player player) {

    }
}
