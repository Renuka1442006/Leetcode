class Solution {
    public int minBitFlips(int start, int goal) {
        int nn=start^goal;
        int count=0;

        while(nn>0)
        {
            count+=nn&1;
            nn=nn>>1;
        }
        return count;
    }
}