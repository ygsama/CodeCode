package DesignPattern.State;

public interface State {
 
	/**
	 * 投币
	 */
	public void insertQuarter();
	
	/**
	 * 退钱
	 */
	public void ejectQuarter();
	/**
	 * 转动把手
	 */
	public void turnCrank();
	/**
	 * 出货
	 */
	public void dispense();
}
