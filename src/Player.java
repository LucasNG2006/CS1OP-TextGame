public class Player {

    private String name;
    private int health;
    private int maxHealth;
    private int attackDamage;
    private boolean hasGem;
    private EventBus eventBus;

    public Player(String name, EventBus eventBus) {
        this.name = name;
        this.health = 100;
        this.maxHealth = 100;
        this.attackDamage = 20;
        this.hasGem = false;
        this.eventBus = eventBus;
    }

    // Absorbing the pure gem permanently boosts attack damage
    public void absorbGem() {
        if (!hasGem) {
            hasGem = true;
            attackDamage += 15;
            eventBus.publish("GEM_ABSORBED");
        }
    }

    // Taking damage notifies all listeners — if health hits zero, publishes PLAYER_DIED
    public void takeDamage(int damage) {
        health -= damage;
        if (health <= 0) {
            health = 0;
            eventBus.publish("PLAYER_DIED");
        } else {
            eventBus.publish("PLAYER_HEALTH_CHANGED");
        }
    }

    // Restores health between chapters — cannot exceed max health
    public void restoreHealth(int amount) {
        health = Math.min(health + amount, maxHealth);
    }

    public boolean isAlive() { return health > 0; }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttackDamage() { return attackDamage; }
    public boolean hasGem() { return hasGem; }
}
