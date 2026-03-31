class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        int l = 0;
        int h = 0;
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();

        while(h<n) {
            Character c = s.charAt(h);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(map.size() != (h-l+1)) {
                Character it = s.charAt(l);

                map.put(it, map.get(it) - 1);

                if (map.get(it) == 0) {
                    map.remove(it);
                }

                l++;
            }

            result = Math.max(result, (h-l+1));
            h++;
        }

        return result;

    }
}
