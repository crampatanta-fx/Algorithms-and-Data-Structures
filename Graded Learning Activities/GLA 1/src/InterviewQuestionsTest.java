import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class InterviewQuestionsTest {

	private static Random r;
	static
	{
		r=new Random(2);
	}
	public static int [] GetRandomArray(int n, int min, int max)
	{
		int []a=new int[n];
		for(int i=0; i<a.length; i++)
		{
			a[i]=r.nextInt(max-min+1)+min;
		}
		return a;
	}
	public static void displayDoubleArray(double []a)
	{
		for(int i=0; i<a.length; i++)
		{
			System.out.printf("%.2f\n",a[i]);
		}
			
	}
	public static void displayIntArray(int []a)
	{
		for(int i=0; i<a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
			
	}
	public static ArrayList<String> getNRandomNames(int n, ArrayList<String>nameList)
	{
		ArrayList<String> friendList=new ArrayList<String>();
		
		for(int i=0; i<n; i++)
		{
			friendList.add(nameList.get(r.nextInt(nameList.size())));
		}
		return friendList;
	}
	
	public static void displayNames(String name, ArrayList<String>nameList)
	{
		System.out.print(name+"'s Friend List: ");
		for(var n : nameList)
		{
			System.out.print(n+", ");
		}
		System.out.println();
	}
	
	public static void makeEvenAllThenOddAll(int []numbers, int pos)
	{
		for(int i=0; i<pos; i++)
		{
			if(numbers[i]%2==1)
			{
				numbers[i]++;
			}
		}
		for(int i=pos; i<numbers.length; i++)
		{
			if(numbers[i]%2==0)
			{
				numbers[i]++;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterviewQuestions solution=new InterviewQuestions();
		int n=10;
		
		double []HousePrice= Arrays.stream(GetRandomArray(n, 500000, 1000000)).asDoubleStream().toArray();
		System.out.println("Problem One: Pricey Neighbours");
		System.out.println("House Prices: ");
		displayDoubleArray(HousePrice);
		System.out.println("First index of Pricey Neighbours is: "+ solution.findPriceyNeighbours(HousePrice));
		
		System.out.println("\nProblem Two: Common Friends");
		ArrayList<String>nameList= new ArrayList<>(List.of(
				"Liam", "Noah", "Oliver", "William","Elijah","James","Benjamin","Lucas","Mason","Ethan","Alexander","Henry","Jacob","Michael", "Daniel",
				"Logan","Jackson","Sebastian","Jack","Aiden","Owen","Samuel","Matthew","Joseph","Levi","Mateo","David","John","Wyatt"));
		
		ArrayList<String> davidsFriends=getNRandomNames(10,nameList);
		displayNames("David", davidsFriends);
		ArrayList<String> susansFriends=getNRandomNames(10,nameList);
		displayNames("Susan", susansFriends);
		ArrayList<String> commonFriends=solution.commonFriends(davidsFriends, susansFriends);
		displayNames("Common Friends", commonFriends);
		
		System.out.println("\nProblem Three: Count Divisors");
		n=6;
		int []values=GetRandomArray(n, 5, 20);
		displayIntArray(values);
		System.out.println("\nCount: "+solution.countDivisors(values));
		n=10;
		System.out.println("\nProblem Four: First Odd Number");
		int []numbers=GetRandomArray(n, 10, 50);
		makeEvenAllThenOddAll(numbers, r.nextInt(n));
		displayIntArray(numbers);
		System.out.println("\nFirst odd number's index is: "+solution.findIndexOfFirstOddNumber(numbers));
	}

}

/*If you have implemented your GLA correctly, the following will be your program's output:

Problem One: Pricey Neighbours
House Prices: 
622968.00
520112.00
840169.00
925050.00
916256.00
909680.00
650372.00
979577.00
656166.00
891104.00
First index of Pricey Neighbours is: 3

Problem Two: Common Friends
David's Friend List: Jacob, Benjamin, Joseph, Owen, Michael, Lucas, Wyatt, Owen, Jacob, Alexander, 
Susan's Friend List: Jack, Alexander, Samuel, Henry, Daniel, Logan, Joseph, Benjamin, Sebastian, Wyatt, 
Common Friends's Friend List: Benjamin, Joseph, Wyatt, Alexander, 

Problem Three: Count Divisors
10 13 20 15 13 10 
Count: 3

Problem Four: First Odd Number
16 20 40 12 35 19 23 31 35 11 
First odd number's index is: 4
*/
