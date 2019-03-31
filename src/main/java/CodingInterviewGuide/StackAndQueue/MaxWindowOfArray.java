package CodingInterviewGuide.StackAndQueue;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * 有整型数组arr和一个大小为w的窗口，窗口从数组左边滑到右边，每次滑一个位置
 * 
 * [4 3 5]4 3 3 6 7		=>最大值5
 *  4[3 5 4]3 3 6 7		=>最大值5
 *  4 3[5 4 3]3 6 7		=>最大值5
 *  4 3 5[4 3 3]6 7		=>最大值4
 *  4 3 5 4[3 3 6]7		=>最大值6
 *  4 3 5 4 3[3 6 7]	=>最大值7
 * @author ygsama
 *
 */
public class MaxWindowOfArray {

	
	static int[] getMaxWindow2(int[] arr, int w){
		return null;
	}
	
	
	/**
	 * 时间复杂度O(N)
	 */
	static int[] getMaxWindow(int[] arr, int w){
		if(arr==null || w<1 || arr.length<w){
			return null;
		}
		// 双端队列qmax作为窗口
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length - w +1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			// 放入规则,双端队列qmax窗口
			while(!qmax.isEmpty() && arr[qmax.peekLast()]<= arr[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			// 弹出规则,当对头下标等于i-w ，说明下标在窗口外，从窗口弹出
			if(qmax.peekFirst() == i - w){
				qmax.pollFirst();
			}
			// 取值规则,将双端队列的最左边的值取出，即为窗口最大值的下标
			if(i>=w-1){
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
}
