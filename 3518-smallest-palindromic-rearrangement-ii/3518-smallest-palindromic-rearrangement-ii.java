class Solution {
    
    static final long LIMIT=1_000_001L;

    public String smallestPalindrome(String s, int k) {
        
        int[] freq=new int[26];
        for(char ch: s.toCharArray())
        {
            freq[ch-'a']++;
        }
        String mid="";
        int[] half=new int[26];

        for(int i=0;i<26;i++)
        {
            if((freq[i]&1)==1)
            {
                mid=String.valueOf((char)('a'+i));
            }
            half[i]=freq[i]/2;

        }
        int len=s.length()/2;
        StringBuilder left=new StringBuilder();

        for(int pos=0; pos<len;pos++)
        {
            boolean found=false;
            for(int c=0;c<26;c++)
            {
                if(half[c]==0)
                {
                    continue;
                }
                half[c]--;
                long ways=countWays(half);

                if(ways>=k)
                {
                    left.append((char)('a'+c));
                    found=true;
                    break;

                }
                else
                {
                    k-=ways;
                    half[c]++;
                }
            }
            if(!found)
            {
                return "";
            }
        }
        StringBuilder ans=new StringBuilder(left);
        ans.append(mid);
        ans.append(new StringBuilder(left).reverse());
        return ans.toString();    

    }
    private long countWays(int[] cnt)
    {
        int total=0;
        for(int x: cnt)
        {
            total+=x;
        }
        long res=1;
        for(int c:cnt)
        {
            if(c==0)
            {
                continue;
            }
            res*=combLimited(total,c);
            if(res> LIMIT)
            {
                return LIMIT;
            }
            total-=c;
        }
        return Math.min(res,LIMIT);
    }
    private long combLimited(int n,int r)
    {
        if(r>n)
        {
            return 0;
        }
        r=Math.min(r,n-r);

        long ans=1;

        for(int i=1;i<=r;i++)
        {
            ans=ans*(n-r+i)/i;
            if(ans>LIMIT)
            {
                return LIMIT;
            }
        }
        return ans;
    }
}