class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int maxlen=0;
        int left=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int right=0;right<n;right++)
        {
            map.put(fruits[right],map.getOrDefault(fruits[right],0)+1);
            while(map.size()>2)
            {
                map.put(fruits[left],map.getOrDefault(fruits[left],0)-1);
                if(map.get(fruits[left])==0)
                {
                    map.remove(fruits[left]);
                    
                }
                left++;
            }
              int len=right-left+1;
                maxlen=Math.max(maxlen,len);
            
        
        }
        return maxlen;
    }
}