class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        // int n=fruits.length;
        // if(n==1 && fruits[0]>baskets[0])
        // {
        //     return 1;
        // }
        // if(n==1 && fruits[0]<=baskets[0])
        // {
        //     return 0;
        // }
        
        // int count=0;
        // for(int i=0;i<n;i++)
        // {
        //     if(fruits[i]<=baskets[i])
        //     {
        //         continue;
        //     }
            
        //         int j=i;
        //         while(baskets[j]>fruits[i] && j<=n)
        //         {
        //             if(fruits[i]>baskets[j])
        //             {
        //                 int temp=baskets[i];
        //                 baskets[i]=baskets[j];
        //                  baskets[j]=temp;
                        
        //             }
        //             j++;
                    
        //         }
            

        // }
        // for(int i=0;i<n;i++)
        // {
        //     if(fruits[i]>baskets[i])
        //     {
        //         count++;
        //     }
        // }
        // return count-1;
        int n=fruits.length;
        boolean[] used=new boolean[n];
        for(int i=0;i<n;i++)
        {
           
                for(int j=0;j<n;j++)
                {
                    if(!used[j] && baskets[j]>=fruits[i])
                    {
                        used[j]=true;
                        break;
                    }
                }
            
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(used[i]==false)
            {
                count++;
            }
        }
        return count;
    }
}