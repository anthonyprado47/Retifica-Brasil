package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class produçãoOS extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//date
	Date date = new Date();
	SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
	String sps = sp.format(date);
	JLabel dateL = new JLabel(sps);
	//font
	Font arial = new Font("Arial",Font.BOLD,15);
	Font arialBig = new Font("Arial",Font.BOLD,25);
	//icon
	ImageIcon icon = new ImageIcon("res/icon.png");
	//background
	ImageIcon backimg = new ImageIcon("res/background_produção.png");
	JLabel back = new JLabel(backimg);
	//menu button
	ImageIcon resumoImg = new ImageIcon("res/icon_makeOS.png");
	JButton resumo = new JButton("Resumo",resumoImg);
	//button
	ImageIcon close_buttonimg = new ImageIcon("res/close_button.png");
	JButton close_button = new JButton("Fechar",close_buttonimg);
	ImageIcon button1img = new ImageIcon("res/icon_makeOS.png");
	JButton button1 = new JButton("Usinagem",button1img);
	ImageIcon button2img = new ImageIcon("res/icon_makeOS.png");
	JButton button2 = new JButton("Teste",button2img);
	ImageIcon button3img = new ImageIcon("res/icon_makeOS.png");
	JButton button3 = new JButton("Montagem",button3img);
	ImageIcon button4img = new ImageIcon("res/button3.png");
	JButton button4 = new JButton("Finalizado",button4img);
	ImageIcon button5img = new ImageIcon("res/icon_makeOS.png");
	JButton button5 = new JButton("Dinamômetro",button5img);
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resumo) {
			new mainOS();
			setVisible(false);
		}
		if(e.getSource()==close_button) {
			int op1 = JOptionPane.showConfirmDialog(null,"Deseja mesmo fechar o programa?","Atenção!",0);
			
			if(op1 == JOptionPane.YES_OPTION){
				System.exit(0);
			}else{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
	}
	
	public produçãoOS(){
		setSize(640,360);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Produção");
		setResizable(false);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//date
		dateL.setBounds(1100,165,200,30);
		dateL.setFont(arialBig);
		add(dateL);
		
		//menu button
		resumo.setBounds(512,14,256,64);
		resumo.setFont(arial);
		resumo.addActionListener(this);
		add(resumo);
		
		//buttons
		button1.setBounds(300,250,200,50);
		button1.setFont(arial);
		add(button1);
		button2.setBounds(550,250,200,50);
		button2.setFont(arial);
		add(button2);
		button3.setBounds(800,250,200,50);
		button3.setFont(arial);
		add(button3);
		button4.setBounds(550,350,200,50);
		button4.setFont(arial);
		add(button4);
		button5.setBounds(300,350,200,50);
		button5.setFont(arial);
		add(button5);
		
		//close button
		close_button.setBounds(1136,14,128,64);
		close_button.setFont(arial);
		close_button.addActionListener(this);
		add(close_button);
		
		//background
		back.setBounds(0,0,1280,720);
		add(back);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new produçãoOS();
	}
}
