package com.general.lneartao.lib.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Created by lneartao on 2017/11/25.
 */

public class WordLadder {
    private static boolean oneCharOff(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int diffs = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (++diffs > 1) {
                    return false;
                }
            }
        }
        return diffs == 1;
    }

    public static Map<String, List<String>> computeAdjacentWordsSlow(List<String> theWords) {
        Map<String, List<String>> adjWords = new HashMap<>();
        String[] words = new String[theWords.size()];
        theWords.toArray(words);
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (oneCharOff(words[i], words[j])) {
                    update(adjWords, words[i], words[j]);
                    update(adjWords, words[j], words[i]);
                }
            }
        }
        return adjWords;
    }

    public static Map<String, List<String>> computeAdjacentWordsMedium(List<String> theWords) {
        Map<String, List<String>> adjWords = new HashMap<>();
        Map<Integer, List<String>> wordsByLength = new HashMap<>();
        for (String word : theWords) {
            update(wordsByLength, word.length(), word);
        }
        for (List<String> groupsWords : wordsByLength.values()) {
            String[] words = new String[groupsWords.size()];
            groupsWords.toArray(words);
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (oneCharOff(words[i], words[j])) {
                        update(adjWords, words[i], words[j]);
                        update(adjWords, words[j], words[i]);
                    }
                }
            }
        }
        return adjWords;
    }

    public static Map<String, List<String>> computeAdjacentWords(List<String> theWords) {
        Map<String, List<String>> adjWords = new HashMap<>();
        Map<Integer, List<String>> wordsByLength = new HashMap<>();
        for (String word : theWords) {
            update(wordsByLength, word.length(), word);
        }
        for (Map.Entry<Integer, List<String>> entry : wordsByLength.entrySet()) {
            int num = entry.getKey();
            List<String> groupsWords = entry.getValue();
            for (int i = 0; i < num; i++) {
                Map<String, List<String>> repWords = new HashMap<>();
                for (String word : groupsWords) {
                    String s = word.substring(0, i) + word.substring(i);
                    update(repWords, s, word);
                }
                for (List<String> words : repWords.values()) {
                    if (words.size() > 1) {
                        for (String word1 : words) {
                            for (String word2 : words) {
                                // 这里必须是指同一对象
                                if (word1 != word2) {
                                    update(adjWords, word1, word2);
                                }
                            }
                        }
                    }
                }
            }
        }
        return adjWords;
    }

    public static <KeyType> void update(Map<KeyType, List<String>> m, KeyType key, String value) {
        List<String> lst = m.get(key);
        if (lst == null) {
            lst = new ArrayList<>();
            m.put(key, lst);
        }
        lst.add(value);
    }


    // 使用图论最短路径的方法求解
    public static List<String> findChain(Map<String, List<String>> adjacentWords, String first, String second) {
        Map<String, String> previousWord = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(first);
        while (!q.isEmpty()) {
            String current = q.element();
            q.remove();
            List<String> adj = adjacentWords.get(current);
            if (adj != null) {
                for (String adjWord : adj) {
                    if (previousWord.get(adjWord) == null) {
                        previousWord.put(adjWord, current);
                        q.add(adjWord);
                    }
                }
            }
        }
        previousWord.put(first, null);
        return getChainFromPreviousMap(previousWord, first, second);
    }

    public static List<String> findChain(List<String> words, String first, String second) {
        Map<String, List<String>> adjacentWords = computeAdjacentWords(words);
        return findChain(adjacentWords, first, second);
    }

    public static List<String> getChainFromPreviousMap(Map<String, String> previousWord, String first, String second) {
        LinkedList<String> result = null;
        if (previousWord.get(second) != null) {
            result = new LinkedList<>();
            for (String str = second; str != null; str = previousWord.get(str)) {
                result.addFirst(str);
            }
        }
        return result;
    }
}
