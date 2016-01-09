import java.io.*;
import java.util.*;
public class Iterator_vs_ForEach
{
//Kamron Soldozy, simple comparing program
   public static int nums;
   public static void main(String[] args)
   {
      System.out.println("ListIterators vs ArrayList looping\nKamron Soldozy\n");
      Scanner infile = new Scanner(System.in);
      System.out.println("How many integers?");
      nums = Integer.parseInt(infile.nextLine());
      System.out.println("What value of integer?");
      performTest(nums, Integer.parseInt(infile.nextLine()));
   }
   @SuppressWarnings("unchecked")
   public static void  performTest(int nums, int val){ 
   
      ArrayList storage = new ArrayList<Integer>(); 
      for(int x = 0; x<nums; x++){
         storage.add(val);
      }
      
      actualTest(storage);
   
   }
   
   @SuppressWarnings("unchecked")
   public static void actualTest(ArrayList<Integer> storage) 
   {
      int sum = 0; 
      
      double time = System.nanoTime();
      for(Integer x : storage)
         sum += x.intValue();
    
      System.out.println("Using a for : each loop, summing the data: " + sum);
      double foreachT = (System.nanoTime()-time)/(10E6);
      System.out.println(foreachT+" ms");
      
      sum = 0; 
      ListIterator<Integer> iterator = storage.listIterator();
    
      time = System.nanoTime();
         
      while(iterator.hasNext())
         sum+=(iterator.next()).intValue();
     
      System.out.println("Using while(iterator.hasNext()), summing the data: " + sum);
      double iteratorT = (System.nanoTime()-time)/(10E6);
      System.out.println(iteratorT+" ms");
   
      compareTime(iteratorT, foreachT);
   
   }
   @SuppressWarnings("unchecked")
   public static void compareTime(double iterator, double foreach)
   {
      double difference = iterator - foreach;
      if(difference > 0)
         System.out.println("The Iterator method took " + difference + " ms longer!"); 
      else if(difference == 0)
         System.out.println("They took exactly the same time!");
      else if(difference < 0)
         System.out.println("The for : each method took " + (-1.0 * difference) + " ms longer!");
   
      System.out.println("\nIn my experiences, smaller sets of data are more efficient with iterators, and \n larger ones are faster for generic for : each looping. \nThe data values inserted obviously do not matter.");
   
   }
          
}