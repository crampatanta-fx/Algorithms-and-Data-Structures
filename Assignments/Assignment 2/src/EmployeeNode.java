
public class EmployeeNode {
	public String firstName;
	public String lastName;
	private int age;
	private int salary;
	private int id;
	private EmployeeNode right, left;
	
	public EmployeeNode (String firstName, String lastName, int age, int salary, int id) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
		setSalary(salary);
		setId(id);
		setLeft(null);
		setRight(null);
	}
	
	public String toString() {
		return firstName + " " + lastName + ", " + age + ", " + salary + ", " + id;
	}
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setAge (int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setSalary (int salary) {
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setId (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
		
	public void setLeft(EmployeeNode left) {
		this.left = left;
	}
	
	public EmployeeNode getLeft() {
		return left;
	}
	
	public void setRight(EmployeeNode right) {
		this.right = right;
	}
	
	public EmployeeNode getRight() {
		return right;
	}
}
