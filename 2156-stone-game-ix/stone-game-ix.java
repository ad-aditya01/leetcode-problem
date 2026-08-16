class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int s : stones) {
            cnt[s % 3]++;
        }
        
        if (cnt[0] % 2 == 0) {
            // Alice wins if both remainder-1 and remainder-2 stones exist
            return cnt[1] >= 1 && cnt[2] >= 1;
        } else {
            // Alice wins if the counts of remainder-1 and remainder-2 differ by more than 2
            return Math.abs(cnt[1] - cnt[2]) > 2;
        }
    }
}