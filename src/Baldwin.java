import java.util.Random;

public class Baldwin extends Enemy {

    private static final String[] ATTACK_MESSAGES = {
        "Baldwin sidesteps your strike before it lands. He already knew it was coming.",
        "He reads your footwork and counters before you commit. You trained together too long.",
        "\"I know that move, Aldric.\" He blocks it effortlessly and drives back hard.",
        "You feint left. He doesn't follow. He knew. His blade catches you on the right.",
        "He anticipated your angle before you chose it. The hit lands clean.",
        "Baldwin doesn't fight with anger. He fights with twenty years of knowing you."
    };

    private static final Random random = new Random();

    public Baldwin() {
        super("Baldwin", 150, 18,
            "Your closest friend. The finest soldier you have ever known beside yourself. " +
            "He is not fighting you out of hatred. He believes in the King. " +
            "That makes him more dangerous than anything else you have faced.");
    }

    @Override
    public String getAttackMessage() {
        return ATTACK_MESSAGES[random.nextInt(ATTACK_MESSAGES.length)];
    }
}
