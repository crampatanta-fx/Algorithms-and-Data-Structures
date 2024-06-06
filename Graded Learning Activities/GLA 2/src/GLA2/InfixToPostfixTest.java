package GLA2;



public class InfixToPostfixTest {
	
	public static void main(String[] args) {
		
		InfixToPostfix test1=new InfixToPostfix();
		String s="w - 5.1 / sum * 2";
		String result=test1.getInfixToPostfix(s);
		System.out.println(result);
	
	}
}
