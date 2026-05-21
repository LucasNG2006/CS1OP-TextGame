public class TestRunner {

    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("         RUNNING UNIT TESTS");
        System.out.println("========================================\n");

        // Player Tests
        System.out.println("--- PlayerTest ---");
        runTest("Initial health is 100", () -> {
            Player p = new Player("Aldric", new EventBus());
            assertEqual(100, p.getHealth());
        });
        runTest("Initial attack damage is 20", () -> {
            Player p = new Player("Aldric", new EventBus());
            assertEqual(20, p.getAttackDamage());
        });
        runTest("Take damage reduces health", () -> {
            Player p = new Player("Aldric", new EventBus());
            p.takeDamage(30);
            assertEqual(70, p.getHealth());
        });
        runTest("Health does not go below zero", () -> {
            Player p = new Player("Aldric", new EventBus());
            p.takeDamage(999);
            assertEqual(0, p.getHealth());
        });
        runTest("Player is alive when health above zero", () -> {
            Player p = new Player("Aldric", new EventBus());
            assertTrue(p.isAlive());
        });
        runTest("Player is dead when health is zero", () -> {
            Player p = new Player("Aldric", new EventBus());
            p.takeDamage(100);
            assertTrue(!p.isAlive());
        });
        runTest("Restore health increases health", () -> {
            Player p = new Player("Aldric", new EventBus());
            p.takeDamage(50);
            p.restoreHealth(20);
            assertEqual(70, p.getHealth());
        });
        runTest("Restore health does not exceed max", () -> {
            Player p = new Player("Aldric", new EventBus());
            p.restoreHealth(9999);
            assertEqual(p.getMaxHealth(), p.getHealth());
        });
        runTest("Absorb gem increases attack damage to 35", () -> {
            Player p = new Player("Aldric", new EventBus());
            p.absorbGem();
            assertEqual(35, p.getAttackDamage());
        });
        runTest("Absorb gem only works once", () -> {
            Player p = new Player("Aldric", new EventBus());
            p.absorbGem();
            p.absorbGem();
            assertEqual(35, p.getAttackDamage());
        });

        // EnemyFactory Tests
        System.out.println("\n--- EnemyFactoryTest ---");
        runTest("Creates BlessedSoldier", () -> {
            Enemy e = EnemyFactory.createEnemy("BLESSED_SOLDIER");
            assertTrue(e instanceof BlessedSoldier);
        });
        runTest("Creates BlessedGuardian", () -> {
            Enemy e = EnemyFactory.createEnemy("BLESSED_GUARDIAN");
            assertTrue(e instanceof BlessedGuardian);
        });
        runTest("Creates BaldwinSpar", () -> {
            Enemy e = EnemyFactory.createEnemy("BALDWIN_SPAR");
            assertTrue(e instanceof BaldwinSpar);
        });
        runTest("Creates Baldwin", () -> {
            Enemy e = EnemyFactory.createEnemy("BALDWIN");
            assertTrue(e instanceof Baldwin);
        });
        runTest("Creates KingMaren", () -> {
            Enemy e = EnemyFactory.createEnemy("KING_MAREN");
            assertTrue(e instanceof KingMaren);
        });
        runTest("Unknown type throws exception", () -> {
            try {
                EnemyFactory.createEnemy("UNKNOWN");
                throw new AssertionError("Expected exception not thrown");
            } catch (IllegalArgumentException e) {
                // expected
            }
        });
        runTest("Enemy starts alive", () -> {
            Enemy e = EnemyFactory.createEnemy("BLESSED_SOLDIER");
            assertTrue(e.isAlive());
        });
        runTest("Enemy has positive attack damage", () -> {
            Enemy e = EnemyFactory.createEnemy("BLESSED_SOLDIER");
            assertTrue(e.getAttackDamage() > 0);
        });

        // GameManager Tests
        System.out.println("\n--- GameManagerTest ---");
        runTest("getInstance returns non-null", () -> {
            assertTrue(GameManager.getInstance() != null);
        });
        runTest("getInstance returns same instance", () -> {
            GameManager a = GameManager.getInstance();
            GameManager b = GameManager.getInstance();
            assertTrue(a == b);
        });
        runTest("Game is running by default", () -> {
            assertTrue(GameManager.getInstance().isGameRunning());
        });
        runTest("setGameRunning works", () -> {
            GameManager.getInstance().setGameRunning(false);
            assertTrue(!GameManager.getInstance().isGameRunning());
            GameManager.getInstance().setGameRunning(true);
        });
        runTest("setEndingChoice and getEndingChoice work", () -> {
            GameManager.getInstance().setEndingChoice(2);
            assertEqual(2, GameManager.getInstance().getEndingChoice());
        });
        runTest("advanceChapter increments chapter count", () -> {
            int before = GameManager.getInstance().getCurrentChapter();
            GameManager.getInstance().advanceChapter();
            assertEqual(before + 1, GameManager.getInstance().getCurrentChapter());
        });

        // Summary
        System.out.println("\n========================================");
        System.out.println("  RESULTS: " + passed + " passed, " + failed + " failed");
        System.out.println("========================================");
    }

    static void runTest(String name, Runnable test) {
        try {
            test.run();
            System.out.println("  PASS: " + name);
            passed++;
        } catch (AssertionError e) {
            System.out.println("  FAIL: " + name + " — " + e.getMessage());
            failed++;
        }
    }

    static void assertEqual(int expected, int actual) {
        if (expected != actual)
            throw new AssertionError("Expected " + expected + " but got " + actual);
    }

    static void assertTrue(boolean condition) {
        if (!condition)
            throw new AssertionError("Expected true but got false");
    }
}
