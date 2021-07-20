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

public class mainOS extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//date
	Date date = new Date();
	SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
	String sps = sp.format(date);
	JLabel dateL = new JLabel(sps);
	//icon
	ImageIcon icon = new ImageIcon("res/icon.png");
	//background
	ImageIcon backimg = new ImageIcon("res/background.png");
	JLabel back = new JLabel(backimg);
	//font
	Font arial = new Font("Arial",Font.BOLD,15);
	Font arialBig = new Font("Arial",Font.BOLD,25);
	//produção button
	ImageIcon produçãoImg = new ImageIcon("res/icon_makeOS.png");
	JButton produção = new JButton("Produção",produçãoImg);
	//add button
	ImageIcon add_buttonimg = new ImageIcon("res/add_arrow.png");
	JButton button_add = new JButton("Adicionar Orçamento",add_buttonimg);
	//button
	ImageIcon close_buttonimg = new ImageIcon("res/close_button.png");
	ImageIcon button2img = new ImageIcon("res/button.png");
	ImageIcon button3img = new ImageIcon("res/button3.png");
	ImageIcon button4img = new ImageIcon("res/button1.png");
	ImageIcon button5img = new ImageIcon("res/button4.png");
	ImageIcon button6img = new ImageIcon("res/button5.png"); 
	
	JButton close_button = new JButton("Fechar",close_buttonimg);
	JButton button1 = new JButton("Orçamentos",produçãoImg);
	JButton button2 = new JButton("Orçamento Eviado",button2img);
	JButton button3 = new JButton("Aprovado",button3img); 
	JButton button4 = new JButton("Recusado",button4img);
	JButton button5 = new JButton("Cortesia",button6img);
	JButton button6 = new JButton("Aguardando Faturamento",button5img);
	JButton button7 = new JButton("Faturado",button3img);
	JButton button8 = new JButton("Pré Orçamento", produçãoImg);
	
	public mainOS() {
		setSize(1280,720);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Resumo");
		setResizable(false);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//date
		dateL.setBounds(1100,165,200,30);
		dateL.setFont(arialBig);
		add(dateL);
		
		//produção button
		produção.setBounds(512,14,256,64);
		produção.addActionListener(this);
		produção.setFont(arial);
		add(produção);
		
		//buttons
		button1.setBounds(545,535,200,50);
		button1.setFont(arial);
		button1.addActionListener(this);
		add(button1);
		
		button2.setBounds(545,435,200,50);
		button2.setFont(arial);
		button2.addActionListener(this);
		add(button2);
		
		button3.setBounds(795,435,200,50);
		button3.setFont(arial);
		button3.addActionListener(this);
		add(button3);
		
		button4.setBounds(545,335,200,50);
		button4.setFont(arial);
		button4.addActionListener(this);
		add(button4);
		
		button5.setBounds(295,435,200,50);
		button5.setFont(arial);
		button5.addActionListener(this);
		add(button5);
		
		button6.setBounds(295,335,200,50);
		button6.setFont(arial);
		button6.addActionListener(this);
		add(button6);
		
		button7.setBounds(795,335,200,50);
		button7.setFont(arial);
		button7.addActionListener(this);
		add(button7);
		
		button8.setBounds(545,235,200,50);
		button8.setFont(arial);
		button8.addActionListener(this);
		add(button8);
		
		//close button
		close_button.setBounds(1136,14,128,64);
		close_button.setFont(arial);
		close_button.addActionListener(this);
		add(close_button);
		
		//add button
		button_add.setBounds(515,625,256,64);
		button_add.setFont(arial);
		button_add.addActionListener(this);
		add(button_add);
		
		//background
		back.setBounds(0,0,1280,720);
		add(back);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_add) {
			new makeOS();
		}
		if(e.getSource()==button1) {
			new OsList();
			setVisible(false);
		}
		if(e.getSource()==button2) {
			new enviado();
			setVisible(false);
		}
		if(e.getSource()==button3) {
			new aprovado();
			setVisible(false);
		}
		if(e.getSource()==button4) {
			new recusado();
			setVisible(false);
		}
		if(e.getSource()==button5) {
			new cortesia();
			setVisible(false);
		}
		if(e.getSource()==button6) {
			new aguardandoF();
			setVisible(false);
		}
		if(e.getSource()==button7) {
			new faturado();
			setVisible(false);
		}
		if(e.getSource()==button8) {
			new preOS();
			setVisible(false);
		}
		
		if(e.getSource()==close_button) {
			int op1 = JOptionPane.showConfirmDialog(null,"Deseja mesmo fechar o programa?","Atenção!",0);
			
			if(op1 == JOptionPane.YES_OPTION) {
				System.exit(0);
			}else {
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
		if(e.getSource()==produção) {
			
		}
	}
	
	public static void main(String[] args) {
		new mainOS();
	}
}