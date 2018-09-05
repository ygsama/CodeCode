package CodingInterviewGuide.StackAndQueue;

/**
 * 用栈求解汉诺塔问题
 * 		要求1:不能从最左到最右，也不能从最右到最左,必须经过中间
 * 		要求2:当塔有N层的时候，打印最优移动过程和最优移动步数
 * 
 * @author ygsama
 *
 */
public class HanoiWithStack {

	int hanoi1(int num, String left, String mid, String right){
		if (num<1){
			return 0;
		}
		
		return process(num,left,mid,right,left,right);
	}
	
	int process(int num, String left, String mid, String right,String from, String to){
		// 只剩最上层的塔需要移动
		if(num == 1){
			if(from.equals(mid)||to.equals(mid)){// 从左或右移到中
				System.out.println("Move 1 from " + from + " to " + to);
				return 1;
			}else{// 从左或右相互移动
				System.out.println("Move 1 from " + from + " to " + mid);
				System.out.println("Move 1 from " + mid + " to " + to);
				return 1;
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
	
	public static void main(String[] args) {
		
	}
}
