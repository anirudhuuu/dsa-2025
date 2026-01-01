package tries;

/*
 * Trie Implementation and Operations
 * =======================================
 * Implement the Trie class:
 *
 * Trie(): Initializes the trie object.
 *
 * void insert (String word): Inserts the string word into the trie.
 *
 * boolean search (String word): Returns true if the string word is
 * in the trie (i.e., was inserted before), and false otherwise.
 *
 * boolean startsWith (String prefix): Returns true if there is a
 * previously inserted string word that has the prefix 'prefix',
 * and false otherwise.
 */
public class TriesImplementation02 {
    class TrieNode {
        TrieNode[] links = new TrieNode[26];
        boolean flag = false;

        boolean containsKey(char ch) {
            return this.links[ch - 'a'] != null;
        }

        void put(char ch, TrieNode node) {
            this.links[ch - 'a'] = node;
        }

        TrieNode get(char ch) {
            return this.links[ch - 'a'];
        }

        void setEnd() {
            this.flag = true;
        }

        boolean isEnd() {
            return this.flag;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode temp = root;

            for (char ch : word.toCharArray()) {
                if (!temp.containsKey(ch)) {
                    temp.put(ch, new TrieNode());
                }
                temp = temp.get(ch);
            }

            temp.setEnd();
        }

        boolean search(String word) {
            TrieNode temp = root;

            for (char ch : word.toCharArray()) {
                if (!temp.containsKey(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }

            return temp.isEnd();
        }

        boolean startsWith(String prefix) {
            TrieNode temp = root;

            for (char ch : prefix.toCharArray()) {
                if (!temp.containsKey(ch)) {
                    return false;
                }
                temp = temp.get(ch);
            }

            return true;
        }
    }
}
