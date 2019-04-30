// By: Rohan Krishna, Jae Park and Noam Silverman

public class leastSignificant
{
    int[] numbers = {1, 421, 34, 57, 2, 92, 514};
    int maxDigits;
    
    public leastSignificant ()
    {
        maxDigits = 0;
    }
    
    
    public void lsdRadixSort ()
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
        
        numbers = sortArray (numbers, 1);
        //output ordered array
        for (int x = 0; x < numbers.length; x++)
        {
            System.out.println (numbers [x]);
        }
    }
    
    
    public int[] sortArray (int[] numArray, int exponentOfTen)
    {
        int[] newNumArray = new int[numArray.length]; //stores elements of original array in different order
        int newArrayIndex = 0;
        int digit;
        
        if (exponentOfTen < maxDigits)
        {
            //check for digits 0-9 in ascending order
            for (int x = 0; x <= 9; x++)
            {
                //loop through array elements
                for (int index = 0; index < numArray.length; index++)
                {
                    digit = (numArray [index] / (int) Math.pow (10, exponentOfTen)) % 10;
                    //add number to new array if its digit at a certain position is equal to the digit being looked for
                    if (digit == x)
                    {
                        newNumArray [newArrayIndex] = numArray[index];
                        newArrayIndex++;
                    }
                }
            }
            //sorts array again using the next digit from the right and returns a final array after all recursive calls
            return sortArray (newNumArray, exponentOfTen + 1);
        }
        else      
        {
            return numArray;
        }
    }
}