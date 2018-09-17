package de.rjs.TinySpike.Starter;

public interface ICollisionObservable {
	 void addCollObserver(ICollisionObserver observer);
	 void removeCollObserver(ICollisionObserver observer);
	 void notifyAllCollObservers();
}
