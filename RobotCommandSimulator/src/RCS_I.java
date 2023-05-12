//Created by Michael Beall

public interface RCS_I<T> {
	// interface containing some basic queueing functions
	void enQueue(T addToQ);
	T deQueue();
	T peek();
	void print();
}
