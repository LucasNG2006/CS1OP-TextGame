import org.junit.Test;
import static org.junit.Assert.*;

public class GameManagerTest {

    @Test
    public void testGetInstanceNotNull() {
        assertNotNull(GameManager.getInstance());
    }

    @Test
    public void testSingletonReturnsSameInstance() {
        GameManager a = GameManager.getInstance();
        GameManager b = GameManager.getInstance();
        assertSame(a, b);
    }

    @Test
    public void testGameRunningByDefault() {
        assertTrue(GameManager.getInstance().isGameRunning());
    }

    @Test
    public void testSetGameRunning() {
        GameManager gm = GameManager.getInstance();
        gm.setGameRunning(false);
        assertFalse(gm.isGameRunning());
        gm.setGameRunning(true); // restore so other tests are unaffected
    }

    @Test
    public void testSetAndGetEndingChoice() {
        GameManager gm = GameManager.getInstance();
        gm.setEndingChoice(2);
        assertEquals(2, gm.getEndingChoice());
    }

    @Test
    public void testAdvanceChapterIncrementsCount() {
        GameManager gm = GameManager.getInstance();
        int before = gm.getCurrentChapter();
        gm.advanceChapter();
        assertEquals(before + 1, gm.getCurrentChapter());
    }
}
