package DesignPattern.Command;

/**
 * 简单的控制器
 * 
 * @author ygsama
 *
 */
public class SimpleRemoteControl {

	Command slot;
	
	public SimpleRemoteControl() {
	}
	
	void setCommand(Command cmd){
		slot = cmd;
	}
	
	void buttonWasPressed(){
		slot.execute();
	}
}
