class Solution {
    public int reverseDegree(String s) {

        int result=0;
        for(int i=0;i<s.length();i++){
            int ans=26-(s.charAt(i)-'a');

            result=result+ans*(i+1);
        }
        return result;

        
    }
}