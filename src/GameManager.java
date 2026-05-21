public class GameManager {

    // The one and only instance of GameManager
    private static GameManager instance;

    private boolean gameRunning;
    private int currentChapter;
    private int endingChoice;   // 1 = The King's War, 2 = The Liberation

    // Private constructor — nothing outside this class can create a GameManager
    private GameManager() {
        gameRunning = true;
        currentChapter = 1;
        endingChoice = 0;
    }

    // The only way to get the GameManager — creates it the first time, returns it every time after
    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public boolean isGameRunning() { return gameRunning; }
    public void setGameRunning(boolean running) { gameRunning = running; }

    public int getCurrentChapter() { return currentChapter; }
    public void setCurrentChapter(int chapter) { currentChapter = chapter; }

    public int getEndingChoice() { return endingChoice; }
    public void setEndingChoice(int choice) { endingChoice = choice; }

    public void advanceChapter() { currentChapter++; }
}
