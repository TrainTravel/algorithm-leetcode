package Olivia;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationHelper(result,candidates,target,new ArrayList<Integer>(),0);
        return result;
    }
    private void combinationHelper(List<List<Integer>> result,int[] candidates,int target,List<Integer>cur, int startLoc){
        if (target > 0) {
            //should begin with the startLoc to avoid duplication
            for(int i=startLoc;i<candidates.length;i++){
                cur.add(candidates[i]);
                combinationHelper(result,candidates,target-candidates[i],cur,i);
                //to go through all possibilities
                cur.remove(cur.size()-1);
            }
        }
        else if(target==0){
            //should add new arrarylist not cur
            result.add(new ArrayList<Integer>(cur));
        }

    }
}
