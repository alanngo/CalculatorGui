package design;

import event.CalculatorEvent;
import event.ClearEvent;
import event.EqualEvent;

import javax.swing.*;
import java.awt.*;

public class HelperPanel extends JPanel
{	//used for appending number buttons
    void addNumberButton(GridBagConstraints gc, int start, int end, int xOffset, int yOffset, JButton[] b)
    {
        for (int i = start; i <=end; i++)
        {
            gc.gridx = i - xOffset;
            gc.gridy = yOffset;
            add(b[i], gc);
        }
    }

    //used for appending clear, 0 and equals button
    void addButton(GridBagConstraints gc, int offset, JButton b)
    {
        gc.gridx= offset;
        gc.gridy= 3;
        add(b, gc);
    }

    //used for appending grouping and operator buttons
    void addButton(GridBagConstraints gc, int offset, JButton[] b)
    {
        for (int i = 0; i <b.length; i++)
        {
            gc.gridx = offset;
            gc.gridy = i;
            add(b[i], gc);
        }
    }

    //event actions
    void fireCalcEvent(CalculatorEvent event)
    {
        Object [] listeners = listenerList.getListenerList();
        for (int i =0; i< listeners.length; i+=2)
        {
            if (listeners[i]== CalculatorListener.class)
                ((CalculatorListener)listeners[i+1]).calcEventOccurred(event);
        }
    }

    void fireClearEvent(ClearEvent event)
    {
        Object [] listeners = listenerList.getListenerList();
        for (int i =0; i< listeners.length; i+=2)
        {
            if (listeners[i]== CalculatorListener.class)
                ((CalculatorListener)listeners[i+1]).clearEventOccurred(event);
        }
    }

    void fireEqualEvent(EqualEvent event)
    {
        Object [] listeners = listenerList.getListenerList();
        for (int i =0; i< listeners.length; i+=2)
        {
            if (listeners[i]== CalculatorListener.class)
                ((CalculatorListener)listeners[i+1]).equalEventOccurred(event);
        }
    }

    //handle listeners
    void addCalcListener(CalculatorListener listener){listenerList.add(CalculatorListener.class, listener);}

    //constructor
    HelperPanel(){super();}
}
