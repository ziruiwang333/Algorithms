package common_algorithms.sort;

import java.util.Arrays;

/**
 * @Description:
 * @Date: 2022/10/2
 * @Author: Zirui Wang
 */
public class QuickSort {
    public void quickSort(int[] arr){
        System.out.println("[QuickSort] Before sort: " + Arrays.toString(arr));
        helper(arr, 0, arr.length-1);
        System.out.println("[QuickSort] After sort: " + Arrays.toString(arr));
    }
    public void helper(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int base = arr[start];
        int left = start;
        int right = end;
        while(left < right){
            if(arr[right] >= base){
                right--;
                continue;
            }
            if(arr[left] <= base){
                left++;
                continue;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        arr[start] = arr[left];
        arr[left] = base;
        helper(arr, start, left-1);
        helper(arr, left+1, end);
    }
}

class TestQuickSort{
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{4,2,7,5,8,0,3,2,6};
        quickSort.quickSort(arr);
    }
}