package com.general.lneartao.lib.test;

import com.general.lneartao.lib.Logger;

import static com.general.lneartao.lib.algorithm.Strings.StringContain;
import static com.general.lneartao.lib.algorithm.Strings.addBinary;
import static com.general.lneartao.lib.algorithm.Strings.isPalindrome;
import static com.general.lneartao.lib.algorithm.Strings.leftRotateString;
import static com.general.lneartao.lib.algorithm.Strings.lengthOfLastWord;
import static com.general.lneartao.lib.algorithm.Strings.longestPalindrome;
import static com.general.lneartao.lib.algorithm.Strings.printAllPermutation;
import static com.general.lneartao.lib.algorithm.Strings.reverseString;
import static com.general.lneartao.lib.algorithm.Strings.reverseWord;
import static com.general.lneartao.lib.algorithm.Strings.reverseWordsInSentence;
import static com.general.lneartao.lib.algorithm.Strings.rightRotateString;
import static com.general.lneartao.lib.algorithm.Strings.strToInt;

/**
 * Created by lneartao on 2017/11/15.
 */

public class TestStrings {
    public static void main(String[] args) {
//        testLengthOfLastWord();
//        testAddBinary();
//        testLeftRotateString();
//        testReverseString();
//        testRightRotateString();
//        testReverseWord();
//        testStringContain();
//        testIsPalindrome();
//        testStrToInt();
//        testReverseWords();
//        testLongestPalindrome();
        testAllPermutatuin();
    }

    private static void testLeftRotateString() {
        Logger.printl(leftRotateString("abcdef", 2));
        Logger.printl(leftRotateString("", 54));
//        Logger.printl(leftRotateString("fds", -1));
        Logger.printl(leftRotateString("fds", 0));
        Logger.printl(leftRotateString("fds", 23));
    }

    private static void testReverseString() {
        Logger.printl(reverseString("123"));
        Logger.printl(reverseString(""));
        Logger.printl(reverseString(null));
        Logger.printl(reverseString("123ds"));
    }

    private static void testLengthOfLastWord() {
        Logger.printl(lengthOfLastWord("Hello world"));
        Logger.printl(lengthOfLastWord(""));
        Logger.printl(lengthOfLastWord("  "));
        Logger.printl(lengthOfLastWord(" world "));
        Logger.printl(lengthOfLastWord("world"));
    }

    private static void testAddBinary() {
        Logger.printl(addBinary("", ""));
        Logger.printl(addBinary("1", ""));
        Logger.printl(addBinary("", "0"));
        Logger.printl(addBinary("10", "1"));
        Logger.printl(addBinary("11", "1"));
        Logger.printl(addBinary("11111", "11"));
    }

    private static void testRightRotateString() {
        Logger.printl(rightRotateString("abcdef", 2));
        Logger.printl(rightRotateString("", 54));
        Logger.printl(rightRotateString("Ilovebaofeng", 7));
//        Logger.printl(leftRotateString("fds", -1));
        Logger.printl(rightRotateString("fds", 0));
        Logger.printl(rightRotateString("fds", 23));
    }

    private static void testReverseWord() {
        Logger.printl(reverseWord("I am a student."));
        Logger.printl(reverseWord(""));
        Logger.printl(reverseWord(" fdsfs"));
        Logger.printl(reverseWord("  "));
        Logger.printl(reverseWord("I am "));
        Logger.printl(reverseWord("am"));
        Logger.printl(reverseWord("        am    b   "));
        Logger.printl(reverseWord("the sky is blue"));
    }

    private static void testStringContain() {
        Logger.printl(StringContain("ABCD", "AB"));
        Logger.printl(StringContain("ABCD", "ABD"));
        Logger.printl(StringContain("ABCD", "AA"));
        Logger.printl(StringContain("ABCD", "AAF"));
        Logger.printl(StringContain("ABCD", ""));
//        Logger.printl(StringContain("ABCD", null));
        Logger.printl(StringContain("ABCD", "  "));
        Logger.printl(StringContain("A", "AAF"));
        Logger.printl(StringContain("B", "AAF"));
        Logger.printl(StringContain("C", "AAF"));
        Logger.printl(StringContain("D", "AAF"));
        Logger.printl(StringContain("Y", "AAF"));
    }

    private static void testIsPalindrome() {
        Logger.printl(isPalindrome(""));
        Logger.printl(isPalindrome(null));
        Logger.printl(isPalindrome(" "));
        Logger.printl(isPalindrome("  "));
        Logger.printl(isPalindrome("A man, a plan, a canal: Panama"));
        Logger.printl(isPalindrome("race a car"));
        Logger.printl(isPalindrome("12a21"));
        Logger.printl(isPalindrome("1b3b1"));
        Logger.printl(isPalindrome("123bb1"));
    }

    private static void testStrToInt() {
        Logger.printl(strToInt(""));
        Logger.printl(strToInt("  "));
        Logger.printl(strToInt(null));
        Logger.printl(strToInt("+"));
        Logger.printl(strToInt("  -0012a42"));
        Logger.printl(strToInt("   432"));
        Logger.printl(strToInt("1"));
        Logger.printl(strToInt("0"));
        Logger.printl(strToInt("-1"));
        Logger.printl(strToInt("3"));
        Logger.printl(strToInt("-3"));
        Logger.printl(strToInt("12321"));
        Logger.printl(strToInt("3232"));
        Logger.printl(strToInt("-321"));
//        Logger.printl(strToInt("-3F1"));
        Logger.printl(strToInt("2147483647"));   //0
        Logger.printl(strToInt("2147483648"));   //1
        Logger.printl(strToInt("2147483658"));   //1

        Logger.printl(strToInt("-2147483647"));  // 0
        Logger.printl(strToInt("-2147483648"));  // 0
        Logger.printl(strToInt("-2147483649"));  // 1
        Logger.printl(strToInt("-2147483659"));  // 1
        Logger.printl(strToInt("-21474836481")); // 1
    }

    private static void testReverseWords(){
        Logger.printl(reverseWordsInSentence("Let's take LeetCode contest"));
    }

    private static void testLongestPalindrome(){
        Logger.printl(longestPalindrome("a"));
    }

    private static void testAllPermutatuin(){
//        printAllPermutation("abc");
        printAllPermutation("12345");
    }
}
