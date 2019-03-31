package DesignPattern.Command;

/**
 * 命令执行器，将请求、队列或日志参数化
 * @author ygsama
 *
 */
public class LightOffCommand implements Command {

	Light light;
	
	public LightOffCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.off();
		System.out.println(light.getClass().getName()+ " off");
	}

	@Override
	public void undo() {
		light.on();
		System.out.println(light.getClass().getName()+ " on");
	}
}
