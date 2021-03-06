import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class PrimeNumberTable
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   int N=10;    // First 10 prime numbers
	   table(N);
	}
	public static int[][] table(int N)
	{
		if(N<=0)
		{
			int[][] a = {{0}};
			return a;
		}
			
		int[] arr = new int[N+1]; /* To store the prime numbers and a 1 in an array. '1' helps to display primes in bottom rows by multiplying with the '1'. Eg 2X1 = 2 displayed on 2nd row beginning.*/
		   arr[0]=1;    
		   int count=0; 
		   int num=2;
		   while(count!=N)// while count!= number of prime numbers entered keep searching.. 
		   {
		       boolean prime=true;// to determine whether the number is prime or not
	           for (int i=2;i<=Math.sqrt(num);i++)// most efficient is to check if number has any factor other than 1 starting from 1 to its square root
		       {
		           if (num%i==0)
		           {
		              prime=false;// if number divides any other number its not a prime so set prime to false and break the loop.
		                break;
		           }
		       }
		       if (prime)
		       {
		           count++;
		           arr[count]=num;// store that num in the arr array
		       }
		       num++; //see if next number is prime or not.
		   }
		   
		   int[][] a = new int[N+1][N+1];      // Results array; used for testing
		   
		   a[0][0] = 0;
		   
		   for(int i=1;i<N+1;i++)
    	       	   a[0][i]=arr[i];
		   
		   for(int i=1;i<N+1;i++)
	       {
	           for(int j=0;j<N+1;j++)
	                a[i][j]=arr[i]*arr[j];   // Multiple each prime by 1 (i.e. print itself) followed by other primes and display in a single row
	       }		
		   
		   System.out.printf("%5s"," ");           // Display 5 empty spaces on top left of table

		   for(int i=1;i<N+1;i++)
    	       System.out.printf("%5d",a[0][i]);    // Printing the top row of table i.e. the list of the prime numbers
	   
	       for(int i=1;i<N+1;i++)
           {
		     System.out.println("\n");
             for(int j=0;j<N+1;j++)
                System.out.printf("%5d",a[i][j]);
           }
	       return a;
	}
}
//Run Complexity of code is O(N^2) due to the nested for loop for doing the multiplication.
//Space complexity is O(N^2) for 2d array
//Scales by N^2