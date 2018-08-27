package DesignPattern.Command;

/**
 * 命令执行器，将请求、队列或日志参数化
 * @author ygsama
 *
 */
public class StereoOnWithCDCommand implements Command {

	Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	@Override
	public void execute() {
		stereo.on();
		System.out.println(stereo.getClass().getName()+ " on");
	}

	@Override
	public void undo() {
		stereo.off();
		System.out.println(stereo.getClass().getName()+ " off");
	}
}
