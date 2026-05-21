public class Chapter3 extends Chapter {

    public Chapter3(Player player, EventBus eventBus, GameManager gameManager) {
        super(player, eventBus, gameManager);
    }

    @Override
    public String getTitle() { return "Chapter III — The Monastery"; }

    @Override
    public void play() {
        TextUI.printTitle(getTitle());

        TextUI.printSlow("The monastery sits east of the capital, half a day's ride through quiet roads.");
        TextUI.printSlow("You expected monks. Movement. The sounds of a working order.");
        TextUI.printSlow("What you find is silence.");
        TextUI.print("");
        TextUI.printSlow("The gates are open. Candles still burn inside. Food sits half-eaten on a long table.");
        TextUI.printSlow("No bodies. No sign of struggle. Everyone simply... left.");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.printSlow("Almost everyone.");
        TextUI.print("");
        TextUI.printSlow("You find him in the back room. An old man. Small, hunched, wrapped in a worn robe.");
        TextUI.printSlow("He does not look up when you enter.");
        TextUI.print("");
        TextUI.printSlow("\"Another one sent to laugh at the old man, I suppose,\" he says.");
        TextUI.pressEnter();

        TextUI.printSlow("This is Brother Theodore. The last of his order.");
        TextUI.printSlow("You can see in him the weight of a lifetime of knowing something no one believed.");
        TextUI.pressEnter();

        // Stage 1 — Noble
        TextUI.divider();
        TextUI.printSlow("Theodore looks at you finally. His eyes are sharp, whatever else has faded.");
        TextUI.print("");
        TextUI.printSlow("\"What brought you to my door, soldier? The truth this time.\"");
        TextUI.print("");

        boolean stage1 = false;
        while (!stage1) {
            TextUI.print("1. \"The King sent me. I follow orders.\"");
            TextUI.print("2. \"My men died in those streets. They deserve answers.\"");
            TextUI.print("3. \"Something about that attack was wrong. I can't let it go.\"");
            int choice = TextUI.getChoice(3);

            if (choice == 1) {
                TextUI.printSlow("Theodore exhales slowly. \"The answer of a sword, not a man.\"");
                TextUI.printSlow("\"Try again. Why are YOU here?\"");
                TextUI.print("");
            } else {
                stage1 = true;
                if (choice == 2) {
                    TextUI.printSlow("Theodore is quiet for a moment. \"Your men,\" he repeats slowly. \"Yes. That is closer to it.\"");
                } else {
                    TextUI.printSlow("Theodore tilts his head. \"Can't let it go. Interesting.\"");
                    TextUI.printSlow("\"Most men can. Most men choose to.\"");
                }
            }
        }
        TextUI.pressEnter();

        // Stage 2 — Determined
        TextUI.divider();
        TextUI.printSlow("\"And if what I tell you,\" Theodore says slowly, \"contradicts the King?\"");
        TextUI.print("");

        boolean stage2 = false;
        while (!stage2) {
            TextUI.print("1. \"The King sent me here. Whatever you know serves him.\"");
            TextUI.print("2. \"Then I'll deal with that when I get there.\"");
            TextUI.print("3. \"Then maybe it is what I need to hear instead of what he wants to hear.\"");
            int choice = TextUI.getChoice(3);

            if (choice == 1) {
                TextUI.printSlow("\"Still hiding behind the crown.\" Theodore shakes his head.");
                TextUI.printSlow("\"I am asking about YOU. Think harder.\"");
                TextUI.print("");
            } else {
                stage2 = true;
                if (choice == 2) {
                    TextUI.printSlow("Theodore nods slowly. \"Deal with it when you get there.\"");
                    TextUI.printSlow("\"A practical answer. But there is honesty in it.\"");
                } else {
                    TextUI.printSlow("Theodore almost smiles. \"What you need to hear. Now that is interesting.\"");
                }
            }
        }
        TextUI.pressEnter();

        // Stage 3 — The recognition
        TextUI.divider();
        TextUI.printSlow("Theodore is quiet for a long time. He looks at you as though measuring something.");
        TextUI.printSlow("Finally:");
        TextUI.print("");
        TextUI.printSlow("\"If the truth you find destroys everything you believe in — do you still want it?\"");
        TextUI.print("");

        boolean stage3 = false;
        while (!stage3) {
            TextUI.print("1. \"That depends on what the truth is.\"");
            TextUI.print("2. \"I don't know.\"");
            TextUI.print("3. \"Yes.\"");
            int choice = TextUI.getChoice(3);

            if (choice == 3) {
                stage3 = true;
                TextUI.printSlow("You answer without hesitation.");
                TextUI.print("");
                TextUI.printSlow("Theodore goes very still.");
                TextUI.print("");
                TextUI.printSlow("\"...so it is you,\" he says, almost to himself.");
                TextUI.printSlow("\"I wondered. For years I wondered. Now I am certain.\"");
                TextUI.print("");
                TextUI.printSlow("He does not explain what he means.");
            } else {
                TextUI.printSlow("Theodore watches you carefully.");
                TextUI.printSlow("\"I have waited a very long time for this answer. Think again.\"");
                TextUI.print("");
            }
        }
        TextUI.pressEnter();

        // Theodore reveals the truth
        TextUI.divider();
        TextUI.printSlow("What follows takes a long time. Theodore speaks, and you listen.");
        TextUI.printSlow("And the world you thought you knew begins to shift.");
        TextUI.pressEnter();

        TextUI.printSlow("He speaks of a people called the Everlast.");
        TextUI.printSlow("Peaceful. Ancient. They had a ritual — a blessing — given only to soldiers who chose it willingly.");
        TextUI.printSlow("It stripped away emotion. Left something faster, stronger, without fear.");
        TextUI.printSlow("In exchange for themselves, they became something nearly unstoppable.");
        TextUI.pressEnter();

        TextUI.printSlow("Queen Celia learned of it.");
        TextUI.printSlow("She did not negotiate. She did not ask.");
        TextUI.printSlow("She waited for a celebration — a ceremony of peace — and used the ritual against its creators.");
        TextUI.printSlow("She turned their own blessed soldiers against them in a single night.");
        TextUI.printSlow("And she destroyed them.");
        TextUI.printSlow("Or so she believed.");
        TextUI.pressEnter();

        TextUI.printSlow("\"The king's son survived,\" Theodore says. \"With a small group.\"");
        TextUI.printSlow("\"They swore an oath. One thousand years ago. And they have kept it.\"");
        TextUI.print("");
        TextUI.printSlow("\"What attacked your capital — that was not an invasion.\"");
        TextUI.printSlow("\"That was a debt. A debt Ashenfeld has owed for one thousand years.\"");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.printSlow("\"They are split,\" Theodore continues. \"Those who came for blood. And those who did not.\"");
        TextUI.printSlow("\"The ones who seek peace carry a prophecy. My order has carried the same one, from the other side.\"");
        TextUI.print("");
        TextUI.printSlow("\"Go east. Past the river. Find them.\"");
        TextUI.printSlow("\"They will not welcome you at first. But they will know you.\"");
        TextUI.pressEnter();

        TextUI.printSlow("You stand to leave.");
        TextUI.print("");
        TextUI.printSlow("At the door, Theodore speaks again.");
        TextUI.print("");
        TextUI.printSlow("\"The King told you to come to me. Did he also tell you what to do with me afterward?\"");
        TextUI.print("");
        TextUI.printSlow("You do not answer.");
        TextUI.printSlow("Theodore nods slowly. \"I thought so. Go, Aldric. And be careful who you trust.\"");
        TextUI.pressEnter();
    }
}
