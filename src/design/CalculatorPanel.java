package design;

import event.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorPanel extends HelperPanel
{
	private static final long serialVersionUID = 1L;
	private static final String ops = "+-*/";
	private static final String brackets="(){}";

	public CalculatorPanel()
	{
		super();
		
		//dimensions of panel
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Basic Calc"));
		
		/*init buttons*/

		//numbers buttons
		JButton[] numbers = new JButton[10]; //0-9
		for (int i = 0; i< numbers.length; i++)
			numbers[i] = new JButton(String.valueOf(i));

		//operators buttons
		JButton[] operators = new JButton[ops.length()]; //operators
		for (int i = 0; i< operators.length; i++)
			operators[i]= new JButton(Character.toString(ops.charAt(i)));

		//grouping buttons
		JButton[] group = new JButton[brackets.length()];
		for (int i = 0; i< group.length; i++)
			group[i]= new JButton(Character.toString(brackets.charAt(i)));

		//clear button
		JButton clearBttn = new JButton("C");

		//equals button
		JButton equalsBttn = new JButton("=");

		//implement functionality thru action listener
		clearBttn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				fireClearEvent(new ClearEvent(this));
			}
		});
		
		equalsBttn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				fireEqualEvent(new EqualEvent(this));
			}
		});

		// for numbers operators and grouping
		for (JButton n: numbers)
		{
			n.addActionListener(
			new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					String txt = n.getText();
					fireCalcEvent(new CalculatorEvent(this, txt));
				}});
		}
		for (JButton o: operators)
		{
			o.addActionListener(
			new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					String txt = o.getText();
					fireCalcEvent(new CalculatorEvent(this, txt));
					
				}});
		}
		for (JButton g: group)
		{
			g.addActionListener(
			new ActionListener() 
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					String txt = g.getText();
					fireCalcEvent(new CalculatorEvent(this, txt));
					
				}});
		}
		
		//implement the layout
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();
		
		//spacing between elements
		gc.weightx = 0.5;
		gc.weighty = 0.5;

		//number buttons
		addNumberButton(gc, 1, 3, 1,0, numbers);
		addNumberButton(gc, 4, 6, 4,1, numbers);
		addNumberButton(gc, 7, 9, 7,2, numbers);
		
		//clear button, 0, equals
		addButton(gc, 0, clearBttn);
		addButton(gc, 1, numbers[0]);
		addButton(gc, 2, equalsBttn);

		//operators
		addButton(gc, 3, operators);
		addButton(gc, 4, group);
		
	}//end of constructor
}
