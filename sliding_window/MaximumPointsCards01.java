package sliding_window;

/**
 * Maximum Points You Can Obtain from Cards
 * ==========================================
 * Given N cards arranged in a row, each card has an associated score denoted by
 * the cardScore array. Choose exactly k cards. In each step, a card can be
 * chosen either from the beginning or the end of the row. The score is the sum
 * of the scores of the chosen cards.
 * 
 * Return the maximum score that can be obtained.
 */
public class MaximumPointsCards01 {
    public static int maxScore(int[] cardScore, int k) {
        int l = 0;
        int r = k - 1;
        int n = cardScore.length - 1;

        int maxScore = 0;

        while (r <= n) {
            int sum = 0;
            for (int i = l; i <= r; i++) {
                sum = sum + cardScore[i];
            }
            maxScore = Math.max(maxScore, sum);

            l += 1;
            r += 1;
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] cardScore = { 5, 4, 1, 8, 7, 1, 3 };
        int k = 3;

        System.out.println(maxScore(cardScore, k));
    }
}
