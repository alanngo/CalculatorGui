package design;


import event.*;

import java.util.EventListener;

public interface CalculatorListener extends EventListener
{
	void calcEventOccurred(CalculatorEvent e);
	void clearEventOccurred(ClearEvent e);
	void equalEventOccurred(EqualEvent e);
}
