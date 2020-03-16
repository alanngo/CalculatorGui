package design;

import java.awt.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public CalculatorFrame(String name)
	{
		super(name);
		
		//set layout manager
		setLayout(new BorderLayout());
		
		//create swing components
		JTextArea area = new JTextArea();
		CalculatorPanel panel = new CalculatorPanel();
		
		//add listener
		panel.addCalcListener(new CalculatorListenerImpl(area));

		//add swing components to content pane
		Container c = getContentPane();
		
		c.add(area, BorderLayout.CENTER);
		c.add(panel, BorderLayout.WEST);
		
	}//end of constructor
}//end of class
