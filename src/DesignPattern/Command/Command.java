package DesignPattern.Command;

/**
 * 命令接口
 * 
 * @author ygsama
 *
 */
public interface Command {

	// 按下
	public void execute();
	// 撤销
	public void undo();
}
