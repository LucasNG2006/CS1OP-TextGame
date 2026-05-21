import java.util.Random;

public class KingMaren extends Enemy {

    private static final String[] ATTACK_MESSAGES = {
        "The power surges through him unpredictably — the blow comes from an angle you didn't expect.",
        "He is not a warrior. But the crown fragment doesn't care. It drives him forward.",
        "The fragment is unstable in him — he loses control for a moment, and it is enough.",
        "\"I built this kingdom,\" he spits. The power behind the strike is real.",
        "He swings wild, but the fragment amplifies it. Wild can still hurt."
    };

    private static final Random random = new Random();

    public KingMaren() {
        super("King Maren", 120, 22,
            "The man you have served for fifteen years. The man you trusted like a father. " +
            "The crown fragment floods through him — unstable, dangerous. " +
            "He was never meant to carry this. But it carries him now.");
    }

    @Override
    public String getAttackMessage() {
        return ATTACK_MESSAGES[random.nextInt(ATTACK_MESSAGES.length)];
    }
}
