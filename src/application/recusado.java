package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class recusado extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//icon
	ImageIcon icon = new ImageIcon("res/icon.png");
	//background
	ImageIcon backgroundimg = new ImageIcon("res/background_recusado.png");
	JLabel background = new JLabel(backgroundimg);
	//date
	Date date = new Date();
	SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
	String sps = sp.format(date);
	JLabel dateL = new JLabel(sps);
	Font arialBig = new Font("Arial",Font.BOLD,25);
	//button
	ImageIcon button_backimg = new ImageIcon("res/back_arrow.png");
	JButton button_back = new JButton("Voltar",button_backimg);
	Font arial = new Font("Arial",Font.BOLD,15);
	//OsList
	JTextArea OsList = new JTextArea();
	JScrollPane OsPane = new JScrollPane(OsList);
	
	public String os() {
		Path path = Paths.get("OS/findRecusado.txt");
		String os = null;
		try {
			byte[] text = Files.readAllBytes(path);
			os = new String(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return os;
	}
	
	public recusado(){
		setSize(540,360);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Recusado");
		setResizable(false);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		findRecusado.main(null);
		
		//OsList
		String os = os();
		OsList.setText(os);
		OsList.setEditable(false);
		OsList.setFont(arial);
		OsPane.setBounds(100,250,1100,320);
		add(OsPane);
		
		//button back
		button_back.setBounds(1136,14,128,64);
		button_back.setFont(arial);
		button_back.addActionListener(this);
		add(button_back);
		
		//date
		dateL.setBounds(1100,165,200,30);
		dateL.setFont(arialBig);
		add(dateL);
		
		//background
		background.setBounds(0,0,1280,720);
		add(background);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		new mainOS();
		setVisible(false);
	}
	
	public static void main(String[] args){
		new recusado();
	}	
}
