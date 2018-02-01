package com.general.lneartao.lib.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lneartao on 2017/11/13.
 * 要考虑重复性、空值性、边界性、时间和空间复杂度、非法字符串
 */

public class Strings {
    /**
     * 暴力移位法
     * https://leetcode.com/problems/reverse-string/
     *
     * @param s 字符串
     * @return 旋转后的字符串
     */
    public static String reverseString(String s) {
        if (isStringNull(s)) {
            return s;
        }
        char[] sChars = s.toCharArray();
        int length = s.length();
        char temp;
        for (int i = 0; i < length / 2; i++) {
            temp = sChars[length - 1 - i];
            sChars[length - 1 - i] = sChars[i];
            sChars[i] = temp;
        }
        return new String(sChars);
    }

    /**
     * 求字符串最后一个单词的长度
     * https://leetcode.com/problems/length-of-last-word/description/
     * 从后往前遍历，注意去除空格 时间复杂度为O(n)，空间复杂度为O(1)
     *
     * @param s 字符串
     * @return 最后一个单词的长度
     */
    public static int lengthOfLastWord(String s) {
        if (isStringNull(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int length = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (Character.isWhitespace(chars[i])) {
                if (length > 0) {
                    return length;
                }
            } else {
                length++;
            }
        }
        return length;
    }

    /**
     * Given two binary strings, return their sum
     * https://leetcode.com/problems/add-binary/description/
     * 从后往前遍历，粗暴的算法 时间复杂度为O(n)，空间复杂度为O(1)
     *
     * @param a 字符串a
     * @param b 字符串b
     * @return sum
     */
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int addFlag = 0;
        int maxLength = Math.max(a.length(), b.length());
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int result;
        for (int i = 0; i < maxLength; i++) {
            result = 0;
            if (i < a.length()) {
                result += Character.getNumericValue(aChars[a.length() - 1 - i]);
            }
            if (i < b.length()) {
                result += Character.getNumericValue(bChars[b.length() - 1 - i]);
            }
            result += addFlag;
            switch (result) {
                case 0:
                    addFlag = 0;
                    sb.insert(0, "0");
                    break;
                case 1:
                    addFlag = 0;
                    sb.insert(0, "1");
                    break;
                case 2:
                    addFlag = 1;
                    sb.insert(0, "0");
                    break;
                case 3:
                    addFlag = 1;
                    sb.insert(0, "1");
                    break;
                default:
            }
        }
        if (addFlag == 1) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }

    /**
     * 旋转字符串 暴力移位法 时间复杂度为O(m * n)，空间复杂度为O(1)
     *
     * @param s 字符串
     * @param m 移动的距离
     * @return 移动后的字符串
     */
    public static String leftRotateStringV2(String s, int m) {
        if (isStringNull(s)) {
            return s;
        }
        char[] sChars = s.toCharArray();
        while (m-- > 0) {
            leftShiftOne(sChars, sChars.length);
        }
        return new String(sChars);
    }

    /**
     * 移动一个字符到字符串尾部
     *
     * @param s       字符数组
     * @param sLength 字符数组长度
     */
    private static void leftShiftOne(char[] s, int sLength) {
        char t = s[0];
        for (int i = 1; i < sLength; i++) {
            s[i - 1] = s[i];
        }
        s[sLength - 1] = t;
    }

    /**
     * 三步反转法。也叫翻手原则
     * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部 ，没有处理负数情况
     *
     * @param s 字符串
     * @param m 移动的距离
     * @return 移动后的字符串
     */
    public static String leftRotateString(String s, int m) {
        if (isStringNull(s)) {
            return s;
        }
        char[] sChars = s.toCharArray();
        int length = s.length();
        m %= length;
        // 翻左手
        reverseString(sChars, 0, m - 1);
        // 翻右手
        reverseString(sChars, m, length - 1);
        // 两只手一起翻
        reverseString(sChars, 0, length - 1);
        return new String(sChars);
    }

    //

    /**
     * 三步反转法，也叫翻手原则
     * 给定一个字符串，要求把字符串尾部的若干个字符移动到字符串的头部 ，没有处理负数情况
     *
     * @param s 字符串
     * @param m 移动的距离
     * @return 移动后的字符串
     */
    public static String rightRotateString(String s, int m) {
        if (isStringNull(s)) {
            return s;
        }
        char[] sChars = s.toCharArray();
        int length = s.length();
        m = length - (m % length);
        reverseString(sChars, 0, m - 1);
        reverseString(sChars, m, length - 1);
        reverseString(sChars, 0, length - 1);
        return new String(sChars);
    }

    private static void reverseString(char[] s, int from, int to) {
        char temp;
        while (from < to) {
            temp = s[from];
            s[from++] = s[to];
            s[to--] = temp;
        }
    }

