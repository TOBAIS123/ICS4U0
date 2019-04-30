// By: Rohan Krishna, Jae Park and Noam Silverman

public class mostSignificant
{
    int[] numbers = {1, 421, 34, 57, 2, 92, 514};
    int maxDigits;
    
    public mostSignificant ()
    {
        maxDigits = 0;
    }
    
    
    public void msdRadixSort ()
    {
        int largestNum = numbers[0];
        
        //find largest number in array
        for (int x = 1; x < numbers.length; x++)
        {
            
            largestNum = Math.max (largestNum, numbers [x]);
        }
        
        //find number of digits
        while (largestNum / (int) Math.pow (10, maxDigits) > 0)
        {
            maxDigits++;
        }
        
        numbers = sortArray (numbers, maxDigits - 1);
        //output ordered array
        for (int x = 0; x < numbers.length; x++)
        {
            System.out.println (numbers [x]);
        }
    }
    
    
    public int[] sortArray (int[] numArray, int exponentOfTen)
    {
        int[][] bucket = new int [10][numArray.length]; //stores elements sorted into buckets
        int[] newNumArray = new int[numArray.length]; //stores elements of original array in different order
        int newArrayIndex = numArray.length - 1;
        int bucketIndex;
        int digit;
        
        if (exponentOfTen >= 0)
        {
            //check for digits 0-9 in ascending order
            for (int x = 0; x <= 9; x++)
            {
                bucketIndex = 0;
                //loop through array elements
                for (int index = 0; index < numArray.length; index++)
                {
                    digit = (numArray [index] / (int) Math.pow (10, exponentOfTen)) % 10;
                    //add number to new array if its digit at a certain position is equal to the digit being looked for
                    if (digit == x)
                    {
                        bucket [x] [bucketIndex] = numArray [index];
                        bucketIndex++;
                    }
                }
            }
            
            //sorts buckets again using the next digit from the left and returns a final array after all recursive calls
            for (int x = 9; x >= 0; x--)
            {
                int[] tempArray;
                tempArray = sortArray (bucket [x], exponentOfTen - 1);
                for (int index = tempArray.length - 1; index >= 0; index--)
                {
                    //store elements from tempArray into newNumArray
                    if (tempArray [index] != 0 && newArrayIndex >= 0)
                    {
                        newNumArray [newArrayIndex] = tempArray [index];
                        newArrayIndex--;
                    }
                }
            }
            return newNumArray;
        }
        else      
        {
            return numArray;
        }
    }
}