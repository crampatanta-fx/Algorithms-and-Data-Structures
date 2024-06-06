package GLA2;

public class StackLinkedList<E> implements StackI<E> {

	private class Node<E>{
		private E value;
		private Node next;
		
		private Node(E val, Node<E> ref)
		{
			value=val;
			next=ref;
		}
	}
	
	private Node<E> topOfStack;
	
	public StackLinkedList()
	{
		topOfStack=null;
	}
	
	
	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return topOfStack==null;
	}
	
	
	@Override
	public void push(E val) {
		// TODO Auto-generated method stub
		topOfStack=new Node<>(val, topOfStack);
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(empty())
		{
			return null;
		}
		else {
			E val=topOfStack.value;
			topOfStack=topOfStack.next;
			return val;
		}
	}

	

	@Override
	public E top() {
		if(empty())
		{
			return null;
		}
		else {
			return topOfStack.value;			
		}
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Display Stack: ");
		System.out.print("top -->");
		for(Node<E> i=topOfStack; i!=null; i=i.next)
		{
			System.out.println("\t|\t"+i.value+"\t|");
		}
		System.out.println("\t|\tNULL\t|");
		}
}
