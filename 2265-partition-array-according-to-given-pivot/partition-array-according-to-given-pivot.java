class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int lcount=0;
        int gcount=0;
        int pcount=0;
        for(int num:nums){
            if(num<pivot){
                lcount++;
            }else if(num>pivot){
                gcount++;
            }else{
                pcount++;
            }
        }
        int i=0;
        int j=lcount;
        int k=lcount+pcount;
        int[] res=new int[nums.length];
        for(int num:nums){
            if(num<pivot){
                res[i]=num;
                i++;
            }else if(num>pivot){
                 res[k]=num;
                 k++;
            }else{
              res[j]=num;
              j++;
            }
        }
        return res;

        
    }
}