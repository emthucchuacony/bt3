package bt3;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JPanel;

public class AnalogClock  extends JPanel {
	private static final int MARGIN = 5; 
	private static final Color HAND_COLOR = Color.black; //  2 KIM
	private static final Color SWEEP_COLOR = Color.red; // KIM GIAY
	private static final Color FACE_COLOR = Color.WHITE;
	private static final Color FRAME_COLOR = Color.BLACK;
	private static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;
	private ClockTime clock;
	private Point center;
	private int diameter;
	private int secondHandLength;
	private int minuteHandLength;
	private int hourHandLength;
	private int hourRange = 12;
	
	
	
	
 	public AnalogClock(ClockTime clock) {
		
		this.clock = clock;
		
	}




	
	protected void paintComponent(Graphics g) {
		
		
		diameter = Math.min(getWidth() - (2 * MARGIN), getHeight() - (2 * MARGIN)); // tinh toan d
		center = new Point((diameter / 2) + MARGIN, (diameter / 2) + MARGIN); // tinh toan tam
      hourHandLength = (int) (diameter * 0.30); // tinh chieu dai kim h
      minuteHandLength = (int) (diameter * 0.45);// phut 
      secondHandLength = (int) (diameter * 0.45); // giay
      g.setColor(BACKGROUND_COLOR); // set color cho nền
      g.fillRect(0, 0, getWidth(), getHeight()); //  ve hinh chu nhat
      g.setColor(FACE_COLOR); // set color cho mat dong ho
      g.fillOval(MARGIN, MARGIN, diameter, diameter); // ve hinh oval cho khung
      g.setColor(FRAME_COLOR); // set color cho khung
      g.drawOval(MARGIN, MARGIN, diameter, diameter); // ve hinh oval cho face
      int hour = clock.getHour();
      hour = hour > hourRange ? hour - hourRange : hour;
      drawClockHand(g, HAND_COLOR, hourHandLength, hour, hourRange);
      drawClockHand(g, HAND_COLOR, minuteHandLength, clock.getMinute(), 60);
      drawClockHand(g, SWEEP_COLOR, secondHandLength, clock.getSecond(), 60);

	}

	protected void drawClockHand(Graphics g, Color color, int length, int value, int range) {
		// được sử dụng để vẽ một kim đồng hồ với màu color, độ dài length, giá trị
		// value và phạm vi range. Phương thức này tính toán vị trí của đầu kim bằng
		// cách sử dụng phương thức calculateHandTip() và vẽ đường thẳng từ tâm đồng hồ
		// đến đầu kim bằng phương thức g.drawLine().
		Point tip = calculateHandTip(center.x, center.y, length, value, range);
		g.setColor(color);
		g.drawLine(center.x, center.y, tip.x, tip.y);
	}

	protected Point calculateHandTip(int x, int y, int length, int value, int range) { //

		// được sử dụng để tính toán vị trí của đầu kim dựa trên vị trí của tâm đồng hồ,
		// độ dài của kim, giá trị của kim và phạm vi của kim. Phương thức này tính toán
		// góc quay của kim dựa trên giá trị của kim và phạm vi, sau đó tính toán vị trí
		// của đầu kim bằng cách sử dụng công thức toán học. Kết quả được trả về dưới
		// dạng một đối tượng Point chứa tọa độ của đầu kim.
		double angle = (Math.PI * (((value * 360) / range) - 90)) / 180;
		return new Point(x + (int) (length * Math.cos(angle)), y + (int) (length * Math.sin(angle)));
	}
	
	
	

}
