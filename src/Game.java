public class Game {

    private Player player;
    private EventBus eventBus;
    private GameManager gameManager;

    public Game() {
        eventBus = new EventBus();
        player = new Player("Aldric", eventBus);
        gameManager = GameManager.getInstance();

        eventBus.subscribe(eventType -> {
            if (eventType.equals("GEM_ABSORBED")) {
                TextUI.printSlow("[The gem pulses through you. Something has changed.]");
            }
        });
    }

    public void start() {
        TextUI.printTitle("BLESSINGS");
        TextUI.printSlow("A text adventure.");
        TextUI.pressEnter();

        Chapter[] chapters = {
            new Chapter1(player, eventBus, gameManager),
            new Chapter2(player, eventBus, gameManager),
            new Chapter3(player, eventBus, gameManager),
            new Chapter4(player, eventBus, gameManager),
            new ChapterFinal(player, eventBus, gameManager)
        };

        for (Chapter chapter : chapters) {
            if (!gameManager.isGameRunning()) break;
            player.restoreHealth(player.getMaxHealth());
            chapter.play();
            gameManager.advanceChapter();
        }

        TextUI.pressEnter();
        TextUI.printSlow("Thank you for playing.");
    }
}
