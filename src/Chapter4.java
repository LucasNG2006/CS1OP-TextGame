public class Chapter4 extends Chapter {

    public Chapter4(Player player, EventBus eventBus, GameManager gameManager) {
        super(player, eventBus, gameManager);
    }

    @Override
    public String getTitle() { return "Chapter IV — Judgment"; }

    @Override
    public void play() {
        boolean chapterComplete = false;

        while (!chapterComplete) {
            player.restoreHealth(player.getMaxHealth());

            TextUI.printTitle(getTitle());

            TextUI.printSlow("East of the capital, past the river, the land changes.");
            TextUI.printSlow("Quieter. Older. Off every road you have ever been trained to use.");
            TextUI.printSlow("You find the village not by looking for it, but by following something you cannot name.");
            TextUI.pressEnter();

            TextUI.printSlow("It is small. Hidden between the trees like it grew there rather than was built.");
            TextUI.printSlow("The people see you before you see them.");
            TextUI.printSlow("They do not run. They do not speak. They simply watch.");
            TextUI.printSlow("An Ashenfeld soldier, in their village, wearing the King's colours.");
            TextUI.pressEnter();

            TextUI.printSlow("An elder steps forward. Old, straight-backed, unafraid.");
            TextUI.printSlow("\"You should not be here,\" she says simply.");
            TextUI.print("");
            TextUI.printSlow("Before you can answer — something moves in the trees.");
            TextUI.pressEnter();

            TextUI.divider();
            TextUI.printSlow("The village guardian. Blessed, built to protect these people from a world that has not been kind to them.");
            TextUI.printSlow("It does not distinguish between threat and visitor. It sees the uniform. That is enough.");
            TextUI.pressEnter();

            boolean combatResult = runChapter4Combat();

            if (!combatResult) {
                TextUI.printSlow("The elder turns away from you.");
                TextUI.printSlow("\"Leave. And do not return.\"");
                TextUI.printSlow("...");
                TextUI.printSlow("You stop. That was wrong. You knew it the moment you hesitated.");
                TextUI.printSlow("You turn back.");
                TextUI.pressEnter();
                continue;
            }

            chapterComplete = true;

            TextUI.divider();
            TextUI.printSlow("The guardian retreats into the trees. Battered, but not broken.");
            TextUI.printSlow("It protects. It was never meant to destroy.");
            TextUI.print("");
            TextUI.printSlow("Silence settles over the village.");
            TextUI.pressEnter();

            TextUI.printSlow("The elder looks at you for a long moment.");
            TextUI.print("");
            TextUI.printSlow("\"You saved her,\" she says. \"An enemy's child. Without hesitation.\"");
            TextUI.print("");
            TextUI.printSlow("She says the next words quietly, as though reading from something written long ago:");
            TextUI.print("");
            TextUI.printSlow("\"Despite being our enemy — he opened his heart.\"");
            TextUI.print("");
            TextUI.printSlow("\"It is him. The prophecy child. He will save the land.\"");
            TextUI.pressEnter();

            TextUI.divider();
            TextUI.printSlow("They speak to you then. All of them, in turns.");
            TextUI.printSlow("They are the Everlast — the ones who chose a different path. Not revenge. Patience.");
            TextUI.printSlow("A prophecy that said one would come from within the enemy.");
            TextUI.printSlow("One worthy enough to carry the truth forward.");
            TextUI.pressEnter();

            TextUI.printSlow("The elder brings something forward. A small stone, dark and warm in her hands.");
            TextUI.print("");
            TextUI.printSlow("\"We have kept this hidden for one thousand years,\" she says.");
            TextUI.printSlow("\"The others — the ones who attacked your capital — they have been stealing fragments of it.\"");
            TextUI.printSlow("\"That is how they bless their soldiers. Broken pieces of something they were never meant to take.\"");
            TextUI.print("");
            TextUI.printSlow("\"This is the pure source. It was always meant for you.\"");
            TextUI.pressEnter();

            TextUI.printSlow("She places it in your hands.");
            TextUI.printSlow("You feel it before you understand it — a warmth that moves up through your arms and settles.");
            TextUI.printSlow("Your strength. Your speed. Heightened. But you are still yourself.");
            TextUI.printSlow("Completely, entirely yourself.");
            TextUI.print("");
            player.absorbGem();
            TextUI.printSlow("[The gem has been absorbed. Attack power increased to " + player.getAttackDamage() + ".]");
            TextUI.pressEnter();

            TextUI.divider();
            TextUI.printSlow("\"Go back,\" the elder says. \"Face what sent you here.\"");
            TextUI.printSlow("\"You think you are saving the land from us.\"");
            TextUI.print("");
            TextUI.printSlow("\"You are not.\"");
            TextUI.print("");
            TextUI.printSlow("\"You will understand when you return.\"");
            TextUI.pressEnter();
        }
    }

    private boolean runChapter4Combat() {
        Enemy guardian = EnemyFactory.createEnemy("BLESSED_GUARDIAN");
        boolean girlSaved = false;
        boolean girlEventTriggered = false;
        int round = 0;

        TextUI.divider();
        TextUI.printSlow("You face: " + guardian.getName());
        TextUI.printSlow(guardian.getDescription());
        TextUI.divider();

        while (guardian.isAlive() && player.isAlive()) {
            round++;

            TextUI.printStatus(player.getHealth(), player.getMaxHealth());
            TextUI.print("[" + guardian.getName() + " health: " + guardian.getHealth() + "/" + guardian.getMaxHealth() + "]");
            TextUI.print("");

            // Girl event triggers on round 2
            if (round == 2 && !girlEventTriggered) {
                girlEventTriggered = true;
                TextUI.divider();
                TextUI.printSlow("A girl — no older than ten — stumbles from behind a building.");
                TextUI.printSlow("Directly into the guardian's path. It turns toward her.");
                TextUI.print("");
                TextUI.print("What do you do?");
                TextUI.print("1. Throw yourself in front of her — take the hit");
                TextUI.print("2. Stay focused on the guardian");
                int saveChoice = TextUI.getChoice(2);

                if (saveChoice == 1) {
                    girlSaved = true;
                    TextUI.printSlow("You move without thinking. The blow meant for her catches you instead.");
                    player.takeDamage(guardian.getAttackDamage());
                    TextUI.printSlow("She is safe. You are not unharmed. But she is safe.");
                    TextUI.pressEnter();
                } else {
                    TextUI.printSlow("You hold your ground. The guardian's strike hits the girl.");
                    TextUI.printSlow("She falls.");
                    return false;
                }
                continue;
            }

            // Guardian flees when badly wounded
            if (guardian.getHealth() <= 20) {
                TextUI.printSlow("The guardian hesitates. Something in it recognises when the fight is lost.");
                TextUI.printSlow("It turns and retreats into the trees.");
                return girlSaved;
            }

            // Normal combat turn
            TextUI.print("What do you do?");
            TextUI.print("1. Attack");
            TextUI.print("2. Recover (skip turn, restore 10 health)");
            int choice = TextUI.getChoice(2);

            if (choice == 1) {
                int damage = player.getAttackDamage();
                guardian.takeDamage(damage);
                TextUI.printSlow("You strike the guardian for " + damage + " damage.");
            } else {
                player.restoreHealth(10);
                TextUI.printSlow("You steady yourself and recover. (+10 health)");
            }

            if (guardian.isAlive()) {
                TextUI.printSlow(guardian.getAttackMessage());
                player.takeDamage(guardian.getAttackDamage());
                TextUI.print("");
            }
        }

        return girlSaved && player.isAlive();
    }
}
