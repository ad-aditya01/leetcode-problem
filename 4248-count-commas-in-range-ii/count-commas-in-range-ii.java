class Solution {
    public long countCommas(long n) {
        long total=0;

        for (long start=1000;start<=n;start *=1000){
            total +=n-start+1;
        }
        return total;
    }
}