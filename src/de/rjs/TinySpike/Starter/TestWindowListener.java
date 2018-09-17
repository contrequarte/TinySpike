package de.rjs.TinySpike.Starter;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindowListener extends WindowAdapter {

	public TestWindowListener() {
		// TODO Auto-generated constructor stub
	}
    public void windowClosing(WindowEvent e)
    {
      e.getWindow().dispose();                  
      System.exit(0);                            
    }  
}
