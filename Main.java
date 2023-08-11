import java.util.*;
   class Solution {
       //Q1:- Finding First Occurring Element In An Array(1 based indexing)
       int Answer1(int[] arr, int n) {
           for (int i = 0; i < arr.length; i++) {
               for (int j = i + 1; j < arr.length; j++) {
                   if (arr[i] == arr[j]) {
                       return (i + 1);
                   }
               }
           }
           return -1;
       }

       // Q2 rearranging alternate pos and negative elements starting with negative
       void Answer2(int[] arr, int n) {
           int k = 0;
           int l = 1;
           int pos = 0;
           int neg = 0;
           int[] ans = new int[n];
           for (int i = 0; i < arr.length; i++) {
               if (arr[i] >= 0) {
                   pos++;
               } else {
                   neg++;
               }
           }
           int min = Math.min(pos, neg);
           int lim = (2 * min) - 1;
           int m = lim + 1;
           for (int i = 0; i < arr.length; i++) {
               if (arr[i] < 0 && k <= lim) {
                   ans[k] = arr[i];
                   k += 2;
               } else if (arr[i] >= 0 && l <= lim) {
                   ans[l] = arr[i];
                   l += 2;
               } else {
                   ans[m] = arr[i];
                   m++;
               }
           }
           for (int i = 0; i < ans.length; i++) {
               System.out.print(ans[i] + " ");
           }
           System.out.println();
       }

       //Q3 finding minimum platforms.
       int Answer3(int arr[], int dep[], int n) {
          // Solution temp_obj = new Solution();
           Arrays.sort(arr);
            Arrays.sort(dep);
           int i = 1;
           int j = 0;
           int platform = 1;
           int result = 1;
           while (i < n&&j<n) {
               if (arr[i] <= dep[j]) {
                   platform++;
                   i++;
               } else if (arr[i] > dep[j]) {
                   platform--;
                   j++;
               }
               result = Math.max(result, platform);
           }
           return result;
       }

       int[]  Sorting(int[] ans, int k) {
           for (int i = 0; i < k - 1; i++) {
               for (int j = 0; j < k - 1 - i; j++) {
                   if (ans[j] > ans[j + 1]) {
                       int t = ans[j];
                       ans[j] = ans[j + 1];
                       ans[j + 1] = t;
                   }
               }
           }
           return ans ;
       }
   }

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            //System.out.println("Enter the size ");//q1 and q2
           System.out.println("enter no of trains");//q3
            int n =sc.nextInt();
            int[] dep =new int[n];//q3
            int[] arr = new int[n];//q1 q2 q3
           // System.out.println("enter elements");//q1 and q2
            System.out.println("enter arrival time");//q3
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
           System.out.println("enter departure timings");//q3
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
           // System.out.println(obj.Answer1(arr, n));
            //obj.Answer2(arr,n);
            System.out.println("platform needed minimum "+obj.Answer3(arr,dep,n));
        }
    }

