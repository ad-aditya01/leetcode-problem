class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=nums1[0];
        boolean isOdd=false;

        for(int num:nums1) {
            min=Math.min(min,num);

            if(num% 2!=0) {
                isOdd= true;
            }
        }
        if(min %2!= 0){
            return true;
        }


        
        return !isOdd;
    }
}