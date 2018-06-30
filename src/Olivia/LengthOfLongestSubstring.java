package Olivia;

import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int curMax = 0;
        for(int i =0,j=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            curMax = Math.max(curMax,i-j+1);
        }
        return curMax;
    }
}