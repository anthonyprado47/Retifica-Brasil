package application;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class aguardeEmail {
	
	//DECLARE OBJ
	static ImageIcon icon = new ImageIcon("res/icon.png");
	static ImageIcon backgroundImg = new ImageIcon("res/email_background.png");
	static JLabel background = new JLabel(backgroundImg);
	
	public static JFrame frame;
	
	public static void aguardeEmailFrame() {
		
		frame = new JFrame();
		
		frame.setSize(400,200);
		frame.setTitle("Aguarde");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(icon.getImage());
		frame.setLayout(null);
		
		background.setBounds(0,0,400,200);
		frame.add(background);
		
		frame.setVisible(true);
	}
	
	public static void close() {
		frame.setVisible(false);
	}
	
	public static void main(String[] args) {
		aguardeEmailFrame();
	}
}