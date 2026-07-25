class Solution {
    public int maxProduct(int n) {
        // ArrayList<Integer> list=new ArrayList<>();
        int temp=n;
        int count=0;
        while(temp!=0){
            int digit=temp%10;
            count++;
            temp/=10;
        }

        int[] arr=new int[count];
        int value=count;
        int m=n;
        while(m!=0){
            int last=m%10;
            arr[value-1]=last;
            value--;
            m/=10;
        }
        Arrays.sort(arr);
        return arr[count-1]*arr[count-2];
        
    }
}