    /**
     * 单词翻转。输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变，句子中单词以空格符隔开。
     * 为简单起见，标点符号和普通字母一样处理。
     * https://leetcode.com/problems/reverse-words-in-a-string/description/
     *
     * @param s 字符串
     * @return 翻转后的字符串
     */
    public static String reverseWord(String s) {
        if (isStringNull(s)) {
            return "";
        }
        String[] strings = s.split("\\s+");
        int from = 0;
        int to = strings.length - 1;
        String temp;
        while (from < to) {
            temp = strings[from];
            strings[from++] = strings[to];
            strings[to--] = temp;
        }
        StringBuilder sb = new StringBuilder();
        to = strings.length - 1;
        for (int i = 0; i <= to; i++) {
            sb.append(strings[i]);
            if (i != to) {
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    /**
     * 翻转句子中单词的顺序
     *
     * @param s 字符串
     * @return 翻转后的字符串
     */
    public static String reverseWordsInSentence(String s) {
        if (isStringNull(s)) {
            return "";
        }
        String[] strings = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars;
        for (String string : strings) {
            chars = string.toCharArray();
            reverseString(chars, 0, string.length() - 1);
            stringBuilder.append(chars);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().trim();
    }

    /**
     * 字符串包含，暴力匹配法
     *
     * @param a 长字符串a
     * @param b 短字符串b
     * @return a是否包含b
     */
    public static boolean StringContainV1(String a, String b) {
        if (isStringNull(a) || isStringNull(b)) {
            return false;
        }
        for (int i = 0; i < b.length(); i++) {
            int j;
            for (j = 0; j < a.length() && b.charAt(i) != a.charAt(j); j++) {
                ;
            }
            if (j >= a.length()) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串包含，先排序处理，再暴力匹配
     *
     * @param a 长字符串a
     * @param b 短字符串b
     * @return a是否包含b
     */
    public static boolean StringContainV2(String a, String b) {
        if (isStringNull(a) || isStringNull(b)) {
            return false;
        }
//        sort(a);
//        sort(b);
        for (int ai = 0, bi = 0; bi < b.length(); ) {
            while (ai < a.length() && a.charAt(ai) < b.charAt(bi)) {
                ++ai;
            }
            if (ai > a.length() || a.charAt(ai) > b.charAt(bi)) {
                return false;
            }
            ++bi;
        }
        return true;
    }

    /**
     * 利用字母和素数对应的关系，只有理论意义，因为整数乘积很大，有溢出风险
     *
     * @param a 长字符串a
     * @param b 短字符串b
     * @return a是否包含b
     */
    public static boolean StringContainV3(String a, String b) {
        if (isStringNull(a) || isStringNull(b)) {
            return false;
        }
        int[] p = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        int f = 1;
        int x;
        for (int i = 0; i < a.length(); i++) {
            x = p[a.charAt(i) - 'A'];
            if (f % x > 0) {
                f *= x;
            }
        }
        for (int i = 0; i < b.length(); ++i) {
            x = p[b.charAt(i) - 'A'];
            if (f % x > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串包含，使用hashmap标记的方法
     *
     * @param a 长字符串a
     * @param b 短字符串b
     * @return a是否包含b
     */
    public static boolean StringContainV4(String a, String b) {
        if (isStringNull(a) || isStringNull(b)) {
            return false;
        }
        HashMap<Character, Boolean> hashMap = new HashMap<>();
        int length = a.length();
        for (int i = 0; i < length; i++) {
            hashMap.put(a.charAt(i), true);
        }
        length = b.length();
        for (int i = 0; i < length; i++) {
            if (!hashMap.containsKey(b.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串包含，对字符串a，用位运算（26bit整数表示，因为有26个英文字母)计算出一个“签名”，再用b中的字符到a里面进行查找。
     *
     * @param a 长字符串a
     * @param b 短字符串b
     * @return a是否包含b
     */
    public static boolean StringContain(String a, String b) {
        if (isStringNull(a) || isStringNull(b)) {
            return false;
        }
        int hash = 0;
        int length = a.length();
        for (int i = 0; i < length; i++) {
            hash |= (1 << (a.charAt(i) - 'A'));
        }
        length = b.length();
        for (int i = 0; i < length; i++) {
            if ((hash & (1 << b.charAt(i) - 'A')) == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * https://leetcode.com/problems/group-anagrams/
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> ans = new HashMap<>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList<>());
            ans.get(key).add(s);
        }
        return new ArrayList<>(ans.values());
    }

    /**
     * 字符串回文，从两边到中间
     * https://leetcode.com/problems/valid-palindrome/description/
     *
     * @param s 字符串
     * @return 是否回文
     */
    public static boolean isPalindrome(String s) {
        if (isStringNull(s)) {
            return true;
        }
        int from = 0;
        int to = s.length() - 1;
        s = s.toLowerCase();
        while (from < to) {
            while (!Character.isLetterOrDigit(s.charAt(from)) && from < to) {
                from++;
            }
            while (!Character.isLetterOrDigit(s.charAt(to)) && from < to) {
                to--;
            }
            if (s.charAt(from++) != s.charAt(to--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 字符串回文，从中间到两边
     * https://leetcode.com/problems/valid-palindrome/description/
     *
     * @param s 字符串
     * @return 是否回文
     */
    public static boolean isPalindromeV2(String s) {
        if (isStringNull(s)) {
            return true;
        }
        int length = s.length();
        if (1 == length) {
            return true;
        }
        int leftFlag = length / 2 - 1;
        int rightFlag;
        if (0 == length % 2) {
            rightFlag = leftFlag + 1;
        } else {
            rightFlag = leftFlag + 2;
        }
        for (; leftFlag >= 0; leftFlag--, rightFlag++) {
            if (s.charAt(leftFlag) != s.charAt(rightFlag)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 数值字符串转换成整型，库函数atoi
     * https://leetcode.com/problems/string-to-integer-atoi/description/
     *
     * @param str 数值字符串
     * @return 整型数值
     */
    public static int strToInt(String str) {
        if (isStringNull(str)) {
            return 0;
        }
        int i = 0;
        while (str.charAt(i) == ' ') {
            i++;
        }
        int flag = 1;
        if (str.charAt(i) == '-') {
            flag *= -1;
            i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        int result = 0;
        int length = str.length();
        int currentValue;
        for (; i < length; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return flag > 0 ? result : -result;
            }
            currentValue = str.charAt(i) - '0';

            /*
            处理溢出
            若n > MAX_INT / 10，那么说明最后一步转换时，n*10必定大于MAX_INT，所以在得知n > MAX_INT / 10时，当即返回MAX_INT。
            若n == MAX_INT / 10时，那么比较最后一个数字c跟MAX_INT % 10的大小，即如果n == MAX_INT / 10且c > MAX_INT % 10，则照样返回MAX_INT。
            */
            if (result > Integer.MAX_VALUE / 10) {
                if (flag > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            // 关键是跟最后的数字7比较
            if (result == Integer.MAX_VALUE / 10 && currentValue > Integer.MAX_VALUE % 10) {
                if (flag > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            result = result * 10 + currentValue;
        }
        return flag > 0 ? result : -result;
    }

    /**
     * 最长回文子串 n平方的时间复杂度 原理是查找每一个字符的最长回文子串，接着返回当中最长的
     * https://leetcode.com/articles/longest-palindromic-substring/
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindromeV2(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            // 奇数的情况
            int len1 = expandAroundCenter(s, i, i);
            // 偶数的情况
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * TODO 没怎么看懂
     * 最长回文子串，O(N)的时间复杂度
     * https://articles.leetcode.com/longest-palindromic-substring-part-ii/
     *
     * @param s 字符串
     * @return 最长回文子串
     */
    public static String longestPalindrome(String s) {
        String T = preProcess(s);
        int n = T.length();
        int[] P = new int[n];
        int id = 0, mx = 0;
        for (int i = 1; i < n - 1; i++) {
            int iMirror = 2 * id - i;
            P[i] = (mx > i) ? Math.min(mx - i, P[iMirror]) : 0;
            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            if (i + P[i] > mx) {
                id = i;
                mx = i + P[i];
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        int left = (centerIndex - 1 - maxLen) / 2;
        int right = left + maxLen;
        return s.substring(left, right);
    }

    /**
     * For example, S = "abba", T = "^#a#b#b#a#$".
     *
     * @param s
     * @return T
     */
    private static String preProcess(String s) {
        int n = s.length();
        if (n == 0) {
            return "^$";
        }
        StringBuilder ret = new StringBuilder("^");
        for (int i = 0; i < n; i++) {
            ret.append("#");
            ret.append(s.substring(i, i + 1));
        }
        ret.append("#$");
        return ret.toString();
    }

    /**
     * 打印当前字符串的字典序排列 O(n!)的时间复杂度
     *
     * @param s
     */
    public static void printAllPermutation(String s) {
        char[] perm = s.toCharArray();
        System.out.println(s);
        while (calAllPermutation(perm, perm.length)) {
            System.out.println(perm);
        }
    }

    private static boolean calAllPermutation(char[] perm, int num) {
        int i;
        // 找到排列中最后一个升序的首位位置i，x=perm[i]
        for (i = num - 2; (i >= 0) && (perm[i] >= perm[i + 1]); --i) {
            ;
        }
        // 已经找到所有排列
        if (i < 0) {
            return false;
        }
        int k;
        // 找到排列中第i位右边最后一个比x大的位置k，y=perm[k]
        for (k = num - 1; (k > i) && (perm[k] <= perm[i]); --k) {
            ;
        }
        // 交换x,y
        swap(perm, i, k);
        // 把第(i+1)位到最后的部分翻转
        reverseString(perm, i + 1, num - 1);
        return true;
    }

    private static void swap(char[] perm, int a, int b) {
        char temp = perm[a];
        perm[a] = perm[b];
        perm[b] = temp;
    }

    // null "" "   "  这这几种都算空字符串
    public static boolean isStringNull(String a) {
        return a == null || a.trim().length() <= 0;
    }

    // TODO
    public static void calAllPermutation(String s) {
        char[] chars = s.toCharArray();
    }


}
