import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Registration extends JFrame {

	private JPanel contentPane;
	private JLabel l1,l2,l3,l4,l5,l6;
	private JTextField t1,t2,t3;
	private JPasswordField t4,t5;
	private JButton b1,b2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration(String s) {
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		setLocation(500,150);
		l1=new JLabel("Hello There, Welcome to the System!");
		l2=new JLabel("Enter First Name:");
		l3=new JLabel("Enter Last Name:");
		l4=new JLabel("Enter PRN Number:");
		l5=new JLabel("Enter Password:");
		l6=new JLabel("Confirm Password:");
		t1=new JTextField(10);
		t2=new JTextField(10);
		t3=new JTextField(10);
		t4=new JPasswordField(10);
		t5=new JPasswordField(10);
		b1=new JButton("REGISTER");
		b2=new JButton("BACK");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage w=new WelcomePage("Welcome Again!");
				w.setVisible(true);
				dispose();
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String f_name=t1.getText();
				String l_name=t2.getText();
				String prn_no=t3.getText().toString();
				String pass=t4.getText().toString();
				String pass1=t5.getText().toString();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/onlineexam_oasis","root","");
					Statement st=con.createStatement();
					String query="SELECT prn_no FROM login";
					ResultSet rs=st.executeQuery(query);
					if(rs.next()){
						if(prn_no.equals(rs.getString("prn_no"))){
							WelcomePage w2=new WelcomePage("Welcome Again!");
							JOptionPane.showMessageDialog(w2, "PRN Number already exists!");
						}else{
							if(pass.equalsIgnoreCase(pass1)){
								int b=st.executeUpdate("Insert into login(f_name,l_name,prn_no,password) values('"+f_name+"','"+l_name+"','"+prn_no+"','"+pass+"')");
								WelcomePage w=new WelcomePage("Welcome Again!");
								JOptionPane.showMessageDialog(w, "Registration Successful!");
							}else{
								WelcomePage w1=new WelcomePage("Welcome Again!");
								JOptionPane.showMessageDialog(w1, "Password & Confirm Password does not match!");
							}
						}
					}
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		contentPane.add(l1);
		contentPane.add(l2);
		contentPane.add(t1);
		contentPane.add(l3);
		contentPane.add(t2);
		contentPane.add(l4);
		contentPane.add(t3);
		contentPane.add(l5);
		contentPane.add(t4);
		contentPane.add(l6);
		contentPane.add(t5);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.setLayout(null);
	    l1.setBounds(45,10,220,30);
	    l2.setBounds(20, 50, 120, 25);
	    t1.setBounds(150, 50, 120, 25);
	    l3.setBounds(20, 80,120 , 25);
	    t2.setBounds(150, 80, 120, 25);
	    l4.setBounds(20, 110,120 , 25);
	    t3.setBounds(150, 110, 120, 25);
	    l5.setBounds(20, 140,120 , 25);
	    t4.setBounds(150, 140, 120, 25);
	    l6.setBounds(20, 170,120 , 25);
	    t5.setBounds(150, 170, 120, 25);
	    b1.setBounds(80, 200, 120, 25);
	    b2.setBounds(80, 230, 120, 25);
	}

}
