package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class preOS extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	//icon
	ImageIcon icon = new ImageIcon("res/icon.png");
	//background
	ImageIcon backgroundimg = new ImageIcon("res/background_preOs.png");
	JLabel background = new JLabel(backgroundimg);
	//button
	ImageIcon button_backimg = new ImageIcon("res/back_arrow.png");
	JButton button_back = new JButton("Voltar",button_backimg);
	//add button
	ImageIcon add_buttonimg = new ImageIcon("res/add_arrow.png");
	JButton button_check = new JButton("Check List",add_buttonimg);
	JButton button_add = new JButton("Adicionar Orçamento",add_buttonimg);
	//delete button
	ImageIcon delete_buttonimg = new ImageIcon("res/close_button.png");
	JButton button_delete = new JButton("Excluir Orçamento",delete_buttonimg);
	//reload button
	ImageIcon reloadImg = new ImageIcon("res/recarregar_button.png");
	JButton reload = new JButton("Recarregar", reloadImg);
	//OsList
	JTextArea OsList = new JTextArea();
	JScrollPane OsPane = new JScrollPane(OsList);
	//font
	Font arial = new Font("Arial",Font.BOLD,15);
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_back) {
			new mainOS();
			setVisible(false);
		}
		if(e.getSource()==button_delete) {
			new deleteOS();
		}
		if(e.getSource()==button_add) {
			new makeOS();
		}
		if(e.getSource()==reload) {
			new preOS();
		}
		if(e.getSource() == button_check) {
			new checkList();
		}
	}
	
	public String os() {
		Path path = Paths.get("OS/findPreOS.txt");
		String os = null;
		try {
			byte[] text = Files.readAllBytes(path);
			os = new String(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return os;
	}
	
	public preOS() {
		setSize(540,360);
		setTitle("Pré Orçamento");
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		findPreOS.main(null);
		
		//OsList
		String os = os();
		OsList.setText(os);
		OsList.setEditable(false);
		OsList.setFont(arial);
		OsPane.setBounds(100,250,1100,320);
		add(OsPane);
		
		//button
		button_back.setBounds(1136,14,128,64);
		button_back.setFont(arial);
		button_back.addActionListener(this);
		add(button_back);
		
		button_check.setBounds(100,625,192,64);
		button_check.setFont(arial);
		button_check.addActionListener(this);
		add(button_check);
		
		button_delete.setBounds(524,625,192,64);
		button_delete.setFont(arial);
		button_delete.addActionListener(this);
		add(button_delete);
		
		button_add.setBounds(312,625,192,64);
		button_add.setFont(arial);
		button_add.addActionListener(this);
		add(button_add);
		
		reload.setBounds(736,625,192,64);
		reload.setFont(arial);
		reload.addActionListener(this);
		add(reload);
		
		//background
		background.setBounds(0,0,1280,720);
		add(background);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new preOS();
	}
}
