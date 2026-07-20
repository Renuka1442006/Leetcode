class Solution {
    public int countBit(int a)
    {
        int count=0;
        while(a>0)
        {
            count+=a&1;
            a=a>>1;
        }
        return count;
    }
    public List<String> readBinaryWatch(int turnedOn) {
        
        List<String> str=new ArrayList<>();
        for(int hour=0;hour<12;hour++)
        {
            for(int minute=0;minute<60;minute++)
            {
                if(countBit(hour)+countBit(minute)==turnedOn)
                {
                    str.add(hour+":"+String.format("%02d",minute));
                }
            }
        }
        return str;
    }
}