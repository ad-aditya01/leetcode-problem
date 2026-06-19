class Solution {
    public boolean checkGoodInteger(int n) {
        int digitSum=0;
        int squareSum=0;
        while(n>0){
            int digit=n%10;
            digitSum=digitSum+digit;
            squareSum=squareSum+digit*digit;
            n=n/10;
        }
        if(squareSum-digitSum<50){
            return false;
        }
        return true;
        
    }
}