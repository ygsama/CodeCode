package DesignPattern.Observer;

/**
 * 主题接口
 * @author ygsama
 *
 */
public interface Subject {

	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();

}
