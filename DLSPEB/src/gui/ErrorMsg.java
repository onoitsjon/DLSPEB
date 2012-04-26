package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * @author - Kashif Qureshi
 */

public class ErrorMsg
{
	private static JFrame f;
	
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
			ErrorMsg.hidden();
			
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
    	String AE = actionEvent.getActionCommand();
    	if(AE.compareTo("Ok") == 0)
    	{
    		GUI.windowClosed();
    		f.setVisible(false);
    	}
    }
  }

  public static void main(final String args[]) {
    f = new JFrame("");
    Container a = f.getContentPane();

    ActionListener actionListener = new ShowPopupActionListener(f);
    WindowListener www = new WL(f);

    JLabel c = new JLabel(args[0]);
    
    JButton use = new JButton("Ok");
    use.addActionListener(actionListener);

    a.add(c, BorderLayout.PAGE_START);
    a.add(use, BorderLayout.PAGE_END);
    
    f.addWindowListener(www);
    f.setSize(300, 85);
    f.setVisible(true);
  }
}
