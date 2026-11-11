class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
       long min=Math.min(need1,need2);
        long max=Math.max(need1,need2);
        long rem=max-min;
        long ans=0;
        ans+=Math.min(costBoth*min,cost1*min+cost2*min);
        ans+=rem*((need1>need2)?cost1:cost2);
        ans=Math.min(ans,max*costBoth);
        return ans;
    }
}