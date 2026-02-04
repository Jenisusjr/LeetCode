class Solution {
    public static void recursiveUtil(String str,int op,int cp ,int n,List<String> result){
        if(op == n && cp == n){
            result.add(str);

        }
        if(op<n){
            recursiveUtil(str + "(",op+1,cp,n,result);
        }
        if(cp<op){
            recursiveUtil(str + ")",op,cp+1,n,result);
        }
    }
    public List<String> generateParenthesis(int n) {
        List <String> result = new ArrayList<> ();
         recursiveUtil("",0,0,n,result);
         return result;
    }
}