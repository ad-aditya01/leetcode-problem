class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n=nums.length;
        // int mini=Integer.MAX_VALUE;
        // for(int i=0;i<n;i++){
        //     if(nums[i]<mini){
        //         mini=nums[i];
        //     }
        // }
        // int maxi=Integer.MIN_VALUE;
        // for(int i=0;i<n;i++){
        //     if(nums[i]>max){
        //         max=nums[i];
        //     }
        // }
        // for(int i=mini;i<maxi;i++){
        //     if()
        // }
        
        Arrays.sort(nums);
        ArrayList<Integer> list=new ArrayList();
        int a=nums[0];
        for(int i=0;i<n;i++){
            while(a!=nums[i]){
                list.add(a);
                a++;
            }
            if(nums[i]==a){
                a++;
            }
        }
        return list;
    }
}