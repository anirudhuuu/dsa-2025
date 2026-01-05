package tries;

import java.util.Scanner;

/*
 * Word Matcher
 * ====================
 * Given a paragraph, pre-process it into a Trie.
 *
 * Then given word as an input, return true or false if it's in the paragraph
 *
 * N = total chars in the paragraph
 * M = length of the search word
 *
 * Time Complexity
 * - Pre-processing: O(N)
 * - Building Trie: O(N)
 * - Searching a word: O(M)
 *
 * Overall: O(N + M)
 *
 * Space Complexity
 * - Trie storage: O(N)
 * - Extra space during search: O(1)
 *
 * Overall Space: O(N)
 */
public class WordMatcher04 {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWordEnd = false;

        boolean containsKey(char ch) {
            return this.children[ch - 'a'] != null;
        }

        void put(char ch, TrieNode node) {
            this.children[ch - 'a'] = node;
        }

        TrieNode get(char ch) {
            return this.children[ch - 'a'];
        }

        void setIsWordEnd() {
            this.isWordEnd = true;
        }

        boolean isWordEnd() {
            return this.isWordEnd;
        }
    }

    static class WordMatcher {
        private TrieNode root;

        public WordMatcher() {
            this.root = new TrieNode();
        }

        void insert(String word) {
            TrieNode temp = root;

            for (char ch : word.toCharArray()) {
                if (!temp.containsKey(ch)) {
                    temp.put(ch, new TrieNode());
                }

                temp = temp.get(ch);
            }

            temp.setIsWordEnd();
        }

        boolean search(String word) {
            TrieNode temp = root;

            for (char ch : word.toCharArray()) {
                if (!temp.containsKey(ch)) {
                    return false;
                }

                temp = temp.get(ch);
            }

            return temp.isWordEnd();
        }

        /**
         * convert to lowercase
         * replace non-alphabetic chars with space
         * replace long spaces with a single space
         * trim spaces
         */
        String preProcess(String input) {
            input = input.toLowerCase();

            input = input.replaceAll("[^a-z ]", " ");

            input = input.replaceAll("\\s+", " ");

            input = input.trim();

            return input;
        }
    }

    static void main() {
        String inputParagraph = """
                      Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.
                """;

        WordMatcher wordMatcher = new WordMatcher();
        String processedInput = wordMatcher.preProcess(inputParagraph);
        String[] processedWords = processedInput.split(" ");

        for (String word : processedWords) {
            wordMatcher.insert(word);
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the word you are looking for :: ");
        String searchInput = sc.nextLine();

        System.out.println("Given word as input is present? :: " + wordMatcher.search(searchInput));
    }
}
