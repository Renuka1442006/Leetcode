class Solution {
    List<String> res=new ArrayList<>();
        HashMap<Character,String> map=new HashMap<>();
        
    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits==null || digits.length()==0)
        {
            return res;
        }
        
        backtrack(0,digits,res,new StringBuilder());
        return res;
    }
    public void backtrack(int i, String digits ,List<String> res,StringBuilder str)
    {
        if(i==digits.length())
        {
            res.add(str.toString());
            return;
        }
        String letter=map.get(digits.charAt(i));
        for(int k=0;k<letter.length();k++)
        {
            str.append(letter.charAt(k));
            backtrack(i+1,digits,res,str);
            str.deleteCharAt(str.length()-1);
        }

    }
}