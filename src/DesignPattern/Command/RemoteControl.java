package DesignPattern.Command;

import javax.swing.plaf.SliderUI;

/**
 * 遥控器
 * 
 * @author ygsama
 *
 */
public class RemoteControl {

	Command[] onCmds;
	Command[] offCmds;
	
	public RemoteControl() {
		onCmds = new Command[7];
		offCmds = new Command[7];
	}
	
	void setCommand(int slot,Command onCmd,Command offCmd){
		onCmds[slot] = onCmd;
		offCmds[slot] = offCmd;
	}
	
	void onButtonWasPressed(int slot){
		onCmds[slot].execute();
	}
	void offButtonWasPressed(int slot){
		offCmds[slot].execute();
	}
}
