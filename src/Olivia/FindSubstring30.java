package Olivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s==null||words.length==0)
            return result;
        int len = words[0].length();
        //map for words
        Map<String,Integer> wordMap = new HashMap<>();
        for(int i=0; i<words.length;i++){
            if(wordMap.containsKey(words[i])){
                int val = wordMap.get(words[i]);
                wordMap.put(words[i],val+1);
            }
            else{
                wordMap.put(words[i],1);
            }
        }
        for(int j=0;j<s.length()-words.length*len+1;j++){
            //Map<String,Integer> copy = wordMap;
            Map<String, Integer> copy = new HashMap<String, Integer>(wordMap);
            for(int k = 0; k <words.length;j++){
                String cur = s.substring(j+k*len,j+k*len+len);
                if(copy.containsKey(cur)){
                    int count = copy.get(cur);
                    if (count==1) {copy.remove(cur);}
                    else {copy.put(cur,count-1);}
                    if(copy.isEmpty()){
                        result.add(j);
                        break;
                    }
                }
                else{
                    break;
                }
            }

        }
        return result;

    }
}
