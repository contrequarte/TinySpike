package de.rjs.TinySpike.Starter;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.List;

public class DrawingPanel extends Panel /*implements ActionListener*/ {
	private static final long serialVersionUID = 1L; //to keep eclipse's warnings away
	private List<IGraphicRepresentable> gObjects;
	
	public DrawingPanel(List<IGraphicRepresentable> graphicObjects) {
		
		gObjects = graphicObjects;

	}

    public void paint(Graphics g)
    {
    	gObjects.forEach(item->item.Repaint(g));
    }
}
