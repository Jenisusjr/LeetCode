class Solution {
    public int calculate(String s) {
        Stack<Long>st=new Stack<>();
        long n=0;
        long ans=0;
        long sign=1;
         for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                n=n*10+(ch-'0');
            }
            else if(ch=='+'){
                ans+=sign*n;
                n=0;
                sign=1;
            }
            else if(ch=='-'){
                ans+=sign*n;
                n=0;
                sign=-1;
            }
            else if(ch=='('){
                st.push(ans);
                st.push(sign);
                n=0;
                ans=0;
                sign=1;
            }
            else if(ch==')'){
                ans+=sign*n;
                n=0;
                ans*=st.pop();
                ans+=st.pop();
            }
         }
         ans+=sign*n;
         return(int) ans;
    }
}