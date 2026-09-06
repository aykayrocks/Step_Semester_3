import java.util.Arrays;

public class Problem5_FantasyLeagueAutoDraftRankingEngine {

    // ---- Thresholds chosen for the draft rules ----
    private static final int EXPERIENCE_ONLY_MATCHES_THRESHOLD = 10; // established players
    private static final int COMBINED_MATCHES_THRESHOLD = 5;         // newer players' matches requirement

    static class Player implements Comparable<Player> {
        String name;
        int matchesPlayed;
        double battingAverage; // used here as the player's fantasy points value
        boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        // Sort draftable players by fantasy points (battingAverage), descending.
        @Override
        public int compareTo(Player other) {
            return Double.compare(other.battingAverage, this.battingAverage);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    // Rule 1: established players qualify on experience alone.
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= EXPERIENCE_ONLY_MATCHES_THRESHOLD;
    }

    // Rule 2: newer players must be reasonably experienced AND currently fit.
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= COMBINED_MATCHES_THRESHOLD && !injured;
    }

    static String draftAndRank(Player[] players) {
        // A player is draftable if EITHER rule clears them.
        int draftableCount = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableCount++;
            }
        }

        Player[] draftable = new Player[draftableCount];
        int index = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[index++] = p;
            }
        }

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].name);
            if (i < draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
        // Expected: 1. Rahul | 2. Virat | 3. Dev
    }
}
