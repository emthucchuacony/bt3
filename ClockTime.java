package bt3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

public class ClockTime {
	private Timer timer;
	private int second;
	private int minute;
	private int hour;
	private List<Observer> observers = new ArrayList<Observer>();
	
	
	
	
	
	
	public ClockTime(int second, int minute, int hour) {
		super();
		this.second = second;
		this.minute = minute;
		this.hour = hour;
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				tick();
				
			}
		});
		timer.start();
		
	}
	public int getSecond() {
		return second;
	}
	public int getMinute() {
		return minute;
	}
	public int getHour() {
		return hour;
	}
	public void addObs(Observer obs) {
		this.observers.add(obs);
		
	}
	public void removeObs(Observer obs) {
		this.observers.remove(obs);
	}
	public void notifyObs() {
		for (Observer obs : observers) {
			obs.update();
		}
	}
	public void tick() {
		second++;
		if ((second %= 60)== 0)
			minute++;
		if ((minute %= 60) ==0) 
			hour++;
			hour %= 24 ;
			
	}
}
