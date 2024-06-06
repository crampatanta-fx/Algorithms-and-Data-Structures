import java.util.Random;
/*please do not modify a single character from this java class*/

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		
		IList myList=new SinglyLinkedList();
		Random r=new Random(1); //do not change the seed parameter
		for(int i=0; i<5; i++)
		myList.add(r.nextInt(101)+1);
		myList.add(0, 7);
		myList.add(3, 77);
 		myList.add(1000, 777);
		System.out.println(myList);
		System.out.println("List Size: "+myList.size());
		myList.clear();
		System.out.println(myList);
		System.out.println("List Size: "+myList.size());
		
		for(int i=0; i<5; i++)
		myList.add(r.nextInt(101)+1);
		System.out.println(myList);
		System.out.println("List Size: "+myList.size());
		int sVal=31;
		System.out.format("Index of %d is %d.\n",sVal, myList.indexOf(sVal));
		sVal=1000;
		System.out.format("Index of %d is %d.\n",sVal, myList.indexOf(sVal));
		int index=4;
		System.out.println("Value at index -3, "+index+" and 100 are: "+myList.get(-3)+", "+myList.get(index)+", and "+myList.get(100)); 
		myList.remove(0);
		myList.remove(-10);
		myList.remove(100);
		myList.remove(2);
		System.out.println(myList);
		System.out.println("List Size: "+myList.size());
		myList.add(31);
		myList.add(32);
		myList.add(33);
		myList.add(31);	
		System.out.println(myList);
		if(myList.removeAll(31)==true)
		System.out.println("Successfully removed items from the list. \n" +"After removal operation list items are: "+myList);
		myList.reverse();
		System.out.println("The updated reversed list is: "+myList);
		myList.sort();
		System.out.println("The sorted list is: "+myList);
		
	}
}
