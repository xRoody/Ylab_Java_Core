package first;

public class Main {
    public static void main(String[] args) {
        int[][] arr=new int[20][20];
        for(int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                arr[i][j]= (int) (Math.random() * 10000);
            }
        }
        System.out.println(findMax(arr));
        System.out.println(findMin(arr));
        System.out.println(calcMid(arr));
    }

    public static int findMin(int[][] target){
        int min=Integer.MAX_VALUE;
        for (int[] ints : target) {
            for (int anInt : ints) {
                if (anInt < min) min = anInt;
            }
        }
        return min;
    }

    public static int findMax(int[][] target){
        int max=Integer.MIN_VALUE;
        for (int[] ints : target) {
            for (int anInt : ints) {
                if (anInt > max) max = anInt;
            }
        }
        return max;
    }

    public static double calcMid(int[][] target){
        int  mid=0;
        int count=0;
        for (int[] ints : target) {
            for (int anInt : ints) {
                count++;
                mid += anInt;
            }
        }
        return mid/(double)count;
    }
}
