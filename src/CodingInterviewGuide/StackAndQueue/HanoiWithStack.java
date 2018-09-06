package CodingInterviewGuide.StackAndQueue;

import java.util.Stack;

/**
 * 用栈求解汉诺塔问题
 * 		要求1:不能从最左到最右，也不能从最右到最左,必须经过中间
 * 		要求2:当塔有N层的时候，打印最优移动过程和最优移动步数
 * 
 * @author ygsama
 *
 */
public class HanoiWithStack {

	static int hanoi1(int num, String left, String mid, String right){
		if (num<1){
			return 0;
		}
		return process(num,left,mid,right,left,right);
	}
	
	/**
	 * 递归
	 */
	static int process(int num, String left, String mid, String right,String from, String to){
		// 只剩最上层的塔需要移动
		if(num == 1){
			if(from.equals(mid)||to.equals(mid)){// 从左或右移到中
				System.out.println("Move 1 from " + from + " to " + to);
				return 1;
			}else{// 从左或右相互移动
				System.out.println("Move 1 from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				return 2;
			}
		}
		// 还剩下多层的塔，需要移动
		if(from.equals(mid)||to.equals(mid)){// 从左或右移到中
			String another = (from.equals(left)||to.equals(left)) ? right:left;
			int part1 = process(num-1, left, mid, right, from, another);
			int part2 = 1;
			System.out.println("Move " + num +" from " + from + " to " + to);
			int part3 = process(num-1, left, mid, right, another, to);
			return part1+part2+part3;
		}else{// 从左或右相互移动
			int part1 = process(num-1, left, mid, right, from, to);
			int part2 = 1;
			System.out.println("Move " + num +" from " + from + " to " + mid);
			int part3 = process(num-1, left, mid, right, to, from);
			int part4 = 1;
			System.out.println("Move " + num +" from " + mid + " to " + to);
			int part5 = process(num-1, left, mid, right, from, to);
			return part1+part2+part3+part4+part5;
		}
	}
	
	public static enum Action{
		NO,L2M,M2L,M2R,R2M
	}
	
	static int hanoi2(int num, String left, String mid, String right){
		Stack<Integer> ls = new Stack<Integer>();
		Stack<Integer> ms = new Stack<Integer>();
		Stack<Integer> rs = new Stack<Integer>();
		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);
		
		for(int i=num;i>0;i-- ){
			ls.push(i);
		}
		Action[] record = {Action.NO};
		int step = 0;
		/**
		 * 移动动作只有只有四种，L->M， M->L， M->R， R->M
		 * 当右塔为7时，移动结束
		 */
		while(rs.size()!=num +1){
			step += fStack2tStack(record, Action.M2L, Action.L2M, ls, ms, left, mid);
			step += fStack2tStack(record, Action.L2M, Action.M2L, ms, ls, mid, left);
			step += fStack2tStack(record, Action.R2M, Action.M2R, ms, rs, mid, right);
			step += fStack2tStack(record, Action.M2R, Action.R2M, rs, ms, right, mid);
		}
		return step;
	}

	/**
	 * 符合规则的移动返回1，不符合的返回0
	 */
	static int fStack2tStack(Action[] record, Action preNoAct,Action nowAct, 
			Stack<Integer> fs ,Stack<Integer> ts ,String from ,String to){
		// 1、相邻的塔不可以逆着移动回去 	2、小塔压大塔
		if(record[0]!=preNoAct && fs.peek()<ts.peek()){
			ts.push(fs.pop());
			System.out.println("Move "+ts.peek()+" from " + from + " to "+ to);
			record[0] = nowAct;
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		System.out.println(hanoi2(3, "left", "mid", "right"));
		System.out.println(hanoi1(3, "left", "mid", "right"));
	}
}
