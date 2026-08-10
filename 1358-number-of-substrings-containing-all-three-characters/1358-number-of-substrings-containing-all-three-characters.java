class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int count=0;
        // for(int i=0;i<n;i++)
        // {
        //     int[] hash=new int[3];
        //     for(int j=i;j<n;j++)
        //     {
        //        char ch=s.charAt(j);
        //         hash[ch-'a']=1;
        //         if(hash[0]+hash[1]+hash[2]==3)
        //         {
        //             count=count+(n-j);
        //             break;
        //         }
        //     }
            
        // }
        int[] hash={-1,-1,-1};
        for(int i=0;i<n;i++)
        {
            
           
                char ch=s.charAt(i);
                hash[ch-'a']=i;
                if(hash[0]!=-1 && hash[1]!=-1 && hash[2]!=-1)
                {
                    count=count+(1+Math.min(hash[0],Math.min(hash[1],hash[2])));
                }
            
        }
        return count;
    }
}