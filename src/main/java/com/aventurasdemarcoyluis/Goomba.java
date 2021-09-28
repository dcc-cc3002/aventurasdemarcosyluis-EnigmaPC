package com.aventurasdemarcoyluis;

public class Goomba extends AbstractEnemy {
    public Goomba(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(IPlayer player) {
        if (this.isDead() == false) {
            player.isAttacked(this);
        }
    }

    @Override
    public void playerAttack(IPlayer player, AttackType attack) {
        this.isAttacked(player, attack);
    }
}
