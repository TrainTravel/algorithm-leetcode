package src.Olivia;

import java.util.Stack;

public class IsValid20 {
    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        int i = 0;
        Stack<Character> result = new Stack<>();
        while(i<s.length()){
            char cur = s.charAt(i);
            if(cur=='('){
                result.push(')');
            }
            else if(cur=='{'){
                result.push('}');
            }
            else if(cur=='['){
                result.push(']');
            }
            else if(result.isEmpty()||result.pop()!=cur){
                return false;
            }
            i++;
        }
        if (!result.isEmpty()) return false;
        return true;

    }
}
