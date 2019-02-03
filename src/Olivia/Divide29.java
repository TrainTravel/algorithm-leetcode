package Olivia;


//not complete
public class Divide29 {
    public int divide(int dividend, int divisor) {
        int result = Integer.MAX_VALUE-1;
        Boolean positive = true;
        //special case
        if (divisor==1){
            return dividend;
        }
        if(dividend==0){
            return dividend;
        }
        //overflow case
        if(dividend==Integer.MAX_VALUE && divisor==-1){
            return result;
        }
        //general case
        if((dividend>0&&divisor<0)||(dividend<0&&divisor>0)){
        positive = false;
        }
        int did = Math.abs(dividend);
        int div = Math.abs(divisor);
        if(did<div)
            return 0;
        int tmp = 1;
        result = 0;
        int i = 1;
        while(did>=tmp){
            did -= tmp;
            result += i;
            tmp <<= 1;
            i <<=1;
        }
        if(!positive){
            result = -result;
        }
        return result;
    }
}
