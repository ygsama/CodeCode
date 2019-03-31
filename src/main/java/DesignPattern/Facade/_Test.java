package DesignPattern.Facade;

/**
 * 外观模式:
 * 		提供了一个统一的接口，用来访问子系统中的一群接口。
 * 		通过一个高层接口，让子系统更简单使用
 * 设计原则:
 * 		最少知识原则，只和你的密友谈话
 *		即,减少更多的依赖，避免系统过于复杂
 * 
 * @author ygsama
 *
 */
public class _Test {

	public static void main(String[] args) {
		Amplifier amp = new Amplifier("Top-O-Line Amplifier");
		Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
		DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
		CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
		Projector projector = new Projector("Top-O-Line Projector", dvd);
		TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
		Screen screen = new Screen("Theater Screen");
		PopcornPopper popper = new PopcornPopper("Popcorn Popper");
 
		HomeTheaterFacade homeTheater = 
				new HomeTheaterFacade(amp, tuner, dvd, cd, 
						projector, screen, lights, popper);
 
		homeTheater.watchMovie("Raiders of the Lost Ark");
		homeTheater.endMovie();
	}
}
