package twoPointer;

public class P11_ContainerWithMostWater {
	//time n
	//space 1
	public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int water = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, water);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
}
