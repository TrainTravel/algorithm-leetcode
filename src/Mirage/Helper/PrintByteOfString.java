package Mirage.Helper;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 4/8/18
 * Time: 21:51
 */

public class PrintByteOfString {
    private byte[] str;
    public PrintByteOfString(String s){
        str = s.getBytes();

    }

    public void printByteArray(){
        System.out.println(Arrays.toString(str));
    }
}
