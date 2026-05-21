public class Chapter1 extends Chapter {

    public Chapter1(Player player, EventBus eventBus, GameManager gameManager) {
        super(player, eventBus, gameManager);
    }

    @Override
    public String getTitle() { return "Chapter I — 1000 Years"; }

    @Override
    public void play() {
        TextUI.printTitle(getTitle());

        // Aldric wakes
        TextUI.printSlow("The room is quiet.");
        TextUI.printSlow("It is always quiet. No family to stir. No one waiting.");
        TextUI.printSlow("Just the grey light of morning through a narrow window, and the sounds of the capital waking outside.");
        TextUI.printSlow("You are Commander Aldric. The King's Guard. The finest soldier Ashenfeld has ever produced.");
        TextUI.printSlow("Today marks one thousand years since the kingdom was born.");
        TextUI.pressEnter();

        // Breakfast choice — tutorial mechanic
        TextUI.divider();
        TextUI.printSlow("You rise and move to the small table by the fire.");
        TextUI.print("What will you eat this morning?");
        TextUI.print("1. Bread");
        TextUI.print("2. Salted Pork");
        TextUI.print("3. Nothing — you have eaten before harder days than this");
        int breakfast = TextUI.getChoice(3);

        if (breakfast == 1) {
            TextUI.printSlow("You tear off a piece of bread. Simple. Sufficient. You have never needed much.");
        } else if (breakfast == 2) {
            TextUI.printSlow("The salted pork is tough but good. A soldier's meal. You eat without ceremony.");
        } else {
            TextUI.printSlow("You leave the food untouched. You have gone without before. Today does not call for ceremony.");
        }
        TextUI.pressEnter();

        // Baldwin spar
        TextUI.divider();
        TextUI.printSlow("The training ground is already busy when you arrive.");
        TextUI.printSlow("Most soldiers give you a wide berth — respectful, careful.");
        TextUI.printSlow("Not Baldwin.");
        TextUI.print("");
        TextUI.printSlow("He is leaning against the post, arms folded, grinning the moment he sees you.");
        TextUI.print("");
        TextUI.printSlow("\"You look like you slept on the floor again,\" he says.");
        TextUI.print("");
        TextUI.print("How do you respond?");
        TextUI.print("1. \"I always sleep well. Unlike some people who talk too much.\"");
        TextUI.print("2. \"Some of us train before sunrise. You should try it.\"");
        int banter = TextUI.getChoice(2);

        if (banter == 1) {
            TextUI.printSlow("Baldwin laughs. \"Fair enough. Come on — let's see if you're as sharp as you claim.\"");
        } else {
            TextUI.printSlow("Baldwin raises an eyebrow. \"I was here an hour before you. But sure, keep telling yourself that.\"");
            TextUI.printSlow("He picks up a training blade and grins.");
        }
        TextUI.pressEnter();

        TextUI.printSlow("He knows all your moves. Twenty years of training together.");
        TextUI.printSlow("This won't be easy — even in a spar.");
        TextUI.print("");
        TextUI.printSlow("(Tutorial fight — you cannot die here)");
        TextUI.pressEnter();

        Enemy spar = EnemyFactory.createEnemy("BALDWIN_SPAR");
        runCombat(spar, false);

        TextUI.print("");
        TextUI.printSlow("Baldwin catches his breath, grinning.");
        TextUI.printSlow("\"Still the best there is,\" he says, clapping you on the shoulder. \"Come on — the ceremony will have started.\"");
        TextUI.pressEnter();

        // The ceremony
        TextUI.divider();
        TextUI.printSlow("The square is full.");
        TextUI.printSlow("Every person in the capital has come to mark the day. Banners hang from every building.");
        TextUI.printSlow("Children sit on their fathers' shoulders. Music drifts from the far end of the square.");
        TextUI.printSlow("You take your post at the front. People notice you. They always do.");
        TextUI.printSlow("A few nod. Some whisper to each other. You are part of what makes them feel safe.");
        TextUI.pressEnter();

        TextUI.printSlow("Then King Maren steps forward, and the square falls silent.");
        TextUI.print("");
        TextUI.printSlow("He is not a large man. He never needed to be.");
        TextUI.printSlow("When he speaks, people listen. When he smiles, they believe.");
        TextUI.printSlow("You have known him for fifteen years. You have never doubted him once.");
        TextUI.pressEnter();

        TextUI.divider();
        TextUI.printSlow("\"One thousand years ago,\" he begins, \"this kingdom did not exist.\"");
        TextUI.printSlow("\"We were scattered — different peoples, different lands, different conflicts.\"");
        TextUI.printSlow("\"And then came Queen Celia.\"");
        TextUI.print("");
        TextUI.printSlow("\"She could have conquered. She had the power to.\"");
        TextUI.printSlow("\"Instead — she chose peace. She chose unity.\"");
        TextUI.printSlow("\"She believed that what divided us was less than what bound us.\"");
        TextUI.print("");
        TextUI.printSlow("\"One thousand years of that belief. One thousand years of this kingdom.\"");
        TextUI.printSlow("\"Of your families. Your children. Lives lived without fear.\"");
        TextUI.print("");
        TextUI.printSlow("\"That is her gift to you. That is what we honour tonight.\"");
        TextUI.printSlow("\"Ashenfeld endures. And it will endure for a thousand years more.\"");
        TextUI.pressEnter();

        TextUI.printSlow("The crowd erupts.");
        TextUI.printSlow("You stand at your post, proud, as the celebration fills the square around you.");
        TextUI.printSlow("The world feels unshakeable tonight.");
        TextUI.pressEnter();

        // Night
        TextUI.divider();
        TextUI.printSlow("Later, the city is still celebrating when you return to your quarters.");
        TextUI.printSlow("You remove your armour. Sit on the edge of the bed.");
        TextUI.printSlow("Through the window, the distant sound of music.");
        TextUI.print("");
        TextUI.printSlow("You close your eyes.");
        TextUI.printSlow("You sleep.");
        TextUI.pressEnter();
    }
}
