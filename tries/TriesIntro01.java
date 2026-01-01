package tries;

/*
 * Tries
 * =========
 * A Trie is a specialized tree-like data structure that organizes and stores words
 * in an efficient manner. Each node in a Trie represents a single character of a word,
 * allowing for efficient addition, retrieval, and deletion of words.
 *
 * In simpler terms, a Trie is an advanced information retrieval data structure.
 * It outperforms more conventional data structures like Hashmaps and Trees in terms
 * of the time complexity for various operations, making it particularly useful for
 * tasks involving large sets of strings or words.
 *
 * The Trie data structure is designed to store and quickly retrieve a collection of strings.
 *
 * It arranges strings so that shared prefixes are stored once, which makes it very
 * efficient for operations like searching for words with a specific prefix. This ability
 * to quickly find all strings that start with a given prefix makes Tries particularly
 * useful for applications like autocomplete and predictive text.
 *
 * Trie Node Structure
 * ---------------------
 * A Trie node is a fundamental element used to build a Trie.
 * Each node consists of the following parts:
 *
 * Child Node Links: A Trie node has an array of pointers,
 * often referred to as "links" or "children pointers," for
 * every letter of the lowercase alphabet. These pointers create
 * connections to child nodes that represent each letter of the alphabet.
 *
 * For example, the link at index 0 corresponds to the child node for
 * the letter 'a', the link at index 1 corresponds to 'b', and so on.
 *
 * End-of-Word Flag: Each Trie node includes a boolean flag that signifies
 * whether the node marks the end of a word. This flag is crucial for
 * differentiating between prefixes and full words stored in the Trie.
 */
class TriesIntro01 {
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
}
