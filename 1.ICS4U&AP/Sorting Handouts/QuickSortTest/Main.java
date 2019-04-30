import java.util.*;
class Main {
   public static void swap(ArrayList<Integer> a, int left, int right){
        int leftValue = a.get(left);
        int rightValue = a.get(right);
        a.set(left, rightValue);
        a.set(right, leftValue);
    }
    public static String subArray(ArrayList<Integer> a, int left, int right){
        ArrayList<Integer> temp = new ArrayList();
        for (int i = left; i <= right+1; i++){
            temp.add(a.get(i));
        }
        return temp.toString();
    }
    public static int findPivot(ArrayList<Integer> a, int left, int right, boolean b){
      int i = left;
      int pivot = a.get(right);
      for (int j = left; j < right; j++){
        if (a.get(j) < pivot){
          swap(a, j, i);
          i++;
        }
      }
      swap (a, i, right);
      return i;
    }
    public static int findPivot(ArrayList<Integer> a, int left, int right){
        int pivot = a.get(right);
        if (right == 0){
            return right;
        }
        right--;
        int leftIndex = left;
        int rightIndex = right;
        //System.out.println("The pivot is: " + pivot + " for the array " + subArray(a, left, right));
        while(true){
            int leftValue = a.get(left);
            int rightValue = a.get(right);
            while(leftValue < pivot){
                left++;
                leftValue = a.get(left);
            }
            while(right > 0 && rightValue > pivot){
                right--;
                rightValue = a.get(right);
            }
            if (left >= right){
                //System.out.println(a.toString() + " before swap");
                swap(a, left, rightIndex+1);
                //System.out.println(a.toString() + " after swap");
                return left;
            }
            if(leftValue >= pivot && rightValue <= pivot){
                swap(a, left, right);
            }
        }
    }
    public static void sort(ArrayList <Integer> a, int left, int right){
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
        ArrayList <Integer> test = new ArrayList();
        for (int i = 0; i++ < 1000000;) test.add((int)(Math.random()*Integer.MAX_VALUE)); 
        //int [] test1 = {0,405,6,23,4,1,-213,12923,929};
        //add(test, test1);
        long before = System.nanoTime();
        //System.out.println(test.toString() + " unsorted");
        sort(test, 0, test.size()-1);
        //System.out.println(test.toString() + " sorted");
        long after = System.nanoTime();
        double inSeconds = ((double)after-before)/1000000000;
        System.out.printf("%.2f seconds taken",inSeconds);
    }
}