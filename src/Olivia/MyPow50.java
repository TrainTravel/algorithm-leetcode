package Olivia;

public class MyPow50 {
    public double myPow(double x, int n) {
        //special case for n==0
        if (n==0)
            return 1;
        //if n<0
        if(n<0){
            x = 1/x;
            //the most important thing is to avoid the overflow
            if(n%2==0){
                return myPow(x*x,-(n/2));
            }
            else{
                return x*myPow(x*x,-(n/2));}
        }
        else{
            if(n%2==0){
                return myPow(x*x,n/2);
            }
            else{
                return x*myPow(x*x,n/2);}
        }
    }
    }
