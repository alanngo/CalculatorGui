import java.util.*;

public class Calculator 
{
	private static double performOperation(double x, String op, double y)
	{
		switch (op)
		{
			case "*":
				return x * y;
			case "/":
				return x / y;
			case "+":
				return x + y;
			case "-":
				return x - y;
		}
		return 0;
	}
	/*
	 * Computes an infix from 2 arguments
	 * **/
	public static double compute(String expression)
	{
		Stack<String> s = new Stack<>();
		StringTokenizer tok = new StringTokenizer(expression, "{}()*/+-", true); //split into tokens
		
		while (tok.hasMoreTokens())
		{
			String str = tok.nextToken();
			if (str.matches("[0-9]+")
				||str.equals("{")
				||str.equals("(")
				||str.equals("*")
				||str.equals("/")
				||str.equals("+")
				||str.equals("-"))
				s.push(str);
			else if (str.equals("}")
					||str.equals(")")
					||str.equals(""))
			{
				try
				{
					double op2 = Double.parseDouble(s.pop());
					String operator = s.pop();
					double op1 = Double.parseDouble(s.pop());
					
					//clear } or )
					if (!s.isEmpty())
						s.pop();
					double result = performOperation(op1, operator, op2);
					s.push(result+"");
				}
				catch(Exception e)
				{
					e.printStackTrace();
					break;
				}
			}
		}
		String last ="";
		try {last = s.pop();}
		catch(Exception e) {e.printStackTrace();}
			
		return Double.parseDouble(last);
	}
}
