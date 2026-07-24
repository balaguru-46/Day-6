class Solution {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n];
        long[] suffix = new long[n];

        // Prefix OR
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] | nums[i];
        }

        // Suffix OR
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] | nums[i];
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {
            long shifted = ((long) nums[i]) << k;

            long current = shifted;

            // OR elements before i
            if (i > 0) {
                current |= prefix[i - 1];
            }

            // OR elements after i
            if (i < n - 1) {
                current |= suffix[i + 1];
            }

            answer = Math.max(answer, current);
        }

        return answer;
    }
}