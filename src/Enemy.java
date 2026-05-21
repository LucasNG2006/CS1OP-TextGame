public abstract class Enemy {

    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attackDamage;
    protected String description;

    public Enemy(String name, int health, int attackDamage, String description) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attackDamage = attackDamage;
        this.description = description;
    }

    public abstract String getAttackMessage();

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttackDamage() { return attackDamage; }
    public String getDescription() { return description; }
}
