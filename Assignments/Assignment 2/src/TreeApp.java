
public class TreeApp {
	public static void main(String[] args) {
		BinarySearchTree myTree = new BinarySearchTree();
		
		myTree.insert(new EmployeeNode ("Kevin", "Garnett", 47, 343000, 21));
		myTree.insert(new EmployeeNode ("Kevin", "Love", 35, 269600, 42));
		myTree.insert(new EmployeeNode ("Karl-Anthony", "Towns", 28, 382000, 32));
		myTree.insert(new EmployeeNode ("Jimmy", "Butler", 34, 258050, 23));
		myTree.insert(new EmployeeNode ("Anthony", "Edwards", 22, 370000, 5));
		
		System.out.println("1. Highest Salary");
        System.out.println(myTree.highestSalary(myTree.getRoot()));
        
		System.out.println("\n2. Lowest Salary");
        System.out.println(myTree.lowestSalary(myTree.getRoot()));
        
		System.out.println("\n3. Pre-order traversal");
		myTree.preOrderTraverse(myTree.getRoot());
		
		System.out.println("\n4. Number of employees: " + myTree.countEmployees(myTree.getRoot()));
		
		System.out.println("\n5. Average salary of the employees: " + myTree.averageSalary(myTree.getRoot()));
	}
}
