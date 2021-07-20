package application;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class makeOS extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	//icon
	ImageIcon icon = new ImageIcon("res/icon.png");
	//background
	ImageIcon backimg = new ImageIcon("res/background_criarOS.png");
	JLabel background = new JLabel(backimg);
	//back button
	ImageIcon button_backimg = new ImageIcon("res/back_arrow_m.png");
	JButton button_back = new JButton(button_backimg);
	//save button
	ImageIcon button_saveimg = new ImageIcon("res/save_button.png");
	JButton button_save = new JButton("Salvar",button_saveimg);
	//close button
	ImageIcon close_buttonimg = new ImageIcon("res/close_button.png");
	JButton close_button = new JButton(close_buttonimg);
	//font
	Font arial = new Font("Arial",Font.BOLD,15);
	//OsId
	JLabel OsId = new JLabel("Número de Os: ");
	public static JTextField OsT = new JTextField();
	//name
	JLabel name = new JLabel("Nome do cliente:");
	public static JTextField nameT = new JTextField();
	//description
	JLabel desc = new JLabel("Descrição:");
	public static JTextField descT = new JTextField();
	//imageIcons
	ImageIcon iconOS = new ImageIcon("res/icon_makeOS.png");
	ImageIcon enviadoOSi = new ImageIcon("res/button.png");
	ImageIcon aprovadoOSi = new ImageIcon("res/button3.png");
	ImageIcon recusadoOSi = new ImageIcon("res/button1.png");
	ImageIcon cortesiaOSi = new ImageIcon("res/button5.png");
	ImageIcon aguardandoOSi = new ImageIcon("res/button4.png");
	ImageIcon faturadoOSi = new ImageIcon("res/button3.png");
	//status
	JMenu status = new JMenu("Situação");
	JMenuBar menuStatus = new JMenuBar();
	JLabel situation = new JLabel("Situação:");
	public static JLabel statusText = new JLabel("");
	JLabel statusImg = new JLabel(iconOS);
	public static String OsStatus = "";
	
	//pré orçamento
	JMenuItem preOS = new JMenuItem("Pré Orçamento",iconOS);
	//enviado
	JMenuItem enviadoOS = new JMenuItem("Orçamento Enviado",enviadoOSi);
	//aprovado
	JMenuItem aprovadoOS = new JMenuItem("Aprovado",aprovadoOSi);
	//recusado
	JMenuItem recusadoOS = new JMenuItem("Recusado",recusadoOSi);
	//cortesia
	JMenuItem cortesiaOS = new JMenuItem("Cortesia",cortesiaOSi);
	//aguardando faturamento
	JMenuItem aguardandoOS = new JMenuItem("Aguardando Faturamento",aguardandoOSi);
	//faturado
	JMenuItem faturadoOS = new JMenuItem("Faturado",faturadoOSi);
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_back){
			setExtendedState(JFrame.ICONIFIED);
		}
		if(e.getSource()==preOS) {
			statusText.setText("Pré Orçamento");
			OsStatus = "7";
			statusImg.setIcon(iconOS);
		}
		if(e.getSource()==enviadoOS) {
			statusText.setText("Orçamento Enviado");
			OsStatus = "1";
			statusImg.setIcon(enviadoOSi);
		}
		if(e.getSource()==aprovadoOS) {
			statusText.setText("Orçamento Aprovado");
			OsStatus = "2";
			statusImg.setIcon(aprovadoOSi);
		}
		if(e.getSource()==recusadoOS) {
			statusText.setText("Orçamento Recusado");
			OsStatus = "3";
			statusText.setBounds(320,158,154,15);
			statusImg.setIcon(recusadoOSi);
		}
		if(e.getSource()==cortesiaOS) {
			statusText.setText("Cortesia");
			OsStatus = "4";
			statusImg.setIcon(cortesiaOSi);
		}
		if(e.getSource()==aguardandoOS) {
			statusText.setText("Aguardando Faturamento");
			OsStatus = "5";
			statusText.setBounds(320,158,180,15);
			statusImg.setIcon(aguardandoOSi);
		}
		if(e.getSource()==faturadoOS) {
			statusText.setText("Faturado");
			OsStatus = "6";
			statusImg.setIcon(faturadoOSi);
		}
		if(e.getSource()==button_save) {
			String id = OsT.getText();
			String name = nameT.getText();
			String desc = descT.getText();
			if(id != null && name != null && desc != null) {
				JOptionPane.showMessageDialog(null,"Fazer alterações?","Orçamento",1);
				OSwrite.main(null);
				insert.main(null);
				OsT.setText("");
				nameT.setText("");
				descT.setText("");
				setVisible(false);
			}
		}
		if(e.getSource()==close_button){
			int op1 = JOptionPane.showConfirmDialog(null,"Deseja mesmo fechar a janela?","Atenção!",0);
			
			if(op1 == JOptionPane.YES_OPTION){
				setVisible(false);
			}else{
				setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		}
	}
	
	public makeOS(){
		setSize(540,290);
		setTitle("Criar Orçamento");
		setResizable(false);
		setIconImage(icon.getImage());
		setLocationRelativeTo(null);
		setLayout(null);
		
		//OsId
		OsId.setBounds(86,76,150,12);
		OsId.setFont(arial);
		add(OsId);
		OsT.setBounds(195,73,170,20);
		OsT.setFont(arial);
		OsT.setDocument(new numbers());
		add(OsT);
		
		//name
		name.setBounds(73,130,150,12);
		name.setFont(arial);
		nameT.setBounds(195,127,170,20);
		nameT.setFont(arial);
		add(nameT);
		add(name);
		
		//description
		desc.setBounds(116,103,150,12);
		desc.setFont(arial);
		descT.setBounds(195,100,170,20);
		descT.setFont(arial);
		add(descT);
		add(desc);
		
		//status
		situation.setBounds(125,158,150,12);
		situation.setFont(arial);
		add(situation);
		menuStatus.setBounds(195,155,72,20);
		menuStatus.add(status);
		status.setFont(arial);
		//set font
		preOS.setFont(arial);
		preOS.addActionListener(this);
		enviadoOS.setFont(arial);
		enviadoOS.addActionListener(this);
		aprovadoOS.setFont(arial);
		aprovadoOS.addActionListener(this);
		recusadoOS.setFont(arial);
		recusadoOS.addActionListener(this);
		cortesiaOS.setFont(arial);
		cortesiaOS.addActionListener(this);
		aguardandoOS.setFont(arial);
		aguardandoOS.addActionListener(this);
		faturadoOS.setFont(arial);
		faturadoOS.addActionListener(this);
		//add
		status.add(preOS);
		status.add(enviadoOS);
		status.add(aprovadoOS);
		status.add(recusadoOS);
		status.add(cortesiaOS);
		status.add(aguardandoOS);
		status.add(faturadoOS);
		add(menuStatus);
		//status text
		statusText.setBounds(320,158,150,15);
		statusImg.setBounds(264,132,64,64);
		statusText.setFont(arial);
		add(statusText);
		add(statusImg);
		
		//button save
		button_save.setBounds(195,188,104,34);
		button_save.setFont(arial);
		button_save.addActionListener(this);
		add(button_save);
		
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
	
	public static void main(String[] args){
		new makeOS();
	}
}