import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        player = new Player("Aldric", new EventBus());
    }

    @Test
    public void testInitialHealth() {
        assertEquals(100, player.getHealth());
    }

    @Test
    public void testInitialAttackDamage() {
        assertEquals(20, player.getAttackDamage());
    }

    @Test
    public void testTakeDamageReducesHealth() {
        player.takeDamage(30);
        assertEquals(70, player.getHealth());
    }

    @Test
    public void testHealthDoesNotGoBelowZero() {
        player.takeDamage(999);
        assertEquals(0, player.getHealth());
    }

    @Test
    public void testIsAliveWhenHealthAboveZero() {
        assertTrue(player.isAlive());
    }

    @Test
    public void testIsDeadWhenHealthIsZero() {
        player.takeDamage(100);
        assertFalse(player.isAlive());
    }

    @Test
    public void testRestoreHealthIncreasesHealth() {
        player.takeDamage(50);
        player.restoreHealth(20);
        assertEquals(70, player.getHealth());
    }

    @Test
    public void testRestoreHealthDoesNotExceedMax() {
        player.restoreHealth(9999);
        assertEquals(player.getMaxHealth(), player.getHealth());
    }

    @Test
    public void testAbsorbGemIncreasesAttackDamage() {
        player.absorbGem();
        assertEquals(35, player.getAttackDamage());
    }

    @Test
    public void testAbsorbGemOnlyWorksOnce() {
        player.absorbGem();
        player.absorbGem();
        assertEquals(35, player.getAttackDamage());
    }
}
