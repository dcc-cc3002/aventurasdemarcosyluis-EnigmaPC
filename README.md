# Aventuras de Marcos y Luis
_Estudiante: Andrea Palma_ <br>
_Curso: CC3002_ <br>


## Generalidades
El código base creado se encuentra en el package
[main-aventurasdemarcoyluis](src/main/java/com/aventurasdemarcoyluis),
mientras que los test relacionados a este se encuentran en 
[test-aventurasdemarcoyluis](src/test/java/com/aventurasdemarcoyluis) <br>
- [MODEL_main](src/main/java/com/aventurasdemarcoyluis): Aquí se encuentra el esqueleto del modelo,
en donde se programaron
todas las clases, métodos, interfaces, etc. Se divide en: <br>

  - [MODEL_abstract_classes](src/main/java/com/aventurasdemarcoyluis/abstract_classes):
  En este package se encuentran todas las clases abstractas creadas.
Las cuales referencian a cada modelo: **Item** _(AbstractItem)_, **Entidad** _(AbstractEntities)_,
  **Enemigo** _(AbstractEnemy)_, **Player** _(AbstractPlayer)_, **Tipo de Ataque** _(AbstractAttackType)_. <br>
  - [MODEL_interfaces](src/main/java/com/aventurasdemarcoyluis/interfaces):
  En este package se encuentran todas las interfaces ocupadas. <br>
  - [MODEL_players](src/main/java/com/aventurasdemarcoyluis/players):
  En este package se encuentra los modelos de Jugadores. Los cuales son **Marco** y **Luis**. <br>
  - [MODEL_enemies](src/main/java/com/aventurasdemarcoyluis/enemies):
  En este package se encuentran los modelos de Enemigos. Los cuales son **Boo**, **Goomba** y **Spiny**. <br>
  - [MODEL_items](src/main/java/com/aventurasdemarcoyluis/items):
  En este package se encuentran los modelos de Item: **Honey Syrup**, **Red Mushroom** y **Star**. <br>
  - [MODEL_attacks](src/main/java/com/aventurasdemarcoyluis/attacks):
  En este packege se encuentran los modelos de Ataque: **Martillo** _(HammerAttack)_ y **Salto** _(JumpAttack)_.<br>

- [TEST_main](src/test/java/com/aventurasdemarcoyluis): Aquí se encuentran todos los test realizados
sobre el modelo y una clase ejecutable de ejemplo de juego
[GAME_EXAMPLE](src/test/java/com/aventurasdemarcoyluis/abstract_classes/GameExample.java). 
Se testean primero las clases abstractas que darán vida a los modelos mencionados anteriormente
y luego se testean por separado los enemigos y jugadores. <br>
  - [TEST_abstract_classes](src/test/java/com/aventurasdemarcoyluis/abstract_classes):
Se testean todos los métodos de las clases abstractas los cuales serán ocupados por cada modelo de item,
ataque, jugador o enemigo. Y las diferencias entre cada modelo. <br>
  - [TEST_players](src/test/java/com/aventurasdemarcoyluis/players):
Aquí se testea la interacción de los players con cada item (e inventario), los ataques sobre los enemigos y la correcta
funcionalidad de las características que poseen los players.  <br>
  - [TEST_enemies](src/test/java/com/aventurasdemarcoyluis/enemies):
Aquí se testean los ataques de los enemigos hacia los players. <br>

## Intrucciones
Puede acceder a cada lugar del código haciendo click en las anteriores referencias. Por ejemplo,
si quiere observar el código del modelo Luis, debe hacer click en **[MODEL_players]** de la sección anterior,
el cual le llevará al package que contiene el modelo Luis. <br>

Se recomienda ejecutar los test uno por uno, dirigiéndose al package donde
se encuentra el test, haciendo click encima del nombre y luego otro click en **[Run 'Test' in...]**.<br>

Si se requiere revisar el coverage de los test del código, diríjase a la carpeta **[test]**, haga click derecho sobre ella,
busque **[More Run/Debug]** y haga click en **[Run 'Test' With Coverage]**.

El archivo ejecutable de ejemplo se encuentra en 
[GAME_EXAMPLE](src/test/java/com/aventurasdemarcoyluis/abstract_classes/GameExample.java). Si se quiere revisar 
un enfrentamiento entre las entidades jugador v/s enemigos, usando items y todo, se recomienda ejecutar. 

