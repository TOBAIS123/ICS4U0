import java.io.*;
import java.util.*;

/**
 * This program reads multiple hands of cards from a file and outputs them sorted, organized, and evaluated
 *
 * @author Filip Milidrag
 * @version 1.0, April 2, 2019
 */



public class Cards
{
 /**
  * This method will output a number that represents which suit the the given character represents
  *
  *  @param suit Represents a letter that represents one of the suits
  *  @return The index of the suits array the this card belongs in, returns -1 if the letter is not S,H,D, or C
  */
    public static int search (char suit)
    {
  String suits = "SHDC";
  for (int i = 0 ; i < suits.length () ; i++)
  {
   if (suits.charAt (i) == suit)
   {
   return i;
   }
  }
  return -1;
    }
    
 /**
  * This method will output a number that represents which suit the the given character represents
  *
  *  @param cards Represents a hand of 13 cards
  *  @return An ArrayList containg the original hand of cards ordered in increasing to decreasing order and seperated by suit. It also contains the value of the hand. Of the hand is invalid the method will return a string that states that.
  */
    public static  ArrayList<String> evaluate(String cards)
    {
  ArrayList<String> al = new ArrayList<String>();
  if (cards.length() != 26)
  {
   al.add("This hand is invalid");
   return al;
  }
  int value = 0;
  String suit = "JQKA";
  char[] [] cardsSeperated = new char [2] [13];
  for (int i = 0 ; i < cards.length () ; i++)
  {
   cardsSeperated [i % 2] [i / 2] = cards.charAt (i);
  }
  if (checkValue(new String(cardsSeperated[0])))
  {
   al.add("This hand is invalid");
   return al;
  }
  for (int i = 0 ; i < cardsSeperated [0].length ; i++)
  {
   for (int j= 0; j<suit.length();j++)
   {
    if (cardsSeperated[0][i] == suit.charAt(j))
    {
     value += (j+1);
     break;
    }
   }
  }
  String[] suits = {"", "", "", ""};
  for (int i = 0 ; i < cardsSeperated [0].length ; i++)
  {
   if (cardsSeperated [1] [i] != -1)
   {
    suits [search (cardsSeperated [1] [i])] += cardsSeperated [0] [i];
   }
   else
   {
    al.add("This hand is invalid");
    return al;
   }
  }
  for (int i = 0 ; i < suits.length ; i++)
  {
   al.add(suits [i]);
  }
  for (int i = 0 ; i < al.size() ; i++)
  {
   if (al.get(i).length()<3)
    value+=(3-al.get(i).length());
  }
  al.add("The overall value of this hand is : "+value);
  return al;
 }

 /**
  * This method will output a number that represents the value of the card
  *
  *  @param card Represents a letter that represents one of the cards
  *  @return the number that this card has or would have if it were not a face card
  */
 public static int findValue(char card)
 {
  String cards = "23456789TJQKA";
  int n = 0;
  while(card != cards.charAt(n))
  {
   n++;
  }
  return n+1;
 }
 
 /**
  * This method will output whether or not a hand of cards is valid
  *
  *  @param hand Represents a hand of cards without the suit
  *  @return true if the hand is invalid
  */
 public static boolean checkValue(String hand)
 {
  String cards = "23456789TJQKA";
  int correct = 0;
  for (int i = 0; i<cards.length();i++)
  {
   for (int j = 0; j<hand.length();j++)
   if (hand.charAt(j) == cards.charAt(i))
    correct++;
  }
  return !(correct==hand.length());
 }
 
 /**
  * This method will sort a hand of cards that does not include suits, in decreasing order
  *
  *  @param cards Represents a hand of cards that doesn't include information about suits
  *  @return The sorted version of the original hand
  */
 public static String mergeSort(String cards)
 {
  if (cards.length()>1){
   int split = cards.length()/2;
   String first = cards.substring(0, split);
   String second = cards.substring(split);
   first = mergeSort(first);
   second = mergeSort(second);
   String sorted = "";
   while (first.length() != 0 && second.length()!= 0)
   {
    if (findValue(first.charAt(0))>findValue(second.charAt(0))){
     sorted+= first.charAt(0);
     first = first.substring(1);
     }
    else{
     sorted+= second.charAt(0);
     second = second.substring(1);
     }
   }
   if (first.length()!=0)
    sorted += first;
   else
    sorted += second;
   return sorted;
  }
  return cards;
 }
 
    public static void main (String[] args) throws IOException
    {
  BufferedReader in = new BufferedReader (new FileReader ("card.txt"));
  ArrayList<String> output= new ArrayList<String>();
  String line = " ";
  int n =0;
  while(line!=(null))
  {
   n++;
   line = in.readLine();
  }
  in = new BufferedReader (new FileReader ("card.txt"));
  for (int k = 0; k<n/4;k++)
  {
   System.out.println("Deck "+(k+1));
   for (int i = 0; i<4;i++)
   {
    output = evaluate(in.readLine ());
    System.out.println("Hand "+(i+1));
    for (int j = 0;j<output.size();j++)
    {
     if (j<output.size()-1)
      output.set(j,mergeSort(output.get(j)));
     System.out.println(output.get(j));
    }
   }
  }
 }
 
} // Cards class
