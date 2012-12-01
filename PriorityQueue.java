import java.util.LinkedList;

public class PriorityQueue<T> {
	int max = 0;
	int priority = 0;
	LinkedList<PriorityNode<T>> queue = new LinkedList<PriorityNode<T>>();

	public PriorityQueue() {
	}

	public void enqueue(T node) {
		enqueue(node, priority++);
	}

	public void enqueue(T node, int value) {
		PriorityNode<T> n = new PriorityNode<T>(node, value);
		queue.add(n);

		if (value > this.max) {
			this.max = value;
		}
	}

	public T dequeue() {
		int min = this.max;
		PriorityNode<T> minNode = null;
		int index = 0;
		int minIndex = 0;

		for (PriorityNode<T> node : queue) {
			if (node.priority <= min) {
				minNode = node;
				min = node.priority;
				minIndex = index;
			}

			index++;
		}

		if (queue.size() == 0) {
			this.max = 0;
		}

		if (minNode != null) {
			queue.remove(minIndex);

			return minNode.elem;
		}

		return null;
	}

	public boolean hasElement(T checkNode) {
		for (PriorityNode<T> node : queue) {
			if (node.elem.equals(checkNode)) {
				return true;
			}
		}

		return false;
	}

	public void updatePriorityIfHigher(T updateNode, int value) {
		for (PriorityNode<T> node : queue) {
			if (node.elem.equals(updateNode)) {
				if (value < node.priority) {
					node.priority = value;
				}
			}
		}
	}

	public int size() {
		return queue.size();
	}

	public class PriorityNode<T> {
		T elem;
		int priority = 0;

		public PriorityNode(T elem, int priority) {
			this.elem = elem;
			this.priority = priority;
		}
	}
}