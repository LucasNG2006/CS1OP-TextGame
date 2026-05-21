import org.junit.Test;
import static org.junit.Assert.*;

public class EnemyFactoryTest {

    @Test
    public void testCreateBlessedSoldier() {
        Enemy e = EnemyFactory.createEnemy("BLESSED_SOLDIER");
        assertTrue(e instanceof BlessedSoldier);
    }

    @Test
    public void testCreateBlessedGuardian() {
        Enemy e = EnemyFactory.createEnemy("BLESSED_GUARDIAN");
        assertTrue(e instanceof BlessedGuardian);
    }

    @Test
    public void testCreateBaldwinSpar() {
        Enemy e = EnemyFactory.createEnemy("BALDWIN_SPAR");
        assertTrue(e instanceof BaldwinSpar);
    }

    @Test
    public void testCreateBaldwin() {
        Enemy e = EnemyFactory.createEnemy("BALDWIN");
        assertTrue(e instanceof Baldwin);
    }

    @Test
    public void testCreateKingMaren() {
        Enemy e = EnemyFactory.createEnemy("KING_MAREN");
        assertTrue(e instanceof KingMaren);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnknownTypeThrowsException() {
        EnemyFactory.createEnemy("UNKNOWN_ENEMY");
    }

    @Test
    public void testEnemyStartsAlive() {
        Enemy e = EnemyFactory.createEnemy("BLESSED_SOLDIER");
        assertTrue(e.isAlive());
    }

    @Test
    public void testEnemyHasPositiveAttackDamage() {
        Enemy e = EnemyFactory.createEnemy("BLESSED_SOLDIER");
        assertTrue(e.getAttackDamage() > 0);
    }
}
