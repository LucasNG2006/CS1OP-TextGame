## Blessings — A Text Adventure

My project for the CS1OP Object-Oriented Programming coursework is a text-based RPG action adventure game based around a fictional medieval world with elements of magic. You play as Aldric, a very high ranking soldier in the kingdom of Ashenfeld. The kingdom has been living peacefully for thousands of years, until suddenly an unknown force attacks the kingdom. Your job is to find out where this attack has come from, why it has come and how to stop the enemy force. You fight your way through enemies uncovering the truth until the very end where you are given a choice that alters the ending of the game.

## Requirements

Java Development Kit (JDK) 21 or higher
A terminal or command prompt to run the game

## How to Run

First compile the source files using 
javac -d out src/*.java

Then run the game using
java -cp out Main

If using VS Code, press **Ctrl+Shift+B** to compile and run in one step.

## How to Run Tests

Tests are located in the "tests" folder and require JUnit 4.

First compile with Junit using
javac -cp junit-4.13.jar -d out src/.java tests/.java

To run the tests, use
java -cp out:junit-4.13.jar org.junit.runner.JUnitCore PlayerTest EnemyFactoryTest GameManagerTest

## Project Structure

CS1OP-TextGame/
    ├── src/
    │   ├── Main.java
    │   ├── Game.java
    │   ├── Player.java
    │   ├── Enemy.java
    │   ├── BlessedSoldier.java
    │   ├── BlessedGuardian.java
    │   ├── Baldwin.java
    │   ├── BaldwinSpar.java
    │   ├── KingMaren.java
    │   ├── EnemyFactory.java
    │   ├── GameManager.java
    │   ├── EventBus.java
    │   ├── GameEventListener.java
    │   ├── Chapter.java
    │   ├── Chapter1.java
    │   ├── Chapter2.java
    │   ├── Chapter3.java
    │   ├── Chapter4.java
    │   ├── ChapterFinal.java
    │   └── TextUI.java
    ├── tests/
    │   ├── PlayerTest.java
    │   ├── EnemyFactoryTest.java
    │   └── GameManagerTest.java
    ├── README.md
    ├── REPORT.md
    └── .gitignore

## Assumptions

The game is designed to be played in one sitting,there is no option to save.
The player makes choices by entering a number to select one of the given options.
The game is fully text based and uses no other features like sound, graphics etc.
Player health is fully restored for each chapter.
AI assistance (Claude) was used throughout development and is fully declared in the report.

## GitLab Repository

http://csgitlab.reading.ac.uk/lu016817/cs1op-textgame
