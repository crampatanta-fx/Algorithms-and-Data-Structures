
public class SinglyLinkedList implements IList{

	Node head;
	
	@Override
	public void add(int item) {
		// TODO Auto-generated method stub
		
		Node new_node = new Node();
		
		new_node.value = item;
		new_node.next = null;
		 
        if (head == null) {
            head = new_node;
            return;
        }
 
        Node nodePtr = head;
        
        while (nodePtr.next != null) {
        	nodePtr = nodePtr.next;
        }
 
        nodePtr.next = new_node;
	}

	@Override
	public void add(int index, int item) {
		// TODO Auto-generated method stub	
	
		Node new_node = new Node();
		Node nodePtr = head;
		
		new_node.value = item;
		new_node.next = null;
		
		if (index < 0 || index > size()) {
	        while (nodePtr.next != null) {
	        	nodePtr = nodePtr.next;
	        }
	 
	        nodePtr.next = new_node;
		}
		else if (index == 0) {
			new_node.next = head;
		    head = new_node;
		}
		else {
			nodePtr = head;
			
		    for(int i = 0; i < index-1; i++) {
		    	if(nodePtr != null) {
		    		nodePtr = nodePtr.next;
		    	}
		    }
		    
		    if(nodePtr != null) {
		    	new_node.next = nodePtr.next;
		    	nodePtr.next = new_node;  
		    } 
		}
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
	    Node nodePtr = head;

	    while (nodePtr != null) {
	        Node next = nodePtr.next;
	        nodePtr.next = null;
	        nodePtr = next;
	    }
	    
	    head = null;
	}

	@Override
	public int indexOf(int item) {
		// TODO Auto-generated method stub
		  int index = 0;
		  Node nodePtr = head;
		  
		  while (nodePtr != null) {
		    if (nodePtr.value == item) {
		      return index;
		    }
		    
		    nodePtr = nodePtr.next;
		    index++;
		  }
		  
		  return -1;
	}

	@Override
	public int get(int index) {
		// TODO Auto-generated method stub
		int value = -1;
		
        if(index < 0 || index > size()) {
        	return value;
        }
        
        Node nodePtr = head;
        for(int i = 0 ; i< index; i++) {
        	nodePtr = nodePtr.next;
        }
        
        if (nodePtr != null) {
        	value = nodePtr.value;
        }

        return value;
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
	    boolean flag = false;
	    
	    if(index < 0 || index > size()) {
	        return flag;
	    }
	    
	    if (index == 0){
	        head = head.next;
	    }else {
	    	Node nodePtr = head;
	    	
	        for (int i = 0; i < index-1; i++) {
	        	nodePtr = nodePtr.next;
	        }
	        
            if (nodePtr.next == null) {
                return flag;
            }else{
        
            	nodePtr.next = nodePtr.next.next;
            }
	            
	        return true;
	    }
	    
	    return flag;
	}

	@Override
	public boolean removeAll(int item) {
		// TODO Auto-generated method stub
		while (head != null && head.value == item) {
			head = head.next;
		}
		
		Node nodePtr = head;
		
		while (nodePtr != null && nodePtr.next != null) {
			if (nodePtr.next.value == item) {
				nodePtr.next = nodePtr.next.next;
			}
			else {
				nodePtr = nodePtr.next;
			}
		}
		
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		Node nodePtr = this.head;
		int count = 0;
		
		while (nodePtr != null) {
			count++;
			nodePtr = nodePtr.next;
		}
		
		return count;	
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		Node nodePtr, previous, current, next;

		if (head == null)
	            return;		
		
		nodePtr = head;
		previous = head.next;
		current = null;
		 
		 while (previous != null) {
			next = previous.next;
			nodePtr.next = current;
			current = nodePtr;
			nodePtr = previous;
			previous = next;
		 }
		 
		 head = nodePtr;
		 nodePtr.next = current;
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
        Node nodePtr = head, index = null;
 
        int temp;
 
        if (head == null) {
            return;
        }
        else {
            while (nodePtr != null) {
            	
                index = nodePtr.next;
 
                while (index != null) {

                    if (nodePtr.value > index.value) {
                        temp = nodePtr.value;
                        nodePtr.value = index.value;
                        index.value = temp;
                    }
 
                    index = index.next;
                }
                
                nodePtr = nodePtr.next;
            }
        }
	}
	
	public String toString()
	{
		Node start=head;
		String str="";
		if(start==null) {
			return "List Empty!";
		}
		
		while(start.next!=null)
		{
			str+=start.value+" -> ";
			start=start.next;
		}
		
		str+=start.value+".";	
		
		return "List items: "+str;
	}
}