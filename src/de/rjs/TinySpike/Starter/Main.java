package de.rjs.TinySpike.Starter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Timer;

public class Main {

	public static void main(String[] args) {

		int delay = 250;
		//List to contain all graphic elements
		List<IGraphicRepresentable> graphicElements = new ArrayList<IGraphicRepresentable>();
        //some graphic elements
		Ball ball01, ball02;
		Block block01, block02;

		//instantiate graphic elements and add them to the list
		//balls
		ball01 = new Ball(100, 100, 50, Color.BLUE);
		graphicElements.add(ball01);
		ball02 = new Ball(375, 525, 25, Color.RED);
		graphicElements.add(ball02);
		//blocks
		block01 = new Block(50,50, 200, 25, Color.GREEN);
		graphicElements.add(block01);
		block02 = new Block(300,50, 200, 25, Color.CYAN);
		graphicElements.add(block02);

	    //preparing the graphic stuff needed
		TestFrame tf = new TestFrame ();
		DrawingPanel dp = new DrawingPanel(graphicElements);
		tf.setTitle("Mini graphic spike");
		tf.addWindowListener(new TestWindowListener());  //needed to terminate the app, when app window is closed
		tf.setSize(1000, 600);
		tf.setVisible(true); 
		tf.add(dp);
        //end preparing graphic environment
		
		RepaintController repCon = new RepaintController(dp);
		ball02.addObserver(repCon);
		
		//let the Blocks observe ball02
		ball02.addCollObserver(block01);
		ball02.addCollObserver(block02);
		
		//enterSomeThingToProceed();

		
		  Timer myTimer = new Timer(delay, ball02); //ball 02 listens to the timer event
		  myTimer.start();
        // Stopping the timer should be done at the end of the game.....
		//myTimer.stop();
	}

	private static void enterSomeThingToProceed() {
		System.out.println("Enter someting finished by pressing return key!");
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		//	System.out.println(a);

		sc.close();
	}
}
;