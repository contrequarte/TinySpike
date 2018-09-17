package de.rjs.TinySpike.Starter;

public class RepaintController implements IRepaintObserver {
    private DrawingPanel drawingPanel;
    
	public RepaintController(DrawingPanel dwgP)
	{
		drawingPanel = dwgP;
	}
	@Override
	public void repaintNeeded() {
		System.out.println("Repaint send!");	
		drawingPanel.repaint();

	}

}
