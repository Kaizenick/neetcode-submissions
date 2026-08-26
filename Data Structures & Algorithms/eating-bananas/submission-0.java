
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static boolean check(int h, int[] piles, int bananas) {
        for (int pile : piles) {
            if (pile > bananas) {
                int remainder = pile % bananas;
                int q = (pile - remainder) / bananas;
                if (remainder != 0) {
                    q = q + 1;
                }
                h = h - q;
            }else{
                h--;
            }
            if(h<0){
                return false;
            }
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        Stack<Integer> stack = new Stack<>();

        int MaxBananas = 0;
        for (int i = 0; i < piles.length; i++) {
            MaxBananas = Math.max(MaxBananas, piles[i]);
        }

        System.out.println(" ");
        int i = 1;
        int j = MaxBananas;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            boolean result = check(h, piles, mid);
            if (result) {
                j = mid - 1;
                stack.add(mid);
            } else {
                i = mid + 1;
            }
        }
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
