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

### Intrucciones
Puede acceder a cada lugar del código haciendo click en las anteriores referencias. Por ejemplo,
si quiere observar el código del modelo Luis, debe hacer click en **[MODEL_players]** de la sección anterior,
el cual le llevará al package que contiene el modelo Luis. <br>

Se recomienda ejecutar los test uno por uno, dirigiéndose al package donde
se encuentra el test, haciendo click encima del nombre, luego otro click en **[Run 'Test' in...]**.<br>

Si se requiere revisar el coverage de los test del código, diríjase a la carpeta **[test]**, haga click derecho sobre ella,
busque **[More Run/Debug]** y haga click en **[Run 'Test' With Coverage]**.

### Supuestos




