package CodingInterviewGuide.StackAndQueue;

import java.util.Stack;

/**		用两个栈实现一个队列
 * 编写一个类，用两个栈实现队列，支持队列的基本操作(add、poll、peek)
 * 栈是是先进后出，队列是先进先出，两个栈可以把顺序反过来
 * 
 * 1、当第一次push时，只需将stackPush的数据按顺序push到stackPop里，再stackPop.pop出数据
 * 2、当两个栈都有数据时，需要原子性的将StackPop的数据放入Temp暂存，
 * 		再依次将stackPush和stackTemp数据push进stackPop中
 * 
 * @author ygsama
 *
 */
public class QueueOf2Stack {

	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;
	private Stack<Integer> stackTemp;
	
	public QueueOf2Stack(){
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();
		this.stackTemp = new Stack<Integer>();
	}
	
	public void add(int item){
		stackPush.push(item);
	}
	
	public int poll(){
		checkEmpty();
		return stackPop.pop();
	}

	private synchronized void checkEmpty() {
		if(stackPop.empty() && stackPush.empty()){
			throw new RuntimeException("Queue is empty");
		}else if(!stackPop.empty() && !stackPush.empty()){
			while (!stackPop.empty()) {
				stackTemp.push(stackPop.pop());
			}
		}
		if(stackPop.empty()){
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
			while (!stackTemp.empty()) {
				stackPop.push(stackTemp.pop());
			}
		}
	}
	
	public int peek(){
		checkEmpty();
		return stackPop.peek();
	}
	
	public static void main(String[] args) {
		QueueOf2Stack queue = new QueueOf2Stack();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		queue.add(4);
		queue.add(5);
		queue.add(6);
		System.out.println("");
		while (!queue.stackPop.empty()) {
			System.out.println(queue.poll());
		}
	}
}
