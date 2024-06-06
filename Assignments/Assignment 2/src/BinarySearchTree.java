
public class BinarySearchTree {
	private EmployeeNode root;
	int count = 0;
	int sum = 0;
	
	public BinarySearchTree() {
		setRoot(null);
	}
	
	public void setRoot(EmployeeNode root) {
		this.root = root;
	}
	
	public EmployeeNode getRoot() {
		return root;
	}
	
	public boolean isEmpty() {
		if (getRoot() == null) {
			return true;
		}
		
		return false;
	}
	
	public void insert(EmployeeNode st) {
		if (st == null) {
			return;
		}
		
		st.setLeft(null);
		st.setRight(null);
		
		if(isEmpty()) {
			root = st;
		}
		else {
			// Start form the root and look for spot to insert
			EmployeeNode cursor = getRoot();
			
			while(true) {
				EmployeeNode parent = cursor;
				
				if(st.getSalary() <= cursor.getSalary()) {
					cursor = cursor.getLeft();
					
					if(cursor == null) {
						parent.setLeft(st);
						return;
					}
				} 
				else if(st.getSalary() > cursor.getSalary()) {
					cursor = cursor.getRight();
					
					if(cursor == null) {
						parent.setRight(st);
						return;
					}
				}
			}
		}
	}
	
	//#1
    public EmployeeNode highestSalary(EmployeeNode cursor){
    	   	
        if (cursor.getRight() == null) {
        	return cursor;
        }
            
        return highestSalary(cursor.getRight());
    }
    
	//#2
    public EmployeeNode lowestSalary(EmployeeNode cursor){
        if (cursor.getLeft() == null) {
        	return cursor;
        }
            
        return lowestSalary(cursor.getLeft());
    }
    
    //#3
	public void preOrderTraverse(EmployeeNode cursor) {		
        if (cursor != null) {

            System.out.println(cursor);
            preOrderTraverse(cursor.getLeft());
            preOrderTraverse(cursor.getRight());
        }
	}
	
	//#4
	public int countEmployees(EmployeeNode cursor) {
		
		
		if (cursor != null) {
			count++;
			countEmployees(cursor.getLeft());
			countEmployees(cursor.getRight());
		}
		
		return count;
		
	}
	
	//#5
	public int averageSalary(EmployeeNode cursor) {
		
		
		if (cursor != null) {
		    sum = sum + cursor.getSalary();

		    averageSalary(cursor.getLeft());
		    averageSalary(cursor.getRight());
		}
		
		return sum / count;
		
	}
	
	public EmployeeNode search(EmployeeNode cursor, int key) {
		if(cursor != null) {
			if(key == cursor.getSalary()) {
				return cursor;
			} 
			else if(key < cursor.getSalary()) {
				return search(cursor.getLeft(), key);
			} 
			else {
				return search(cursor.getRight(), key);
			}
		}
		
		return null;
	}
	
	public void inOrderTraverse(EmployeeNode cursor) {
		if (cursor != null) {
			inOrderTraverse(cursor.getLeft());
			System.out.println(cursor);
			inOrderTraverse(cursor.getRight());
		}
	}

}
