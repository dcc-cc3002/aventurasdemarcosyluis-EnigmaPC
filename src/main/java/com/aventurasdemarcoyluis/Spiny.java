package com.aventurasdemarcoyluis;

public class Spiny extends AbstractEnemy {
    public Spiny(int level, int attack, int defense, int healPoints, int fightPoints) {
        super(level, attack, defense, healPoints, fightPoints);
    }

    public void attack(AbstractPlayer player) {
        if (this.isDead() == false) {
            player.isAttacked(this);
        }
    }

    @Override
    public void playerAttack(AbstractPlayer player, AttackType attack) {
        if (attack.equals(AttackType.SALTO)) {
            player.thornsSpiny(player);
            this.dodge();
        } else {
            this.isAttacked(player, attack);
        }
    }

}
