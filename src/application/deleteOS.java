package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class deleteOS extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	//icon
	ImageIcon icon = new ImageIcon("res/icon.png");
	//background
	ImageIcon backimg = new ImageIcon("res/background_excluirOS.png");
	JLabel background = new JLabel(backimg);
	//back button
	ImageIcon button_backimg = new ImageIcon("res/back_arrow_m.png");
	JButton button_back = new JButton(button_backimg);
	//close button
	ImageIcon close_buttonimg = new ImageIcon("res/close_button.png");
	JButton close_button = new JButton(close_buttonimg);
	//delete button
	JButton button_delete = new JButton("Excluir",close_buttonimg);
	//OsId
	public static JTextField OsDelT = new JTextField();
	//font
	Font arial = new Font("Arial",Font.BOLD,15);
	
	public void write() {
		String path = "OS/OS.txt";
		BufferedWriter bw = null;
		try {
		FileWriter fw = new FileWriter(path);
		bw = new BufferedWriter(fw);
		String line = "";
		bw.write(line);
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_back) {
			setExtendedState(JFrame.ICONIFIED);
		}
		if(e.getSource()==button_delete) {
			OSdelete.main(null);
			File file = new File("OS/OS.txt");
			file.delete();
			write();
			setVisible(false);
		}
		if(e.getSource()==close_button) {
			int op1 = JOptionPane.showConfirmDialog(null,"Deseja mesmo fechar a janela?","Atenção!",0);
			
			if(op1 == JOptionPane.YES_OPTION) {
				setVisible(false);
			}else {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
	}
	
	public deleteOS() {
		setSize(540,280);
		setTitle("Criar Orçamento");
		setResizable(false);
		setIconImage(icon.getImage());
		setLocationRelativeTo(null);
		setLayout(null);
		
		//OsId
		OsDelT.setBounds(185,123,175,20);
		OsDelT.setFont(arial);
		OsDelT.setDocument(new numbers());
		add(OsDelT);
		
		//button delete
		button_delete.setBounds(210,150,128,64);
		button_delete.setFont(arial);
		button_delete.addActionListener(this);
		add(button_delete);
		
		//button back
		button_back.setBounds(450,50,64,64);
		button_back.addActionListener(this);
		add(button_back);
		
		//button close
		close_button.setBounds(10,50,64,64);
		close_button.addActionListener(this);
		add(close_button);
		
		//background
		background.setBounds(0,0,540,360);
		add(background);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new deleteOS();
	}
}
