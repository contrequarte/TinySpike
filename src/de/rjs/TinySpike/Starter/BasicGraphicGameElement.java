package de.rjs.TinySpike.Starter;

import java.awt.Color;

public abstract class BasicGraphicGameElement implements IGraphicRepresentable {
	int x;
	int y;
	int width;
	int height;
	Color objectColor;
	Boolean isVisible;
	
	public BasicGraphicGameElement(int xPos, int yPos, int objectWidth, int objectHeight, Color color, Boolean visible)
	{
		x = xPos;
		y = yPos;
		width = objectWidth;
		height = objectHeight;
        objectColor = color;
        isVisible = visible;
	}

}
