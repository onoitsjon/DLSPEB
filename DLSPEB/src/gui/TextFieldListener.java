package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author - Kashif Qureshi
 */

public class TextFieldListener 
{
	private static JTextField loops;
	private static JFrame f;
	private static boolean numeric = false;
	
	static class WL implements WindowListener 
	{
		private Component component;
	    WL(Component component) {
	        this.component = component;
	    }

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent arg0) {
			TextFieldListener.hidden();
			
		}

		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private static void hidden()
	{
		GUI.windowClosed();
	}
	
  static class ShowPopupActionListener implements ActionListener {
    private Component component;
    ShowPopupActionListener(Component component) {
      this.component = component;
    }

    public synchronized void actionPerformed(ActionEvent actionEvent) 
    {
    	String text = loops.getText();
    	text.trim();
    	try
    	{
    		Integer number = new Integer(text);
    		numeric = true;
    	}
    	catch(NumberFormatException NFE)
    	{
    		System.out.println("Not a valid number");
    	}
    	
    	if(numeric && text.compareTo("") != 0)
    	{
    		GUI.assist(loops.getText(), true);
    		f.setVisible(false);
    	}
    }
  }

  public static void main(final String args[]) {
    f = new JFrame("");
    Container a = f.getContentPane();

    WindowListener www = new WL(f);
    ActionListener actionListener = new ShowPopupActionListener(f);

    JButton start = new JButton("Repeat this many times");
    start.addActionListener(actionListener);
    start.setMnemonic(KeyEvent.VK_R);
    
    loops = new JTextField();
    a.add(loops);

    a.add(start, BorderLayout.PAGE_END);
    a.add(loops, BorderLayout.PAGE_START);
    
    f.addWindowListener(www);
    f.setSize(300, 85);
    f.setVisible(true);
  }
}
