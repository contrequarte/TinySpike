package de.rjs.TinySpike.Starter;

public interface IRepaintObservable {
	 void addObserver(IRepaintObserver observer);
	 void removeObserver(IRepaintObserver observer);
	 void notifyAllObservers();
}
