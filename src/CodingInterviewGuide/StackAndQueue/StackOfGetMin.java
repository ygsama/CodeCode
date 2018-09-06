package CodingInterviewGuide.StackAndQueue;

import java.util.Stack;

/**	实现一个能够getMin()的栈 
 * 设计一个特殊的栈，字啊其基本功能之上，再实现返回栈的最小元素操作
 * 
 * 1. pop、push、getMin操作的时间复杂度为O(1)
 * 2. 设计的栈类型可以使用现成出的栈结构
 * 
 * 方案一:同步压入弹出，保持栈长相等；
 * 		优缺点：压入费时间，弹出省时间
 * 方案二:新数据<=最小值时压入，相等时弹出最小值
 * 		优缺点：压入省时间，弹出费时间，占用内存空间略大
 * 
 * @author ygsama
 * 
 */
public class StackOfGetMin {
	
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	
	public StackOfGetMin() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}
	
	public void push(int newNum){
		if(stackMin.isEmpty()){
			stackMin.push(newNum);
		}else if(newNum <= getMin()){
			stackMin.push(newNum);
		}
		stackData.push(newNum);
	}
	
	public int pop(){
		if(stackData.isEmpty()){
			throw new RuntimeException("stack is empty");
		}
		int re = stackData.pop();
		if(re == getMin()){
			stackMin.pop();
		}
		return re;
	}
	
	public int getMin(){
		if(stackMin.isEmpty()){
			throw new RuntimeException("stack is empty");
		}
		return stackMin.peek();
	}
}
