package CodingInterviewGuide.StackAndQueue;

import java.util.Stack;

/** 使用递归函数和栈将一个栈逆序 
 * 一个栈压入1,2,3,4,5，将这个栈转置后，从栈顶到栈底为1,2,3,4,5，即为栈的逆序
 * 只能使用递归函数实现
 * 
 * @author ygsama
 *
 */
public class InverseStackWithRecursion {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		reverse(stack);
		System.out.println(stack);
		
	}
	
	public static int getAndRemoveLastElement(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty()){
			return result;
		}else{
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	public static void reverse(Stack<Integer> stack){
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}
}
