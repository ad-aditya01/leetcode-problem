class Solution {
    public int numberOfSubstrings(String s) {
     int[] freq=new int[3];
     int left=0,right=0;
     int count=0;
     for(right=0;right<s.length();right++){
        freq[s.charAt(right)-'a']++;
        while(freq[0]>0 && freq[1]>0 && freq[2]>0){
            count=count+s.length()-right;

            freq[s.charAt(left)-'a']--;
            left++;
        }
     }
     return count;
        
    }
}
//  HashMap<Character,Integer> map=new HashMap<>();
//         int n=s.length();
//         int l=0,r=0;
//         int count=0;

//         while(r<n){
//             char ch=s.charAt(r);
//             map.put(ch,map.getOrDefault(ch,0)+1);
//             while(map.size()==3){
//                 count+=(n-r);
//                 char lc=s.charAt(l);
//                 map.put(lc,map.get(lc)-1);
//                 if(map.get(lc)==0) {
//                     map.remove(lc);
//                 }
//                 l++;
//             }
//             r++;
//         }
//         return count;
//     }
// }