import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=345 lang=java
 *
 * [345] Reverse Vowels of a String
 */

// @lc code=start
class Solution {

    List<Character> vowelsList = new ArrayList<>();

    public String reverseVowels(String s) {
        if (s.length() <= 1)
            return s;
        populateVowelsList();
        return reverseVowels(s.toCharArray(), 0, s.length() - 1);
    }

    private String reverseVowels(char[] cArr, int i, int j) {
        if (i >= j)
            return String.valueOf(cArr);
        if (!vowelsList.contains(cArr[i]) && !vowelsList.contains(cArr[j]))
            return reverseVowels(cArr, ++i, --j);
        else if (!vowelsList.contains(cArr[i]) && vowelsList.contains(cArr[j]))
            return reverseVowels(cArr, ++i, j);
        else if (vowelsList.contains(cArr[i]) && !vowelsList.contains(cArr[j]))
            return reverseVowels(cArr, i, --j);
        else {
            char temp = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = temp;
            return reverseVowels(cArr, ++i, --j);
        }
    }

    private void populateVowelsList() {
        this.vowelsList.add('a');
        this.vowelsList.add('e');
        this.vowelsList.add('i');
        this.vowelsList.add('o');
        this.vowelsList.add('u');
        this.vowelsList.add('A');
        this.vowelsList.add('E');
        this.vowelsList.add('I');
        this.vowelsList.add('O');
        this.vowelsList.add('U');
    }

}
// @lc code=end
