package recursion;

/**
 * Find the K-th Character in String Game I
 * ==========================================
 * Alice and Bob are playing a game. Initially, Alice has a string word = "a".
 * 
 * You are given a positive integer k.
 * 
 * Now Bob will ask Alice to perform the following operation forever:
 * - Generate a new string by changing each character in word to its next
 * character in the English alphabet, and append it to the original word.
 * 
 * For example, performing the operation on "c" generates "cd" and
 * performing the operation on "zb" generates "zbac".
 * 
 * Return the value of the kth character in word, after enough
 * operations have been done for word to have at least k characters.
 * 
 * Note that the character 'z' can be changed to 'a' in the operation.
 * 
 * 
 * Time Complexity: O(k) — the loop doubles the string length in powers of two
 * summing to ≈k.
 * Space Complexity: O(k) — you store and build a string of size proportional to
 * k.
 */
class KthCharacter {
    String word = "a";

    void getWord(int k) {
        if (word.length() >= k) {
            return;
        }

        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            temp.append((char) (word.charAt(i) + 1));
        }

        word = word + temp.toString();

        getWord(k);
    }

    char kthCharacter(int k) {
        getWord(k);
        return word.charAt(k - 1);
    }
}
