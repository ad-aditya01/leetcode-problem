class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] num=arr.clone();
        Arrays.sort(num);
        HashMap<Integer,Integer> map=new HashMap<>();
        int rank=1;
        for(int ans:num){
            if(!map.containsKey(ans)){

            map.put(ans,rank);
            rank++;
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=map.get(arr[i]);
        }
        return arr;
        
    }
}