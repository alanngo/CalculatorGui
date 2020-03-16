import design.CalculatorFrame;

import javax.swing.*;
import static javax.swing.JFrame.*;
public class CalculatorApp
{
	public static void main(String[] args) 
	{
		JFrame f = new CalculatorFrame("Calculator");
		f.setSize(600, 200);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setVisible(true);

	}

}
