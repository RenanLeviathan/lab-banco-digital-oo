package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class Splash {
	private static final int SPLASH_WIDTH = 300;
	private static final int SPLASH_HEIGHT = 200;
	private static final String SPLASH_IMG_PATH = "/images/tela_splash.jpg";
	private static final long TEMPO_SPLASH = 1000;
	private static JWindow splash;
	
	public Splash() {
		splash = new JWindow();
		splash.getContentPane().add(
				new JLabel("",new ImageIcon(getClass().getResource(SPLASH_IMG_PATH)), SwingConstants.CENTER)
				);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension dim = toolkit.getScreenSize();
		
		splash.setBounds(
				(dim.width - SPLASH_WIDTH) / 2, 
				(dim.height - SPLASH_HEIGHT) / 2, 
				SPLASH_WIDTH, 
				SPLASH_HEIGHT
				);
		splash.setVisible(true);
		try {
			Thread.sleep(TEMPO_SPLASH);
		}catch(InterruptedException e) {
			
		}
		splash.dispose();
	}
}
