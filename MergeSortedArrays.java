import java.util.Scanner;

public class MergeSortedArrays {

    static void mergeSortedArrays(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        int[] result = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {

            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            }
            else {
                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < n1) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        while (j < n2) {
            result[k] = arr2[j];
            j++;
            k++;
        }

        System.out.println("Merged array:");

        for (int x = 0; x < result.length; x++) {
            System.out.print(result[x] + " ");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();

        int[] arr1 = new int[n1];

        System.out.println("Enter elements of first sorted array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();

        int[] arr2 = new int[n2];

        System.out.println("Enter elements of second sorted array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        mergeSortedArrays(arr1, arr2);

        sc.close();
    }
}