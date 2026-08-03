class Solution {
    Integer dp[];
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        dp=new Integer[n];
        int diff=solve(0,stoneValue);
        if(diff>0)
        {
            return "Alice";
        }
        else if(diff<0)
        {
            return "Bob";
        }
        else
        {
            return "Tie";
        }
    }
    private int solve(int i, int[] stoneValue)
    {
        if(i==stoneValue.length)
        {
            return 0;
        }
        if(dp[i]!=null)
        {
            return dp[i];
        }
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int k=0;k<3 && k+i < stoneValue.length ;k++)
        {
            sum+=stoneValue[k+i];
           max = Math.max(max,sum-solve(i+k+1,stoneValue));
        }
        return dp[i]=max;
    }
}