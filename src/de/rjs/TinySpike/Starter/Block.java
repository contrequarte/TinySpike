package de.rjs.TinySpike.Starter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends BasicGraphicGameElement implements ICollisionObserver {
	
	public Block(int xPos, int yPos, int blockWidth, int blockHeight, Color color, Boolean visible)
	{
		super(xPos, yPos, blockWidth, blockHeight, color, visible);	
	}
	
	public Block(int xPos, int yPos, int blockWidth, int blockHeight, Color color)
	{
		this(xPos, yPos, blockWidth, blockHeight, color, true);	
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
			g.fillRect(x, y, width, height);
		}
	}

	@Override
	public Boolean checkCollision(Rectangle rectToCheck) {
		if (isVisible)
		{
			Rectangle myRect = new Rectangle(x, y, width, height);
			if (myRect.intersects(rectToCheck))
			{
				System.out.println("Block: Seems as if I've been hit by something, I'll disappear");
				isVisible = false;
				return true;
			}
			else
			{
				System.out.println("Block: I'm not hit at all");
				return false;
			}
		}
		return false;
	}
}
