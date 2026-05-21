public class ChapterFinal extends Chapter {

    public ChapterFinal(Player player, EventBus eventBus, GameManager gameManager) {
        super(player, eventBus, gameManager);
    }

    @Override
    public String getTitle() { return "Final Chapter — The Weight of the Crown"; }

    @Override
    public void play() {
        TextUI.printTitle(getTitle());

        // Return to Ashenfeld
        TextUI.printSlow("Ashenfeld looks the same as you left it.");
        TextUI.printSlow("The damage from the attack has been cleared. The streets are calm.");
        TextUI.printSlow("No one knows what you carry.");
        TextUI.pressEnter();

        TextUI.printSlow("King Maren receives you in his private chamber. No court. No guards.");
        TextUI.printSlow("Just the two of you.");
        TextUI.print("");
        TextUI.printSlow("You tell him everything.");
        TextUI.printSlow("The Everlast. The massacre. Queen Celia.");
        TextUI.printSlow("The two factions. The gem. The prophecy.");
        TextUI.pressEnter();

        TextUI.printSlow("The King listens without interrupting.");
        TextUI.printSlow("When you finish, he is quiet for a long moment.");
        TextUI.print("");
        TextUI.printSlow("Then he nods.");
        TextUI.print("");
        TextUI.printSlow("\"You have done well, Aldric. Better than I hoped.\"");
        TextUI.printSlow("\"Now I need one more thing from you.\"");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.printSlow("\"Use the power they gave you. End the Everlast.\"");
        TextUI.printSlow("\"All of them. The ones who attacked us and the ones who helped you.\"");
        TextUI.printSlow("\"Finish what Celia started. Secure this kingdom for another thousand years.\"");
        TextUI.print("");
        TextUI.printSlow("He looks at you the way he always has. Certain. Warm. Trusting.");
        TextUI.printSlow("Like a father asking something reasonable of a son.");
        TextUI.pressEnter();

        // The refusal
        TextUI.printSlow("You are quiet for a moment.");
        TextUI.print("");
        TextUI.printSlow("\"No.\"");
        TextUI.pressEnter();

        TextUI.printSlow("\"Aldric—\"");
        TextUI.print("");
        TextUI.printSlow("\"I know what was done to them. I know what Celia did. I know what this kingdom is built on.\"");
        TextUI.printSlow("\"I will not add to it.\"");
        TextUI.pressEnter();

        TextUI.printSlow("The warmth in the King's face goes out like a candle.");
        TextUI.printSlow("What remains underneath is something older. Harder.");
        TextUI.print("");
        TextUI.printSlow("\"Then you leave me no choice.\"");
        TextUI.print("");
        TextUI.printSlow("He opens the door.");
        TextUI.print("");
        TextUI.printSlow("Baldwin is standing there.");
        TextUI.pressEnter();

        // Baldwin confrontation
        TextUI.divider();
        TextUI.printSlow("Baldwin looks at you. His face is not angry.");
        TextUI.printSlow("That is almost worse.");
        TextUI.print("");
        TextUI.printSlow("\"Aldric. The King told me what you said. What you're trying to do.\"");
        TextUI.printSlow("\"I've known you twenty years. Fought beside you. Bled beside you.\"");
        TextUI.printSlow("\"But the King is the kingdom. If you tear this down, you tear everything down.\"");
        TextUI.print("");
        TextUI.printSlow("He draws his blade.");
        TextUI.print("");
        TextUI.printSlow("\"I'm sorry,\" he says.");
        TextUI.pressEnter();

        TextUI.printSlow("He knows all your moves. This won't be easy.");
        TextUI.pressEnter();

        // Baldwin fight — retries until won
        boolean beatBaldwin = false;
        while (!beatBaldwin) {
            player.restoreHealth(player.getMaxHealth());
            Enemy baldwin = EnemyFactory.createEnemy("BALDWIN");
            beatBaldwin = runCombat(baldwin, true);
            if (!beatBaldwin) {
                TextUI.printSlow("You fall before your oldest friend.");
                TextUI.printSlow("...");
                TextUI.printSlow("You rise. You are not done.");
                TextUI.pressEnter();
            }
        }

        // After Baldwin
        TextUI.divider();
        TextUI.printSlow("Baldwin is on the ground. Breathing hard. Beaten but alive.");
        TextUI.printSlow("He looks up at you.");
        TextUI.print("");
        TextUI.printSlow("\"You were always... better than me,\" he says quietly.");
        TextUI.printSlow("He closes his eyes.");
        TextUI.pressEnter();

        // The choice
        TextUI.divider();
        TextUI.printSlow("King Maren stands alone now.");
        TextUI.printSlow("The crown on his head. The fragment inside it. A thousand years of stolen power.");
        TextUI.print("");
        TextUI.printSlow("He looks at you. For the first time, he looks afraid.");
        TextUI.print("");
        TextUI.printSlow("You hold everything. The truth. The gem. The choice.");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.print("What do you do?");
        TextUI.print("");
        TextUI.print("1. Stand with the King.");
        TextUI.print("   Take up the blade. End the Everlast. The lie survives. Ashenfeld endures.");
        TextUI.print("");
        TextUI.print("2. Face the King.");
        TextUI.print("   End this. The truth comes out. Everything changes.");
        TextUI.print("");
        int finalChoice = TextUI.getChoice(2);
        gameManager.setEndingChoice(finalChoice);

        if (finalChoice == 1) {
            endingKingsWar();
        } else {
            endingLiberation();
        }

        gameManager.setGameRunning(false);
    }

    private void endingKingsWar() {
        TextUI.divider();
        TextUI.printSlow("You pick up your sword.");
        TextUI.print("");
        TextUI.printSlow("The King watches you. Something like relief crosses his face.");
        TextUI.printSlow("\"I knew,\" he says quietly. \"I always knew you would understand.\"");
        TextUI.pressEnter();

        TextUI.printSlow("You ride east the next morning. Alone.");
        TextUI.printSlow("The gem's power hums through you — sharpening every movement, every strike.");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.printSlow("The revenge faction finds you first, as you knew they would.");
        TextUI.printSlow("Blessed soldiers — dozens of them. Moving fast. Moving without fear.");
        TextUI.printSlow("Under any other circumstances, it would be over before it began.");
        TextUI.print("");
        TextUI.printSlow("But you have the pure gem. And you are Commander Aldric.");
        TextUI.printSlow("You cut through them like weather. Like something inevitable.");
        TextUI.pressEnter();

        TextUI.printSlow("Deeper into the eastern lands. More fighters. More of the blessed.");
        TextUI.printSlow("Each one falls.");
        TextUI.printSlow("Each one was someone, once. Before the ritual. Before the oath.");
        TextUI.printSlow("You do not let yourself think about that.");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.printSlow("At the end of it, you find the peace faction's village.");
        TextUI.printSlow("The elder is standing at the tree line. Waiting.");
        TextUI.printSlow("She looks at you without surprise. Without fear.");
        TextUI.print("");
        TextUI.printSlow("\"We heard them fall,\" she says. \"All of them.\"");
        TextUI.print("");
        TextUI.printSlow("\"We never wanted war,\" she says. \"We only wanted the truth to be known.\"");
        TextUI.printSlow("\"We only wanted what was taken from us to be acknowledged.\"");
        TextUI.printSlow("\"One thousand years. That is all we asked. A word. An admission.\"");
        TextUI.printSlow("\"That is all it would have taken.\"");
        TextUI.pressEnter();

        TextUI.printSlow("She looks at you for a long moment.");
        TextUI.print("");
        TextUI.printSlow("\"Are you going to finish it?\" she asks.");
        TextUI.pressEnter();

        TextUI.printSlow("You look at her. At the people behind her. Children. Elders. The last of them.");
        TextUI.print("");
        TextUI.printSlow("You lower your sword.");
        TextUI.print("");
        TextUI.printSlow("You ride back to Ashenfeld.");
        TextUI.pressEnter();

        TextUI.printSlow("You tell the King the revenge faction is gone.");
        TextUI.printSlow("You do not tell him about the elder.");
        TextUI.printSlow("You do not tell him about what she said.");
        TextUI.printSlow("You do not tell him that you could not finish it.");
        TextUI.print("");
        TextUI.printSlow("He clasps your shoulder. \"Ashenfeld is safe. Because of you.\"");
        TextUI.pressEnter();

        TextUI.printSlow("The lie endures.");
        TextUI.printSlow("So do you. With everything you know, and a choice you will carry the rest of your life.");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.printSlow("           ENDING: THE RECLAMATION");
        TextUI.printSlow("   The crown endures. The truth does not.");
        TextUI.printSlow("      But somewhere, the last of them still live.");
        TextUI.divider();
    }

    private void endingLiberation() {
        TextUI.divider();
        TextUI.printSlow("You face the King.");
        TextUI.print("");
        TextUI.printSlow("His hand moves to the crown. You watch him absorb the fragment.");
        TextUI.printSlow("The power floods into him — you can feel it from across the room.");
        TextUI.printSlow("Unstable. Wrong. He was never meant to carry this.");
        TextUI.printSlow("But it makes him dangerous. That much is clear.");
        TextUI.pressEnter();

        TextUI.printSlow("\"You would throw away a thousand years,\" he says. \"For what? For them?\"");
        TextUI.print("");
        TextUI.printSlow("\"For the truth,\" you say.");
        TextUI.pressEnter();

        // King Maren fight — retries until won
        boolean beatKing = false;
        while (!beatKing) {
            player.restoreHealth(player.getMaxHealth());
            Enemy king = EnemyFactory.createEnemy("KING_MAREN");
            beatKing = runCombat(king, true);
            if (!beatKing) {
                TextUI.printSlow("The King's power overwhelms you. But you rise.");
                TextUI.printSlow("The gem steadies you. You are not done.");
                TextUI.pressEnter();
            }
        }

        TextUI.divider();
        TextUI.printSlow("The King falls.");
        TextUI.printSlow("The crown rolls across the stone floor.");
        TextUI.printSlow("The fragment inside it goes dark.");
        TextUI.print("");
        TextUI.printSlow("It is over.");
        TextUI.pressEnter();

        TextUI.printSlow("You walk out of the chamber. Through the throne room, past the banners.");
        TextUI.printSlow("Past the stone tablet that bears the name of Queen Celia.");
        TextUI.printSlow("Into the square.");
        TextUI.pressEnter();

        TextUI.printSlow("It is morning. People are beginning their day.");
        TextUI.printSlow("They see you. They stop.");
        TextUI.pressEnter();

        TextUI.printSlow("You speak.");
        TextUI.printSlow("You tell them about the Everlast. About what Queen Celia did on the night of a celebration.");
        TextUI.printSlow("About the oath. The thousand years. The two factions. The gem.");
        TextUI.printSlow("About the King. About what he asked you to do.");
        TextUI.printSlow("About what you chose instead.");
        TextUI.pressEnter();

        TextUI.printSlow("It takes a long time.");
        TextUI.printSlow("When you are finished, the square is completely silent.");
        TextUI.print("");
        TextUI.printSlow("Then someone begins to weep.");
        TextUI.pressEnter();

        TextUI.printSlow("You ride east one more time.");
        TextUI.printSlow("The peace faction is waiting at the village edge. They knew you would come.");
        TextUI.print("");
        TextUI.printSlow("The elder looks at you.");
        TextUI.print("");
        TextUI.printSlow("\"It is done?\"");
        TextUI.printSlow("\"It is done,\" you say.");
        TextUI.print("");
        TextUI.printSlow("She nods slowly. \"Then it begins.\"");
        TextUI.pressEnter();

        TextUI.printSlow("What comes after is long and difficult.");
        TextUI.printSlow("There are those in Ashenfeld who do not want to believe it.");
        TextUI.printSlow("There are those who cannot forgive themselves for not knowing.");
        TextUI.printSlow("There are those who want to rebuild, and those who want revenge for the revenge.");
        TextUI.print("");
        TextUI.printSlow("But the truth is out.");
        TextUI.printSlow("And a truth spoken cannot be unspoken.");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.printSlow("            ENDING: THE LIBERATION");
        TextUI.printSlow("     The crown falls. The truth endures.");
        TextUI.divider();
    }
}
