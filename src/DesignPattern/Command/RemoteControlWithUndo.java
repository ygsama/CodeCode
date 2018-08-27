package DesignPattern.Command;

/**
 * 遥控器
 * 
 * @author ygsama
 *
 */
public class RemoteControlWithUndo {

	Command[] onCmds;
	Command[] offCmds;
	Command undoCmd;
	
	public RemoteControlWithUndo() {
		onCmds = new Command[7];
		offCmds = new Command[7];
	}
	
	void setCommand(int slot,Command onCmd,Command offCmd){
		onCmds[slot] = onCmd;
		offCmds[slot] = offCmd;
	}
	
	void onButtonWasPressed(int slot){
		onCmds[slot].execute();
		undoCmd = onCmds[slot];
	}
	void offButtonWasPressed(int slot){
		offCmds[slot].execute();
		undoCmd = offCmds[slot];
	}
	// 撤销按钮
	void undoButtonPushed(){
		undoCmd.undo();
	}
}
