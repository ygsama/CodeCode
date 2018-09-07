package CodingInterviewGuide.StackAndQueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 * 		栈内存放整型数据，从顶到底按 大->小排序
 * 
 * @author ygsama
 *
 */
public class SortStackByStack {

	static void sortStack(Stack<Integer> stack){
		Stack<Integer> help = new Stack<Integer>();
		
		while(!stack.isEmpty()){
			int tmp = stack.pop();
			while(!help.isEmpty() && help.peek()<tmp){
				stack.push(help.pop());
			}
			help.push(tmp);
		}
		
		while(!help.isEmpty()){
			stack.push(help.pop());
		}
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(10);
		stack.push(21);
		stack.push(15);
		stack.push(41);
		stack.push(18);
		stack.push(91);
		sortStack(stack);
		System.out.println(stack);
		
	}
}
