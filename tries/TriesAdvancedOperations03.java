package tries;

/*
 * Trie Implementation and Advanced Operations
 * ===============================================
 * Implement "TRIE" data structure from scratch with the following functions.
 *
 * - Trie(): Initialize the object of this “TRIE” data structure.
 *
 * - insert(“WORD”): Insert the string “WORD” into this “TRIE” data structure.
 *
 * - countWordsEqualTo(“WORD”): Return how many times this “WORD” is present in this “TRIE”.
 *
 * - countWordsStartingWith(“PREFIX”): Return how many words are
 * there in this “TRIE” that have the string “PREFIX” as a prefix.
 *
 * - erase(“WORD”): Delete one occurrence of the string “WORD” from the “TRIE”.
 */
public class TriesAdvancedOperations03 {
    class TrieNode {
        private TrieNode[] links;
        private int countEndWith;
        private int countPrefix;

        public TrieNode() {
            this.links = new TrieNode[26];
            this.countEndWith = 0;
            this.countPrefix = 0;
        }

        boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        TrieNode getKey(char ch) {
            return this.links[ch - 'a'];
        }

        void putKey(char ch, TrieNode node) {
            this.links[ch - 'a'] = node;
        }

        void increaseEnd() {
            this.countEndWith += 1;
        }

        void increasePrefix() {
            this.countPrefix += 1;
        }

        void deleteEnd() {
            this.countEndWith -= 1;
        }

        void reducePrefix() {
            this.countPrefix -= 1;
        }

        int getEnd() {
            return this.countEndWith;
        }

        int getPrefix() {
            return this.countPrefix;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                if (!node.containsKey(word.charAt(i))) {
                    node.putKey(word.charAt(i), new TrieNode());
                }

                node = node.getKey(word.charAt(i));
                node.increasePrefix();
            }

            node.increaseEnd();
        }

        int countWordsEqualTo(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.getKey(word.charAt(i));
                } else {
                    return 0;
                }
            }

            return node.getEnd();
        }

        int countWordsStartingWith(String prefix) {
            TrieNode node = root;

            for (int i = 0; i < prefix.length(); i++) {
                if (node.containsKey(prefix.charAt(i))) {
                    node = node.getKey(prefix.charAt(i));
                } else {
                    return 0;
                }
            }

            return node.getPrefix();
        }

        void erase(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                if (node.containsKey(word.charAt(i))) {
                    node = node.getKey(word.charAt(i));
                    node.reducePrefix();
                } else {
                    return;
                }
            }

            node.deleteEnd();
        }
    }
}
