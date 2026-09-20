// class Solution {
//     public int reverseDegree(String s) {

//         int result=0;
//         for(int i=0;i<s.length();i++){
//             int ans=26-(s.charAt(i)-'a');

//             result=result+ans*(i+1);
//         }
//         return result;

        
//     }
// }

class Solution {
    public int reverseDegree(String s) {
        int result = 0;
        int index = 1;
        for (char c : s.toCharArray()) {
            result += ('z' - c + 1) * index++;
        }
        return result;
    }
}