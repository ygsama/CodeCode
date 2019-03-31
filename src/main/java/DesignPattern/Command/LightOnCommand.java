package DesignPattern.Command;

/**
 * 命令执行器，将请求、队列或日志参数化
 * @author ygsama
 *
 */
public class LightOnCommand implements Command {

	Light light;
	
	public LightOnCommand(Light light) {
		this.light = light;
	}
	
	@Override
	public void execute() {
		light.on();
		System.out.println(light.getClass().getName() + " on");
	}

	@Override
	public void undo() {
		light.off();
		System.out.println(light.getClass().getName() + " off");
	}
}
