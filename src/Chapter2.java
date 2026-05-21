public class Chapter2 extends Chapter {

    public Chapter2(Player player, EventBus eventBus, GameManager gameManager) {
        super(player, eventBus, gameManager);
    }

    @Override
    public String getTitle() { return "Chapter II — Repayment"; }

    @Override
    public void play() {
        boolean chapterComplete = false;

        while (!chapterComplete) {
            player.restoreHealth(player.getMaxHealth());

            TextUI.printTitle(getTitle());

            TextUI.printSlow("Rumbling.");
            TextUI.printSlow("You are awake before you understand why.");
            TextUI.printSlow("Then you hear it — steel on stone. Shouting. Something that is not quite screaming.");
            TextUI.pressEnter();

            TextUI.divider();
            TextUI.printSlow("The streets are chaos.");
            TextUI.printSlow("Fires have started in the eastern quarter. Your soldiers are on the ground.");
            TextUI.printSlow("The things that put them there are still moving.");
            TextUI.print("");
            TextUI.printSlow("They look like men. They wear armour you do not recognise.");
            TextUI.printSlow("But they do not move like men. No hesitation. No pain. No fear.");
            TextUI.printSlow("Just motion. Purpose. Something switched on and pointed forward.");
            TextUI.pressEnter();

            TextUI.printSlow("Dorian and Cael appear from a side corridor, blades drawn, both bleeding.");
            TextUI.printSlow("Dorian grabs your arm. \"Commander — the King. Get to the King.\"");
            TextUI.printSlow("\"We'll hold here,\" Cael says. He does not look like he believes it.");
            TextUI.printSlow("\"Go,\" Dorian says. \"Now.\"");
            TextUI.pressEnter();

            TextUI.divider();
            TextUI.printSlow("Baldwin finds you in the crowd — wordless, he falls into step beside you.");
            TextUI.printSlow("Two of you. The best two soldiers in the kingdom. It will have to be enough.");
            TextUI.print("");
            TextUI.printSlow("A blessed soldier steps into your path.");
            TextUI.pressEnter();

            Enemy soldier = EnemyFactory.createEnemy("BLESSED_SOLDIER");
            boolean won = runCombat(soldier, true);

            if (!won) {
                TextUI.printSlow("You fall. The capital burns around you.");
                TextUI.printSlow("...");
                TextUI.printSlow("You wake. The night is still young. The attack has not yet reached the King.");
                TextUI.printSlow("Prepare yourself.");
                TextUI.pressEnter();
                continue;
            }

            chapterComplete = true;

            TextUI.divider();
            TextUI.printSlow("You find King Maren in the inner chamber, surrounded by guards who could not have held much longer.");
            TextUI.printSlow("He is unhurt. Barely.");
            TextUI.print("");
            TextUI.printSlow("He sees you. And something crosses his face.");
            TextUI.printSlow("Not relief. Something else. Just for a moment. Then it is gone.");
            TextUI.printSlow("And he is the King again — composed, certain.");
            TextUI.pressEnter();

            TextUI.printSlow("\"The attack has stopped,\" a guard reports. \"They retreated. All of them. At once.\"");
            TextUI.print("");
            TextUI.printSlow("You look at the King. He is staring at the floor.");
            TextUI.pressEnter();

            TextUI.divider();
            TextUI.printSlow("You walk back through the corridor where Dorian and Cael had stood.");
            TextUI.printSlow("You already know what you will find.");
            TextUI.print("");
            TextUI.printSlow("They held. Of course they held.");
            TextUI.printSlow("They just didn't survive it.");
            TextUI.print("");
            TextUI.printSlow("You stand there for a moment. The city is quiet now.");
            TextUI.pressEnter();

            TextUI.divider();
            TextUI.printSlow("Later, the King takes you aside. Away from his court. Away from everyone.");
            TextUI.printSlow("He speaks quietly.");
            TextUI.print("");
            TextUI.printSlow("\"What struck us tonight... I have read of something like it. Ancient.\"");
            TextUI.printSlow("\"There is a monk — Brother Theodore — at the old monastery east of the capital.\"");
            TextUI.printSlow("\"He guards knowledge that could help us understand this. Help us stop it.\"");
            TextUI.printSlow("\"Go to him. Learn what we are dealing with. Tell no one.\"");
            TextUI.print("");
            TextUI.printSlow("He meets your eyes.");
            TextUI.printSlow("\"I trust only you with this, Aldric.\"");
            TextUI.pressEnter();

            TextUI.printSlow("You have never doubted him. You leave before dawn.");
            TextUI.pressEnter();
        }
    }
}
