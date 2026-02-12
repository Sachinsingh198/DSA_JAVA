package BitManipulation;

import java.util.HashMap;

public class SingleNumberGfG {
    int getSingle(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int el : nums){
            map.put(el, map.getOrDefault(el, 0) + 1);
        }
        for(int key : map.keySet()){
            if(map.get(key) %2 != 0){
                return key;
            }
        }
        return -1;
    }
}
