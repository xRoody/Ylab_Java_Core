package second;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr={5,6,3,2,5,1,4,9};
        int[] tmp=startSortNoSideEffect(arr);
        System.out.println(Arrays.toString(tmp));
        assert Arrays.equals(tmp, new int[]{1, 2, 3, 4, 5, 5, 6, 9}) : "Wrong sort";
        assert tmp.length == new int[]{1, 2, 3, 4, 5, 5, 6, 9}.length : "Wrong sort, length side effect";
        startSortSideEffect(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void startSortSideEffect(int[] arr){
        qSortSideEffect(arr, 0, arr.length);
    }

    public static void qSortSideEffect(int[] arr, int start, int end){
        if(end-start<=1) return;
        int mid=(end+start)/2;
        for (int i=start; i<end; i++){
            if(i==mid) continue;
            int buf=arr[i];
            if (buf<arr[mid] && i>mid){
                System.arraycopy(arr, mid, arr, mid+1,i-mid);
                mid++;
                arr[mid-1]=buf;
                i--;
            }
            if (buf>arr[mid] && i<mid){
                System.arraycopy(arr, i+1, arr, i,mid-i+1);
                mid--;
                arr[mid+1]=buf;
                i--;
            }
        }
        qSortSideEffect(arr,start, mid);
        qSortSideEffect(arr,mid+1, end);
    }

    public static int[] startSortNoSideEffect(int[] arr){
        int[] target=new int[arr.length];
        System.arraycopy(arr,0, target, 0, arr.length);
        qSortSideEffect(target, 0, arr.length);
        return target;
    }
}
