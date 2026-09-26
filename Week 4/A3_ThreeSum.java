import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A3_ThreeSum {
    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> triplets = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                long sum = (long) nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    triplets.add(new int[]{nums[i], nums[left], nums[right]});
                    left++;
                    right--;

                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return triplets.toArray(new int[triplets.size()][]);
    }

    public static void main(String[] args) {
        int[][] result = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (int[] triplet : result) {
            System.out.println(Arrays.toString(triplet));
        }

        int[][] result2 = threeSum(new int[]{0, 0, 0});
        for (int[] triplet : result2) {
            System.out.println(Arrays.toString(triplet));
        }
    }
}