class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd=0;
        int sumEven=0;

        int i=0;
        while(n>0){
            sumOdd=sumOdd+i+1;
            sumEven+=i;
           i=i+2;

            n--;
        }
        return sumOdd-sumEven;
        
    }
}