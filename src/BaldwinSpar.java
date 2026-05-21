import java.util.Random;

public class BaldwinSpar extends Enemy {

    private static final String[] ATTACK_MESSAGES = {
        "Baldwin grins and taps your shoulder. \"Too slow, Aldric.\"",
        "He slips past your guard with ease. \"Still dropping your left, I see.\"",
        "\"Come on then.\" He nudges you back, laughing.",
        "Baldwin ducks your swing and flicks your arm. \"Predictable as always.\""
    };

    private static final Random random = new Random();

    public BaldwinSpar() {
        super("Baldwin", 30, 5,
            "Your oldest friend. He is grinning. This is not a real fight — " +
            "and you both know it.");
    }

    @Override
    public String getAttackMessage() {
        return ATTACK_MESSAGES[random.nextInt(ATTACK_MESSAGES.length)];
    }
}
