import java.util.Scanner;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {

        // Reduce k
        k = k % nums.length;

        // Create new array
        int[] newArray = new int[nums.length];

        // Place each element in its new position
        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated array:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}