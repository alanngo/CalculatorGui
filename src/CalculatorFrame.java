import java.awt.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private CalculatorPanel panel;
	private JTextArea area;
	
	public CalculatorFrame(String name)
	{
		super(name);
		
		//set layout manager
		setLayout(new BorderLayout());
		
		//create swing components
		area = new JTextArea();
		panel = new CalculatorPanel();
		
		//add listener
		panel.addCalcListener(
		new CalculatorListener()
		{
			@Override
			public void calcEventOccured(CalculatorEvent event) {area.append(event.getText());}

			@Override
			public void clearEventOccured(ClearEvent e) {area.setText(null);}

			@Override
			public void equalEventOccured(EqualEvent e) 
			{
				//does computation
				String text = area.getText();
				
				// no text
				if (text==null||text.length()==0) {throw new NullPointerException("CANNOT COMPUTE ON EMPTY TEXT");}
				
				//other regular cases
				else{area.append("\n="+Double.toString(Calculator.compute(text))+"\n");}	
			}	
		});

		//add swing components to content pane
		Container c = getContentPane();
		
		c.add(area, BorderLayout.CENTER);
		c.add(panel, BorderLayout.WEST);
		
	}//end of constructor
}//end of class
