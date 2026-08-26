class Solution {
    public String shortestBeautifulSubstring(String s, int k) {

        HashMap<Character, Integer> map = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int i = 0;
        int count = 0;
        String ans = "";

        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (ch == '1') {
                count++;
            }
            while (count == k) {
                int len = j - i + 1;

                if (len < minLen) {
                    minLen = len;
                    ans = s.substring(i, j + 1);
                }
                else if (len == minLen) {
                    String current = s.substring(i, j + 1);

                    if (current.compareTo(ans) < 0) {
                        ans = current;
                    }
                }
                char remove = s.charAt(i);

                map.put(remove, map.get(remove) - 1);

                if (map.get(remove) == 0) {
                    map.remove(remove);
                }

                if (remove == '1') {
                    count--;
                }

                i++;
            }
        }

        return ans;
    }
}