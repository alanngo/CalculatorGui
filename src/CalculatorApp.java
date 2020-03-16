import javax.swing.*;

public class CalculatorApp
{
	public static void main(String[] args) 
	{
		JFrame f = new CalculatorFrame("Calculator");
		f.setSize(600, 200);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
