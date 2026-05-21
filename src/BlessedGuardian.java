import java.util.Random;

public class BlessedGuardian extends Enemy {

    private static final String[] ATTACK_MESSAGES = {
        "The guardian drives forward like a battering ram — pure force, unstoppable.",
        "It hits you before you finish raising your guard. The impact shakes your bones.",
        "There is no technique. Just power. It slams into you without slowing.",
        "The guardian does not dodge, does not hesitate. It simply overwhelms.",
        "You barely block it. The sheer weight of the blow sends you skidding back."
    };

    private static final Random random = new Random();

    public BlessedGuardian() {
        super("Blessed Guardian", 70, 22,
            "An Everlast peace faction guardian. Blessed to protect, not to conquer. " +
            "It does not pursue — but anything that threatens the village will not survive.");
    }

    @Override
    public String getAttackMessage() {
        return ATTACK_MESSAGES[random.nextInt(ATTACK_MESSAGES.length)];
    }
}
