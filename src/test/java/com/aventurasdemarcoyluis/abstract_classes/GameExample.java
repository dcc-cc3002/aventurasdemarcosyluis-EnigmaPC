package com.aventurasdemarcoyluis.abstract_classes;

import com.aventurasdemarcoyluis.attacks.HammerAttack;
import com.aventurasdemarcoyluis.attacks.JumpAttack;
import com.aventurasdemarcoyluis.enemies.Boo;
import com.aventurasdemarcoyluis.enemies.Goomba;
import com.aventurasdemarcoyluis.enemies.Spiny;
import com.aventurasdemarcoyluis.items.HoneySyrup;
import com.aventurasdemarcoyluis.items.RedMushroom;
import com.aventurasdemarcoyluis.players.Luis;
import com.aventurasdemarcoyluis.players.Marco;


/**
 * Clase de Ejemplo para visualizar el funcionamiento del código.
 * Se puede observar el código mientras se ejecuta.
 *
 * @author Andrea PC
 */
public class GameExample {
    public static void main(String[] args) {
        // Players
        Marco marco = new Marco(22, 20,17,24, 11);
        Luis luis = new Luis(15, 13,23,19, 20);

        // Enemigos
        Goomba goomba = new Goomba(14, 10, 16, 13);
        Goomba kingGoomba = new Goomba(5, 4, 25, 120);
        Spiny spiny = new Spiny(16, 15, 21, 18);
        Boo boo = new Boo(16, 24, 23, 26);

        // Ataques
        HammerAttack hammer = new HammerAttack();
        JumpAttack jump = new JumpAttack();

        // Items
        HoneySyrup honeySyrup = new HoneySyrup();
        RedMushroom redMushroom = new RedMushroom();

        System.out.println("==========================================================================");
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("Luis:" + " HP = " + luis.getHP()+ "/" + luis.getMaxHP()
                + " FP = " +luis.getFP() + "/" + luis.getMaxFP());
        System.out.println("Goomba:" + " HP = " + goomba.getHP()+ "/" + goomba.getMaxHP());
        System.out.println("Boo:" + " HP = " + boo.getHP()+ "/" + boo.getMaxHP());
        System.out.println("Spiny:" + " HP = " + spiny.getHP()+ "/" + spiny.getMaxHP());
        System.out.println("==========================================================================");
        System.out.println("Marco y Luis pasean juntos por la pradera.");
        System.out.println("Marco se encuentra 2 Honey Syrup");
        marco.addItem(honeySyrup,2);
        System.out.println("Luis se encuentra 3 Red Mushroom");
        luis.addItem(redMushroom,3);
        System.out.println("   ");
        System.out.println("Aparece un Goomba salvaje!");
        System.out.println("Marco decide atacar a Goomba con Salto");
        marco.attack(goomba,jump);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("Goomba:" + " HP = " + goomba.getHP()+ "/" + goomba.getMaxHP());
        System.out.println("   ");
        System.out.println("Marco vuelve a atacar a Goomba");
        marco.attack(goomba,jump);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("Pero Marco no puede atacar pues Goomba murió!");
        System.out.println("   ");
        System.out.println("Spiny ve todo y decide tomar represalias");
        spiny.attack(marco);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("   ");
        System.out.println("Luis toma medidas y decide atacar con Salto.");
        luis.attack(spiny, jump);
        System.out.println("Spiny:" + " HP = " + spiny.getHP()+ "/" + spiny.getMaxHP());
        System.out.println("Luis:" + " HP = " + luis.getHP()+ "/" + luis.getMaxHP()
                + " FP = " +luis.getFP() + "/" + luis.getMaxFP());
        System.out.println("   ");
        System.out.println("Marco le dice a Luis inutil por no hacerle daño a Spiny");
        System.out.println("y decide ejemplificar atacando tambien con Salto");
        marco.attack(spiny, jump);
        System.out.println("Spiny:" + " HP = " + spiny.getHP()+ "/" + spiny.getMaxHP());
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("   ");
        System.out.println("Luis se rie de Marco, pero mientras lo hace le ataca Spiny");
        spiny.attack(luis);
        System.out.println("Spiny:" + " HP = " + spiny.getHP()+ "/" + spiny.getMaxHP());
        System.out.println("Luis:" + " HP = " + luis.getHP()+ "/" + luis.getMaxHP()
                + " FP = " +luis.getFP() + "/" + luis.getMaxFP());
        System.out.println("   ");
        System.out.println("Marco se da cuenta que la única posibilidad de ganarle a spiny" +
                " es con Martillo.");
        marco.attack(spiny, hammer);
        System.out.println("Spiny:" + " HP = " + spiny.getHP()+ "/" + spiny.getMaxHP());
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("   ");
        System.out.println("Descubierta su debilidad, aunque el ataque falle Spiny se va corriendo.");
        System.out.println("Boo despierta de su letargo para atormentar a los jugadores.");
        System.out.println("Luis y Marco se asustan. Luis decide tomarse todos sus Red Mushroom");
        luis.useItem(redMushroom);
        luis.useItem(redMushroom);
        luis.useItem(redMushroom);
        System.out.println("Luis:" + " HP = " + luis.getHP()+ "/" + luis.getMaxHP()
                + " FP = " +luis.getFP() + "/" + luis.getMaxFP());
        System.out.println("   ");
        System.out.println("Boo no ve a Mario por lo que solo ataca a Luis.");
        boo.attack(luis);
        System.out.println("Luis:" + " HP = " + luis.getHP()+ "/" + luis.getMaxHP()
                + " FP = " +luis.getFP() + "/" + luis.getMaxFP());
        System.out.println("   ");
        System.out.println("Luis se esconde rápidamente y le susurra a Marco que ataque a Boo.");
        System.out.println("Marco ataca con Martillo");
        marco.attack(boo,hammer);
        System.out.println("Pero Boo esquiva el ataque");
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("Boo:" + " HP = " + boo.getHP()+ "/" + boo.getMaxHP());
        System.out.println("   ");
        System.out.println("Marco ataca de nuevo con Martillo.");
        marco.attack(boo,hammer);
        System.out.println("Pero Boo vuelve a esquiva el ataque");
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("Boo:" + " HP = " + boo.getHP()+ "/" + boo.getMaxHP());
        System.out.println("   ");
        System.out.println("Luis insulta a Marco y le dice que ataque con Salto");
        marco.attack(boo,jump);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("Boo:" + " HP = " + boo.getHP()+ "/" + boo.getMaxHP());
        System.out.println("   ");
        System.out.println("Boo no encuentra Luis y no ve a Marco");
        marco.attack(boo,jump);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("Boo:" + " HP = " + boo.getHP()+ "/" + boo.getMaxHP());
        System.out.println("   ");
        System.out.println("Boo muere y Luis puede salir tranquilo");
        System.out.println("Derrepente escuchan un ruido fuerte y aparece King Goomba");
        System.out.println("King Goomba:" + " HP = " + kingGoomba.getHP()+ "/" + kingGoomba.getMaxHP());
        System.out.println("Luis se vuelve a esconder y deja a Marco solo.");
        System.out.println("Asi que Marco da la cara y se enfrenta en una lucha a muerte con King Goomba");
        System.out.println("Marco intenta usar Martillo pero no tiene suficientes puntos de ataque");
        marco.attack(kingGoomba,hammer);
        kingGoomba.attack(marco);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("   ");
        System.out.println("Luis se rie de Marco");
        System.out.println("Marco decide consumir todos sus Honey Syrup");
        marco.useItem(honeySyrup);
        marco.useItem(honeySyrup);
        System.out.println("Y ahora sí tiene una lucha a muerte con King Goomba");
        System.out.println("   ");
        marco.attack(kingGoomba,hammer);
        kingGoomba.attack(marco);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("King Goomba:" + " HP = " + kingGoomba.getHP()+ "/" + kingGoomba.getMaxHP());
        System.out.println("   ");
        marco.attack(kingGoomba,hammer);
        kingGoomba.attack(marco);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("King Goomba:" + " HP = " + kingGoomba.getHP()+ "/" + kingGoomba.getMaxHP());
        System.out.println("   ");
        System.out.println("Marco suda de nervios, no le quedan muchos FP");
        marco.attack(kingGoomba,jump);
        kingGoomba.attack(marco);
        System.out.println("Marco:" + " HP = " + marco.getHP()+ "/" + marco.getMaxHP()
                + " FP = " +marco.getFP() + "/" + marco.getMaxFP());
        System.out.println("King Goomba:" + " HP = " + kingGoomba.getHP()+ "/" + kingGoomba.getMaxHP());
        System.out.println("   ");
        System.out.println("King Goomba decide que Marco es demasiado poderoso y");
        System.out.println("huye de la batalla como un cobarde");
        System.out.println("   ");
        System.out.println("Luis sale de su escondite y le agradece a Marco con un calido abrazo");
        System.out.println("Marco y Luis se miran por unos segundos");
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
        System.out.println("El tiempo se detiene");
        System.out.println("Se miran");
        System.out.println("Y se besan");
        System.out.println("   ");
        System.out.println("FIN");
        System.out.println("==========================================================================");

    }
}
