package application;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class checkList extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	//icon
	ImageIcon icon = new ImageIcon("res/icon.png");
	//background
	ImageIcon backgroundimg = new ImageIcon("res/background_checkList.png");
	JLabel background = new JLabel(backgroundimg);
	//button
	ImageIcon button_backimg = new ImageIcon("res/back_arrow.png");
	JButton button_back = new JButton("Voltar",button_backimg);
	JButton procurarImagem = new JButton("Adicionar imagem");
	JButton finalizado = new JButton("Finalizado");
	//font
	Font arial = new Font("Arial",Font.BOLD,15);
	//textField
	JTextField tf = new JTextField();
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	//label
	JLabel responsavel = new JLabel("Responsável pelo OS: ");
	JLabel obs = new JLabel("Observações: ");
	JLabel email = new JLabel("Email do cliente: ");
	JLabel imagem = new JLabel();
	//image
	byte[] image;
	String imagePath = "";
	ImageIcon myImage;
	//STRING
	public static String emailStr;
	public static String emailDoClienteStr;
	//IMAGE
	public static String path;
	
	public ImageIcon setIcon(String m, byte[] image) {
		if(m != null) {
			myImage = new ImageIcon(m);
		}else {
			myImage = new ImageIcon(image);
		}
		
		Image img = myImage.getImage();
		Image img1 = img.getScaledInstance(imagem.getWidth(), imagem.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon imageIcon = new ImageIcon(img1);
		return imageIcon;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_back) {
			setVisible(false);
		}
		if(e.getSource() == procurarImagem) {
			JFileChooser fc = new JFileChooser();
				
			fc.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "jpeg"));
			fc.setAcceptAllFileFilterUsed(false);
				
			int response = fc.showOpenDialog(null);
				
			if(response == JFileChooser.APPROVE_OPTION) {
				File f = fc.getSelectedFile();
				path = f.getAbsolutePath();
				imagem.setIcon(setIcon(path,null));
			}
		}
		if(e.getSource() == finalizado) {
			aguardeEmail.main(null);
			String responsavel = tf.getText();
			String observacoes = tf1.getText();
			emailStr = new String("Detalhes do orçamento\nResponsável: "+responsavel+"\nObservações: "+observacoes);
			emailDoClienteStr = tf2.getText();
			Email.main(null);
			setVisible(false);
		}
	}
	
	public checkList() {
		setSize(1280,720);
		setTitle("Check List");
		setExtendedState(MAXIMIZED_BOTH);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		
		//button
		button_back.setBounds(1136,14,128,64);
		button_back.setFont(arial);
		button_back.addActionListener(this);
		add(button_back);
		
		//responsavel
		responsavel.setBounds(545,215,200,25);
		responsavel.setFont(arial);
		add(responsavel);
		tf.setBounds(545,250,200,25);
		tf.setFont(arial);
		add(tf);
		
		//observações
		obs.setBounds(545,285,200,25);
		obs.setFont(arial);
		add(obs);
		tf1.setBounds(545,315,200,25);
		tf1.setFont(arial);
		add(tf1);
		
		//email
		email.setBounds(545,350,200,25);
		email.setFont(arial);
		add(email);
		tf2.setBounds(545,385,200,25);
		tf2.setFont(arial);
		add(tf2);

		//imagem
		procurarImagem.setBounds(545,440,200,25);
		procurarImagem.setFont(arial);
		procurarImagem.addActionListener(this);
		add(procurarImagem);
		imagem.setBounds(545,495,200,100);
		add(imagem);
		
		//finalizado
		finalizado.setBounds(545,640,200,25);
		finalizado.setFont(arial);
		finalizado.addActionListener(this);
		add(finalizado);
		
		//background
		background.setBounds(0,0,1280,720);
		add(background);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new checkList();
	}
}