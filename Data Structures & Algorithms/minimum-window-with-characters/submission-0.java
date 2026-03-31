class Solution {
    public String minWindow(String s, String t) {
        
        int[] hash = new int[256];
        for(int i = 0; i<t.length(); i++) {
            Character c = t.charAt(i);
            hash[c - 'A']++;
        }

        int l = 0;
        int h = 0;
        int n = s.length();

        int cnt = 0;
        int sIdx = -1;
        int minLen = Integer.MAX_VALUE;

        while (h<n) {
            Character c = s.charAt(h);
            
            if (hash[c - 'A'] > 0) {
                cnt++;
            }

            hash[c - 'A']--;

            while(cnt == t.length()) {

                if((h-l+1) < minLen) {
                    minLen = h-l+1;
                    sIdx = l;
                }
                Character ct = s.charAt(l);
                hash[ct - 'A']++;
                
                if (hash[ct - 'A'] > 0) {
                    cnt--;
                }
                l++;
            }

            h++;
        }

        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minLen);
    }
}
