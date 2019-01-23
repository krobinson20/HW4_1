import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class dice implements Runnable {
	private int value=0;
	private JLabel _label;
	public dice(JLabel label)
	{
		_label = label;
	}
	
	/**
	 * funcion to make the dice "roll"
	 * calls a function that returns the side of the dice to set the jlabel to and then makes the thread sleep
	 */
	public void run() {
		for (int i=0; i<25;i++)
		{
			ImageIcon img = diceside();
			_label .setIcon(img);
				try {
					Thread.sleep(100);
				}
				catch(InterruptedException ex) {;}
			}
		}
	
	/**
	 * funcion that has all of the images in an array
	 * it generates a random number between 1 and 6 and then returns the corresponding image for the 
	 * side of the dice that has been rolled
	 * @return
	 */
public ImageIcon diceside() {
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	URL[] url = {getClass().getResource("/resources/1side.png"),getClass().getResource("/resources/2side.png"),getClass().getResource("/resources/3side.png"),getClass().getResource("/resources/4side.png"),getClass().getResource("/resources/5side.png"),getClass().getResource("/resources/6side.png")};
	
	Random rnd = new Random();
	value = rnd.nextInt(6);
	int next = value;
	Image img = toolkit.getImage(url[next]);
	img = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
	return new ImageIcon(img);

}
}
