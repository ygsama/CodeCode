package DesignPattern.Proxy;

/**
 * 代理模式:
 * 		为另一个对象提供一个替身或者占位符用来控制对这个对象的访问
 * 		如监视器是远程监控的代理对象，而不是具体对象
 * 		静态代理:手动实现子类
 * 		RMI远程代理:远程代理对象
 * 		虚拟代理:代理先执行，直到大对象延迟创建后，再委托给大对象
 * 		Proxy动态代理:JDK提供的代理API，只能对接口代理
 * 		CGlib动态代理:通过字节码，用子类代理，方法为final时不能代理
 * 
 * @author ygsama
 *
 */
public class _Test {

	public static void main(String[] args) {
		int count = 0;

        if (args.length < 2) {
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        try {
        	count = Integer.parseInt(args[1]);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		GumballMachine gumballMachine = new GumballMachine(args[0], count);

		GumballMonitor monitor = new GumballMonitor(gumballMachine);

 
		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		monitor.report();
	}
}
