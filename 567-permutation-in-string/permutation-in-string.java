class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] freq = new int[26];

        for (char c : s1.toCharArray()) freq[c - 'a']++;

        int left = 0, count = s1.length();

        for (int right = 0; right < s2.length(); right++) {
            if (freq[s2.charAt(right) - 'a']-- > 0) count--;

            if (right - left + 1 > s1.length()) {
                if (freq[s2.charAt(left++) - 'a']++ >= 0) count++;
            }
            if (count == 0) return true;
        }
        return false;
    }
}
