package DesignPattern.Command;

/**
 * 命令模式:
 * 		将请求封装成对象，以便使用不同的请求、队列或日志来参数化其他对象，
 * 		也支持可撤销的操作，将请求调用者和请求接受者解耦
 * 		如，自定义绑定电器开关到遥控器上的不同按键
 * 
 * 队列请求:
 * 		Java的多线程Thread，也是是命令模式，工作队列一端添加任务，一端调用execute方法
 * 		
 * 日志请求:
 * 		将日志操作序列化到磁盘上，当系统宕机恢复时，依次的重新加载并execute
 * 		传统的分布式事务处理(2PC、3PC)在检查点check point处，将操作记录持久化，以便事务提交失败后进行回滚
 * 
 * @author ygsama
 *
 */
public class _Test {
  
	public static void main(String[] args) {
		
		Light light = new Light();
		Stereo stereo = new Stereo();
		
//		RemoteControl remote = new RemoteControl();
		RemoteControlWithUndo remote = new RemoteControlWithUndo();
		
		LightOnCommand lightOnCmd = new LightOnCommand(light);
		LightOffCommand lightOffCmd = new LightOffCommand(light);
		StereoOnWithCDCommand stereoOnCmd = new StereoOnWithCDCommand(stereo);
		StereoOffWithCDCommand stereoOffCmd = new StereoOffWithCDCommand(stereo);
		remote.setCommand(1,lightOnCmd,lightOffCmd);
		remote.setCommand(2,stereoOnCmd,stereoOffCmd);
		
		remote.onButtonWasPressed(1);
		remote.offButtonWasPressed(1);
		remote.undoButtonPushed();
		remote.onButtonWasPressed(2);
		remote.offButtonWasPressed(2);
		remote.undoButtonPushed();
	}
}
