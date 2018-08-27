package DesignPattern.Command;

/**
 * 命令执行器，将请求、队列或日志参数化
 * @author ygsama
 *
 */
public class StereoOffWithCDCommand implements Command {

	Stereo stereo;
	
	public StereoOffWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	@Override
	public void execute() {
		stereo.off();
		System.out.println(stereo.getClass().getName()+ " off");
	}

	@Override
	public void undo() {
		stereo.on();
		System.out.println(stereo.getClass().getName()+ " on");
	}
}
