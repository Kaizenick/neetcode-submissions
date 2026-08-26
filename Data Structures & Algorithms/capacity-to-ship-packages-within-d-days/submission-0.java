

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static boolean check(int[] weights, int days, int limit) {
        int index = 0;
        int weightSum = 0;
        while (days != 0) {

            while (weightSum + weights[index] <= limit) {
                weightSum += weights[index];
                if (index + 1 == weights.length) {
                    return true;
                } else {
                    index++;
                }
            }
            days--;
            weightSum = 0;
        }
        return false;
    }

    public int shipWithinDays(int[] weights, int days) {
        int totalWeight = 0;
        int maxWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            totalWeight += weights[i];
            maxWeight = Math.max(maxWeight, weights[i]);
        }

        int i = maxWeight;
        int j = totalWeight;
        Stack<Integer> stack = new Stack<>();
        while (i <= j) {
            int mid = i + (j - i) / 2;
            boolean result = check(weights, days, mid);
            if (result) {
                stack.push(mid);
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
//        System.out.println(stack);
        return stack.pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
