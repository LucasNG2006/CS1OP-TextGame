import java.util.Random;

public class BlessedSoldier extends Enemy {

    private static final String[] ATTACK_MESSAGES = {
        "The soldier strikes with inhuman speed — no hesitation, no expression.",
        "The blessed soldier lunges forward, eyes empty, blade precise.",
        "It moves faster than anything you have faced before. The blow lands before you can react.",
        "There is no anger in its eyes. No fear. It simply attacks."
    };

    private static final Random random = new Random();

    public BlessedSoldier() {
        super("Blessed Soldier", 50, 12,
            "A soldier of the Everlast revenge faction. Eyes vacant. Personality gone. " +
            "What remains is something built purely to fight.");
    }

    @Override
    public String getAttackMessage() {
        return ATTACK_MESSAGES[random.nextInt(ATTACK_MESSAGES.length)];
    }
}
