package application;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JOptionPane;

public class LoginOS extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	//icon
	ImageIcon icon = new ImageIcon("res/icon.png");
	//button
	private static JButton ok;
	//user
	private static JTextField user;
	private static JLabel Luser;
	//pass
	private static JPasswordField pass;
	private static JLabel Lpass;
	
	//background
	ImageIcon backgroundimg = new ImageIcon("res/background_login.png");
	JLabel background = new JLabel(backgroundimg);
	//font
	Font arial = new Font("Arial",Font.BOLD,15);
	
	public LoginOS(){
		setSize(540,360);
		setTitle("Login");
		setIconImage(icon.getImage());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(null);
		
		//button
		ok = new JButton("Ok");
		ok.setBounds(220,250,100,50);
		ok.addActionListener(this);
		ok.setFont(arial);
		add(ok);
		//user
		user = new JTextField();
		user.setBounds(165,150,200,30);
		user.setFont(arial);
		user.setDocument(new limitUser(7));
		add(user);
		Luser = new JLabel("Usuário:");
		Luser.setFont(arial);
		Luser.setBounds(100,140,150,50);
		add(Luser);
		//pass
		pass = new JPasswordField();
		pass.setBounds(165,200,200,30);
		pass.setDocument(new limitPass(8));
		add(pass);
		Lpass = new JLabel("Senha:");
		Lpass.setFont(arial);
		Lpass.setBounds(108,190,150,50);
		add(Lpass);
		
		//background
		background.setBounds(0,0,540,360);
		add(background);
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String userText = user.getText();
		@SuppressWarnings("deprecation")
		String passText = pass.getText();
		if(userText.equals("Matheus") && passText.equals("13501350")){
			new mainOS();
			setVisible(false);
			JOptionPane.showMessageDialog(null,"Logado com sucesso!","Sucesso!",1);
		}else{
			JOptionPane.showMessageDialog(null,"Usuário ou senha incorreto","Falha!",0);
		}
	}
	
	public static void main(String[] args){
		new LoginOS();
	}
}