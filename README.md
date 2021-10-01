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
  - [MODEL_attacks](src/main/java/com/aventurasdemarcoyluis/items):
  En este packege se encuentran los modelos de Ataque: **Martillo** _(HammerAttack)_ y **Salto** _(JumpAttack)_.<br>

- [TEST_main](src/test/java/com/aventurasdemarcoyluis): Aquí se encuentran todos los test realizados
sobre el modelo. Se testean primero las clases abstractas que darán vida a los modelos mencionados anteriormente
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
- **Por ahora** al atacar a Spiny con un Salto se lanzará un mensaje que dirá "Spiny se 
protege con sus pinchos".

El ataque es calculado con la fórmula de la sección 1.1.3 del
[Enunciado](https://www.u-cursos.cl/ingenieria/2021/2/CC3002/1/tareas/r/2021091617049EBCB4003D150FF0__Enunciado_Tarea_01.pdf)
pero con una modificación de redondeo, pues para limpiar código, la parte del
cálculo con el ATK del personaje atacante con su LVL y la DEF del personaje atacado, 
se condensa en el método ***preDamage*** (en _AbstractEntities_):
![Calculo del daño](assets/Dano.png)

## Funcionamiento y Lógica del Programa

Tomando en cuenta los supuestos mencionados en la sección anterior. Se realizarán
algunos ejemplos de las funcionalidades de algunos métodos.

Tenemos a Marco y Luis como jugadores derivados de la clase abstracta _AbstractPlayer_,
y a Goomba, Boo y Spiny como enemigos derivados de la clase abstracta _AbstractEnemy_.

Marco y Luis pueden añadir a su inventario los items Honey Syrup, Red Mushroom y Star
derivados de la clase abstracta _AbstractItem_. Además, los ataques disponibles que pueden
ocupar son Martillo (HammerAttack) y Salto (JumpAttack) derivados de la clase abstracta
_AbstractAttackType_.

> Si Marco encuentra una estrella se ejecuta: <br>
> Marco.addItem(Star) <br>
> Ahora Marco tiene una estrella en su inventario. Si se quiere comprobar se ejecuta: <br>
> Marco.hasItem(Star) <br>
> Si Marco y Luis se encuentran a Boo y quieren atacar, deben elegir con qué.
> Si Marco ataca con Martillo se ejecuta: <br>
> Marco.attack(Boo, Martillo) <br>
> Marco pierde 2 FP. <br>
> Pero Boo esquiva el ataque! Boo no puede atacar a Marco 
> por lo que solo ataca a Luis. <br>
> Boo.attack(Luis) **[Sería un error ejecutar Boo.attack(Marco)]** <br>
> Auch! Luis es herido por Boo, ahora quiere vengarse, pero
> le dan demasiado miedo los fantasmas, sabe que la debilidad de Boo es Salto, así
> que le dice a Marco que lo utilice.<br>
> Marco.attack(Boo, Salto) <br>
> Marco pierde 1 FP <br>
> Eureka! Marco ha matado a Boo! Si intenta atacar otra vez no pasará nada.
> Marco.attack(Boo, Salto)