## Supuestos
Siguiendo la tabla de ataques descrita en la sección 1.1.5 del
[Enunciado](https://www.u-cursos.cl/ingenieria/2021/2/CC3002/1/tareas/r/2021091617049EBCB4003D150FF0__Enunciado_Tarea_01.pdf)
se hacen los siguientes supuestos de ataque:
- Luis **NO** puede atacar a Boo. (No hay métodos que lo permitan)
- Boo **NO** puede atacar a Marco. (No hay métodos que lo permitan)
- Marco puede atacar a **TODOS** los enemigos.
- Spiny y Goomba pueden atacar a **TODOS** los jugadores.

Además se considera que:

- Los enemigos no pueden usar objetos.
- Inicialmente el inventario de los jugadores está vacío.
- Un jugador no puede ocupar un item que no esté en su inventario.
- Un jugador no puede tener cantidades negativas de un item en su inventario.
- Al usar un item, este se consume y se reduce la cantidad en el inventario.
- Si un jugador tiene su vida en máximo y usa Red Mushroom, no pasa nada.
- Si un jugador ya es invencible y usa Star, no pasa nada.
- Si un jugador tiene sus puntos de ataque en máximo y usa Honey Syrup, no pasa nada.
- Los enemigos no tienen **Puntos de Ataque (FP)** (estos son igual a 0), es decir,
ellos saben que pueden atacar siempre y cuando no estén muertos.
- Ninguna de las estadísticas de las entidades (enemigos y players) es negativa.
    - En definitiva, los métodos para la **Vida (HP)** y los **Puntos de Ataque (FP)**
  no permiten que estos sean menores a 0 ni mayores que el máximo (**maxHP** y **maxFP**).
- Cada clase sabe sus restricciones, por ejemplo, **Luis** sabe que no puede atacar a **Boo**
  (y no lo intenta) y **Boo** sabe que no puede atacar a **Marco** (y no lo intenta) 
[esto se explicará mejor después].

Para simular de mejor manera las peleas:

- **Por ahora** el "esquivar" será considerado como el método ***dodge*** (en _AbstractEntities_)
que printeará un mensaje que dice "Se ha esquivado el ataque".
- **Por ahora** se añadieron mensajes que printean las interacciones de items y pelea 
entre los jugadores y enemigos. Por ejemplo, al atacar a Spiny con un Salto se lanzará un mensaje que dirá "Spiny se 
protege con sus pinchos".

El ataque es calculado con la fórmula de la sección 1.1.3 del
[Enunciado](https://www.u-cursos.cl/ingenieria/2021/2/CC3002/1/tareas/r/2021091617049EBCB4003D150FF0__Enunciado_Tarea_01.pdf)
pero con una modificación de redondeo, pues para limpiar código, la parte del
cálculo con el ATK del personaje atacante con su LVL y la DEF del personaje atacado, 
se condensa en el método ***preDamage*** (en _AbstractEntities_):

![Calculo del daño](assets/Dano.png) 

Además, el resultado final también se redondea y se transforma a entero.

## Funcionamiento y Lógica del Programa
Tomando en cuenta los supuestos mencionados en la sección anterior. Se realizarán
algunos ejemplos de las funcionalidades de algunos métodos.

Tenemos a Marco y Luis como jugadores derivados de la clase abstracta _AbstractPlayer_,
y a Goomba, Boo y Spiny como enemigos derivados de la clase abstracta _AbstractEnemy_.

Marco y Luis pueden añadir a su inventario los items Honey Syrup, Red Mushroom y Star
derivados de la clase abstracta _AbstractItem_. Además, los ataques disponibles que pueden
ocupar son Martillo (HammerAttack) y Salto (JumpAttack) derivados de la clase abstracta
_AbstractAttackType_.

El programa en sí se basa meramente en la interacción de Marco y Luis con el mundo y los
enemigos. Los métodos que estos utilizan llamarán a los métodos necesarios en las clases necesarias
para realizar lo que necesiten. Por lo que meramente todo se basa en los métodos de Marco, Luis (y los
que estos heredan de _AbstractPlayer_ para el inventario) y los enemigos.

Como se añadieron mensajes que printean lo que sucede en batalla, para probar el funcionamiento
del programa se pueden revisar los tests de los Jugadores
([TEST_players](src/test/java/com/aventurasdemarcoyluis/players)) o de los Enemigos
([TEST_enemies](src/test/java/com/aventurasdemarcoyluis/enemies)). Al ejecutar estos tests
se imprimirá en pantalla lo que sucede.

Además, se añade la Clase Ejecutable 
[GAME_EXAMPLE](src/test/java/com/aventurasdemarcoyluis/abstract_classes/GameExample.java)
la cual contiene un código  ejecutable bastante visual parecido al que se presenta a continuación.

> Imaginemos que Marco y Luis se pasean juntos. <br>
> Si Marco encuentra un Star y un Honey Syrup se ejecuta: <br>
> _Marco.addItem(Star) <br>
> _Marco.addItem(Honey Syrup) <br>
> Ahora Marco tiene un Star y Honey Syrup en su inventario. Si se quiere comprobar se ejecuta: <br>
> _Marco.hasItem(Star) <br>
> _Marco.hasItem(Honey Syrup) <br>
> Si Marco y Luis se encuentran a Boo y quieren atacar, deben elegir con qué.
> Si Marco ataca con Martillo se ejecuta: <br>
> _Marco.attack(Boo, Martillo) <br>
> _Marco pierde 2 FP. <br>
> Pero Boo esquiva el ataque! Boo no puede atacar a Marco 
> por lo que solo ataca a Luis. <br>
> _Boo.attack(Luis) <br>
> **[Sería un error ejecutar Boo.attack(Marco)]** <br>
> Auch! Luis es herido por Boo, ahora quiere vengarse, pero
> le dan demasiado miedo los fantasmas, sabe que la debilidad de Boo es Salto, así
> que le dice a Marco que lo utilice.<br>
> _Marco.attack(Boo, Salto) <br>
> _Marco pierde 1 FP <br>
> _Marco mata a Boo <br>
> Eureka! Marco ha matado a Boo! Si intenta atacar otra vez no pasará nada. <br>
> _Marco.attack(Boo, Salto) <br>
> _Marco no pierde FP pues no puede atacar a un muerto. <br>
> Spiny vio como se piteaban a su amigo y decide ir en venganza. <br>
> _Spiny.attack(Marco) <br>
> Auch! Marco es herido por Spiny, como la debilidad de Boo es Salto, decide
> saltar para golpearle. <br>
> _Marco.attack(Spiny, Salto) <br>
> _Marco pierde 1 FP <br>
> _Marco se queda sin FP <br>
> _Spiny no es tonto y se protege con sus pinchos. <br>
> Ay! Marco es herido por los pinchos de Spiny, por lo menos no es grave. 
> Pero está re mal, no le quedan FP así que le dice a Luis que ataque por él, pero que 
> no use Salto porque Spiny se protegerá. <br>
> _Luis.attack(Spiny, Martillo) <br>
> _Luis falla el ataque <br>
> Por cosas del destino (y nada que ver con el 25% de probabilidad de fallar
> un ataque con Martillo) Luis falla. Spiny contraataca. <br>
> _Spiny.attack(Luis) <br>
> Marco comienza a tener miedo de que Luis falle todos sus ataques así que
> consume el Honey Syrup que tenía y ataca a Spiny. <br>
> _Marco.useItem(Honey Syrup) <br>
> _Marco ya no tiene Honey Syrup <br>
> _Marco pasó de tener 0 a 3 FP <br>
> _Marco.attack(Spiny, Martillo) <br>
> _Marco ahora tiene 2 FP <br>
> _Spiny muere. <br>
> Chao Spiny! Se murió. Sin embargo, Goomba aparece de la nada y le pega
> sendo combo al Luis.  <br>
> _Goomba.attack(Luis) <br>
> _Luis agoniza en el piso, tiene 1 HP. <br>
> NoooOOooOOo! Grita Marco. Con su sed de venganza consume la Star que
> tenía en el inventario. <br>
> _Marco.useItem(Star) <br>
> _Ahora Marco es invencible <br>
> Goomba le ataca ¡Pero no le hace nada, no puede es invencible! <br>
> _Goomba.attack(Marco) <br>
> _No pasa nada <br>
> _Marco.attack(Goomba, Salto) <br>
> _Marco pierde 1 FP ahora tiene 1. <br>
> A Goomba le dolió ese golpe pero sigue vivo! <br>
> _Goomba.attack(Marco) <br>
> _Marco sigue siendo invencible <br>
> _Marco.attack(Goomba, Salto) <br>
> _Marco se queda sin FP <br>
> _Goomba muere <br>
> Bien! Goomba murió y Marco corre a socorrer a Luis. Luis, en el piso
> le dice a Marco que lamentablemente ha llegado su día. Pero Marco no se
> rinde y le reza a los dioses para que Luis no muera. <br>
> ... <br>
> ... <br>
> Es su día de suerte pues de la nada le han dado un Red Mushroom a Luis. <br>
> _Luis.addItem(Red Mushroom) <br>
> Luis en un último intento de moverse, la consume. <br>
> _Luis.useItem(Red Mushroom) <br>
> ¡Luis ahora tiene suficiente vida para ir de copas con Marco! <br>
> Todos son felices. Marco y Luis se besan. <br>

## Anotaciones
Por favor notar que, como se menciona anteriormente. El uso de prints está hecho meramente para ejemplificar
un pequeño programa para esta entrega. Estos se eliminarán en las próximas tareas. 





