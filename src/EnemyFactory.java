public class EnemyFactory {

    public static Enemy createEnemy(String type) {
        switch (type) {
            case "BLESSED_SOLDIER":  return new BlessedSoldier();
            case "BLESSED_GUARDIAN": return new BlessedGuardian();
            case "BALDWIN_SPAR":     return new BaldwinSpar();
            case "BALDWIN":          return new Baldwin();
            case "KING_MAREN":       return new KingMaren();
            default:
                throw new IllegalArgumentException("Unknown enemy type: " + type);
        }
    }
}
