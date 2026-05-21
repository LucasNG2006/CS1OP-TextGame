public abstract class Chapter {

    protected Player player;
    protected EventBus eventBus;
    protected GameManager gameManager;

    public Chapter(Player player, EventBus eventBus, GameManager gameManager) {
        this.player = player;
        this.eventBus = eventBus;
        this.gameManager = gameManager;
    }

    // Every chapter must implement its own story
    public abstract void play();

    // Every chapter must provide its title
    public abstract String getTitle();

    // Shared combat loop used by any chapter that has a fight.
    // Returns true if the player won, false if they died.
    protected boolean runCombat(Enemy enemy, boolean canDie) {
        TextUI.divider();
        TextUI.printSlow("You face: " + enemy.getName());
        TextUI.printSlow(enemy.getDescription());
        TextUI.divider();

        while (enemy.isAlive() && player.isAlive()) {

            // Show current health
            TextUI.printStatus(player.getHealth(), player.getMaxHealth());
            TextUI.print("[" + enemy.getName() + " health: " + enemy.getHealth() + "/" + enemy.getMaxHealth() + "]");
            TextUI.print("");

            // Player chooses action
            TextUI.print("What do you do?");
            TextUI.print("1. Attack");
            TextUI.print("2. Recover (skip turn, restore 10 health)");
            int choice = TextUI.getChoice(2);

            if (choice == 1) {
                int damage = player.getAttackDamage();
                enemy.takeDamage(damage);
                TextUI.printSlow("You strike " + enemy.getName() + " for " + damage + " damage.");
            } else {
                player.restoreHealth(10);
                TextUI.printSlow("You steady yourself and recover. (+10 health)");
            }

            // Enemy attacks back if still alive
            if (enemy.isAlive()) {
                TextUI.printSlow(enemy.getAttackMessage());
                if (canDie) {
                    player.takeDamage(enemy.getAttackDamage());
                } else {
                    // Spar mode — player cannot die, health floored at 1
                    int newHealth = Math.max(1, player.getHealth() - enemy.getAttackDamage());
                    player.restoreHealth(newHealth - player.getHealth());
                }
                TextUI.print("");
            }
        }

        if (player.isAlive()) {
            TextUI.divider();
            TextUI.printSlow(enemy.getName() + " has been defeated.");
            return true;
        } else {
            TextUI.divider();
            TextUI.printSlow("You have fallen.");
            return false;
        }
    }
}
