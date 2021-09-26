package com.aventurasdemarcoyluis;

public class Goomba extends Enemy implements IEntities {
    public Goomba(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(Player player) {
        if (this.isDead() == false) {
            player.isAttacked(this);
        }
    }

    @Override
    public void playerAttack(Player player, AttackType attack) {
        this.isAttacked(player, attack);
    }
}
