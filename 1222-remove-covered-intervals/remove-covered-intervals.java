class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return b[1]-a[1];
            }
            return a[0]-b[0];
        });
        int maxEnd=Integer.MIN_VALUE;
        int remaining=0;

        for(int[] interval:intervals){
            int start=interval[0];
            int end=interval[1];

              if (end > maxEnd) {
        remaining++;
        maxEnd = end;
    }
        }
        return remaining;
    }
}