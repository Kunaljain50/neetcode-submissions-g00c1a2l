class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int h = 0;
        int maxFreq = 0;
        int maxLen = 0;

        int[] hash = new int[26];

        while(h<n) {
            Character c = s.charAt(h);

            hash[c - 'A']++;

            maxFreq = Math.max(maxFreq, hash[c-'A']);

            while((h-l+1) - maxFreq > k) {
                Character it = s.charAt(l);
                hash[it - 'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, (h-l+1));
            h++;
        }

        return maxLen;
    }
}
