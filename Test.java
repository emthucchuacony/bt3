package bt3;

import javax.swing.JFrame;

public class Test {
 public static void main(String[] args) {
	ClockTime clock = new ClockTime(45, 30, 2);
	
	
	DigitalClock digitalClock = new DigitalClock(clock);
	JFrame frame1 = new JFrame();
	frame1.setSize(300,100);
	
	frame1.setContentPane(digitalClock);
	frame1.setVisible(true);
	
	
	
	
	
	AnalogClock analogClock = new AnalogClock(clock);
	JFrame frame2 = new JFrame();
	frame2.setSize(300,300);
	frame2.setLocationRelativeTo(null);
	frame2.setContentPane(analogClock);
	frame2.setVisible(true);
	
	
	
;}

}
