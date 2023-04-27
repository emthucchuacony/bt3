package bt3;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock  extends JPanel implements Observer{
	
	private ClockTime clock;
	private JLabel labelClock;
	

	public DigitalClock(ClockTime clock) {
		
		labelClock = new JLabel();
		this.clock = clock;
		add(labelClock);
		clock.addObs(this);
		update();
		
	}




	@Override
	public void update() {
			StringBuffer text = new StringBuffer();
			text.append(clock.getHour() + ":");
			if (clock.getMinute() < 10)
				text.append("0");
				text.append(clock.getMinute() + ":");
			if (clock.getSecond() < 10)
				text.append("0");
				text.append(clock.getSecond());
			labelClock.setText(text.toString());	
		
	}
	

}
