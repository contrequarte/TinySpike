package de.rjs.TinySpike.Starter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Ball extends BasicGraphicGameElement
                  implements IGraphicRepresentable, ActionListener, IRepaintObservable, ICollisionObservable
                  {
	
	List<IRepaintObserver> observerList;
	List<ICollisionObserver> collObserverList;
	
	public Ball(int xPos, int yPos, int size, Color color, Boolean visible)
	{
		super(xPos, yPos, size, size, color, visible);
        observerList = new ArrayList<IRepaintObserver>();
        collObserverList = new ArrayList<ICollisionObserver>();
	}

	public Ball(int xPos, int yPos, int size, Color color)
	{
		this(xPos, yPos, size, color, true);

	}
	
	public void move(int deltaX, int deltaY)
	{
		x += deltaX;
		y += deltaY;
	}
	@Override
	public void Repaint(Graphics g) {
		if (isVisible)
		{
	        g.setColor(objectColor);
	        g.fillOval(x, y, width, height);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Ball: Timer tick received!");
		if (y>50)
		{
			move(0,-10);
			notifyAllObservers();
			notifyAllCollObservers();
		}
	}

	@Override
	public void addObserver(IRepaintObserver observer) {
		if (!observerList.contains(observer))
		{
			observerList.add(observer);
			System.out.println("Ball: Observer added!");
		}
		
	}

	@Override
	public void removeObserver(IRepaintObserver observer) {
		if (observerList.contains(observer))
		{
			observerList.remove(observer);
			System.out.println("Ball: Observer removed!");
		}
		
	}

	@Override
	public void notifyAllObservers() {
		if (observerList.size()>0)
		   observerList.forEach(observer->observer.repaintNeeded());
	}

	@Override
	public void addCollObserver(ICollisionObserver observer) {
		if (!collObserverList.contains(observer))
		{
			collObserverList.add(observer);
			System.out.println("Ball: CollObserver added!");
		}
	}

	@Override
	public void removeCollObserver(ICollisionObserver observer) {
		if (collObserverList.contains(observer))
		{
			collObserverList.remove(observer);
			System.out.println("Ball: CollObserver removed!");
		}
	}

	@Override
	public void notifyAllCollObservers() {
		Rectangle rectToCheck = new Rectangle(x, y, width, height);
		if (collObserverList.size()>0)
			collObserverList.forEach(observer->{      
		                         if(observer.checkCollision(rectToCheck))
		                         { System.out.println("Seems as if I've hit a collisionObserver");}
			});
	}
}
