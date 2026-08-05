class Solution {
    public int minimumCardPickup(int[] cards) {
        // HashSet<Integer> set=new HashSet<>();
        // int n=cards.length;
        // int count=0;
        // for(int i=0;i<n;i++)
        // {
        //     if(set.contains(cards[i]))
        //     {
        //         return count+1;
        //     }
        //     set.add(cards[i]);
        //     count++;
        // }
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=cards.length;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(cards[i]))
            {
                ans=Math.min(ans,i-map.get(cards[i])+1);
            }
            map.put(cards[i],i);
        }

        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }
}