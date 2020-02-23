import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private static final String ops = "+-*/";
	private static final String brackets="(){}";
	private static final String [] advanced= {"log(b, x)", "ln(x)","b^x", "e^x", "1/x"};

	public CalculatorPanel()
	{
		super();
		
		//dimensions of panel
		Dimension size = getPreferredSize();
		size.width = 250;
		setPreferredSize(size);
		
		setBorder(BorderFactory.createTitledBorder("Basic Calc"));
		
		//init buttons
		//numbers buttons
		JButton[] numbers = new JButton[10]; //0-9
		for (int i = 0; i< numbers.length; i++)
		{
			numbers[i] = new JButton(String.valueOf(i));
		}
		//operators buttons
		JButton[] operators = new JButton[ops.length()]; //operators
		for (int i = 0; i< operators.length; i++)
		{
			String op = Character.toString(ops.charAt(i));
			operators[i]= new JButton(op);
		}
		//grouping buttons
		JButton[] group = new JButton[brackets.length()];
		for (int i = 0; i< group.length; i++)
		{
			String g = Character.toString(brackets.charAt(i));
			group[i]= new JButton(g);
		}
		// log, ln, exp, e, inverse
		JButton[] advOps = new JButton[advanced.length];
		for (int i = 0; i< advOps.length; i++)
		{
			String a = advanced[i];
			advOps[i] = new JButton(a);
		}
		JButton clearBttn = new JButton("C"); //clear
		JButton equalsBttn = new JButton("="); //equals

		//implement functionality thru action listener
		clearBttn.addActionListener( 
		new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				fireClearEvent(new ClearEvent(this));	
			}
		});
		
		equalsBttn.addActionListener( 
		new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				fireEqualEvent(new EqualEvent(this));
			}
		});
		
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
		for (int j =1; j<=3; j++) //1-3
		{
			gc.gridx = j-1;
			gc.gridy = 0;
			add(numbers[j], gc);
		}
		for (int j =4; j<=6; j++)//4-6
		{
			gc.gridx = j-4;
			gc.gridy = 1;
			add(numbers[j], gc);
		}
		for (int j =7; j<=9; j++)//7-9
		{
			gc.gridx = j-7;
			gc.gridy = 2;
			add(numbers[j], gc);
		}
		
		//clear button
		gc.gridx= 0;
		gc.gridy= 3;
		add(clearBttn, gc);
		
		//0
		gc.gridx= 1;
		gc.gridy= 3;
		add(numbers[0], gc);
		
		//equals
		gc.gridx= 2;
		gc.gridy= 3;
		add(equalsBttn, gc);

		//operators
		for (int i = 0; i< operators.length; i++)
		{
			gc.gridx= 3;
			gc.gridy= i;
			add(operators[i], gc);
		}

		//grouping buttons
		for (int i = 0; i< group.length; i++)
		{
			gc.gridx= 4;
			gc.gridy= i;
			add(group[i], gc);
		}
		
		//advanced operations
		for (int i =0; i<advOps.length; i++)
		{
			gc.gridx= i;
			gc.gridy= 4;
			add(advOps[i], gc);
		}
		
	}//end of constructor
	
	public void fireCalcEvent(CalculatorEvent event)
	{
		Object [] listeners = listenerList.getListenerList();
		for (int i =0; i< listeners.length; i+=2)
		{
			if (listeners[i]==CalculatorListener.class)
			{
				((CalculatorListener)listeners[i+1]).calcEventOccurred(event);
			}
		}
	}
	public void fireClearEvent(ClearEvent event)
	{
		Object [] listeners = listenerList.getListenerList();
		for (int i =0; i< listeners.length; i+=2)
		{
			if (listeners[i]==CalculatorListener.class)
			{
				((CalculatorListener)listeners[i+1]).clearEventOccurred(event);
			}
		}
	}
	public void fireEqualEvent(EqualEvent event)
	{
		Object [] listeners = listenerList.getListenerList();
		for (int i =0; i< listeners.length; i+=2)
		{
			if (listeners[i]==CalculatorListener.class)
			{
				((CalculatorListener)listeners[i+1]).equalEventOccurred(event);
			}
		}
	}
	
	public void addCalcListener(CalculatorListener listener){listenerList.add(CalculatorListener.class, listener);}

}
