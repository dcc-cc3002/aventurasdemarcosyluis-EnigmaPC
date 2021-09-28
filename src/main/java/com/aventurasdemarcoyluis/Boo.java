package com.aventurasdemarcoyluis;

public class Boo extends AbstractEnemy {
    public Boo(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    @Override
    public void attack(IPlayer player) {
        if (this.isDead() == false) {
            if ((player instanceof Marco) == false) {
                player.isAttacked(this);
            }
        }
    }

    @Override
    public void playerAttack(IPlayer player, AttackType attack) {
        if (attack.equals(AttackType.MARTILLO)) {
            this.dodge();
        } else {
            this.isAttacked(player, attack);
        }
    }
}
