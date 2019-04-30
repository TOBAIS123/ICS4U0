import java.util.*;
class Main {
   public static void swap(int [] a, int left, int right){
        int leftValue = a[left];
        int rightValue = a[right];
        a[left] = rightValue;
        a[right] = leftValue;
    }
    public static String subArray(int a [], int left, int right){
        ArrayList<Integer> temp = new ArrayList();
        for (int i = left; i <= right+1; i++){
            temp.add(a[i]);
        }
        return temp.toString();
    }
    public static int findPivot(int [] a, int left, int right){
        int pivot = a[right];
        if (right == 0){
            return right;
        }
        right--;
        int leftIndex = left;
        int rightIndex = right;
        System.out.println("The pivot is: " + pivot + " for the array " + subArray(a, left, right));
        while(true){
            int leftValue = a[left];
            int rightValue = a[right];
            while(leftValue < pivot){
                left++;
                leftValue = a[left];
            }
            while(right > 0 && rightValue > pivot){
                right--;
                rightValue = a[right];
            }
            if (left >= right){
                System.out.println(Arrays.toString(a)+ " before swap " + left + " " + right);
                swap(a, left, rightIndex+1);
                System.out.println(Arrays.toString(a) + " after swap");
                return left;
            }
            else{
                if (a[left] == pivot && a[right] == pivot){
                  left++;
                }
                System.out.println(Arrays.toString(a)+ " before swap " + left + " " + right);
                swap(a, left, right);
                System.out.println(Arrays.toString(a) + " after swap " + right + " " + left);
            }
        }
    }
    public static int findPivot(int [] a, int left, int right, boolean b){
      int pivot  = a[right];
      int index = left;
      for (int i = left; i < right; i++){
        if (a[i] < pivot){
          swap(a, i, index);
          index++;
        }
      }
      swap(a, index, right);
      return index;
    }
    public static void sort(int [] a, int left, int right){
        if (left > right){
            return;
        }
        int pivotIndex = findPivot(a, left, right, true);
        sort(a, left, pivotIndex-1);
        sort(a, pivotIndex+1, right);
    }
    public static void add(ArrayList <Integer> a, int [] a1){
        for (int i = 0; i < a1.length; i++){
            a.add(a1[i]);
        }
    }
    public static void main(String[] args) { 
        int [] test1 = new int [6];
        for (int i = 0; i < 6; i++){
          test1[i] = (int)(Math.random()*10);
        }
        
        long before = System.nanoTime();
        System.out.println(Arrays.toString(test1) + " unsorted");
        sort(test1, 0, test1.length-1);
        System.out.println(Arrays.toString(test1)  + " sorted");
        long after = System.nanoTime();
        double inSeconds = ((double)after-before)/1000000000;
        System.out.println(inSeconds + " seconds taken");
    }
}