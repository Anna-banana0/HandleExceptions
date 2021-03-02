package allXceptions;
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        
        List<Boolean> res = new ArrayList<>();
        
        for(int i = 0; i < l.length; i++){
            res.add(isArith(nums, l[i], r[i]));
        }
        
        return res;
    }
    
    private boolean isArith(int[] nums, int l, int r){
        
        int[] range = Arrays.copyOfRange(nums, l, r + 1);
        Arrays.sort(range);
        
        int dif = range[1] - range[0];
        
        for(int i = 2; i < range.length; i++){
            if(range[i] - range[i - 1] != dif) return false;
        }
        
        return true;
    }
}