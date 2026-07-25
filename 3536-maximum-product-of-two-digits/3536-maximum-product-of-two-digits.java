class Solution {
    public int maxProduct(int n) {
        /*
        //ArrayList<Integer> arr=new ArrayList<>();
        int max=0;
        while(n>0)
        {

            int rem=n%10;
            arr.add(rem);
            n/=10;
        }
        for(int i=0;i<arr.size()-1;i++)
        {
            int res=0;
            for(int j=i+1;j<arr.size();j++)
            {
                res=arr.get(i)*arr.get(j);
                max=Math.max(max,res);
            }
           
        }
        return max;
        */
        int largest=0;
        int secondlargest=0;
        while(n>0)
        {
            int rem=n%10;
            if(rem>=largest)
            {
                secondlargest=largest;
                largest=rem;
            }
            else if(rem>secondlargest && rem!=largest)
            {
                secondlargest=rem;
            }
            n/=10;
        }
        return largest*secondlargest;
    }
}