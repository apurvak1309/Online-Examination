import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Login extends JFrame {
	private JPanel contentPane;
	private JLabel l1,l2,l3;
	private JTextField t1;
	private JPasswordField t2;
	private JButton b1,b2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login("");
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
	public Login(String s) {
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		setLocation(500,150);
		l1=new JLabel("Hello There, Welcome Back!");
		l2=new JLabel("Enter PRN Number: ");
		l3=new JLabel("Enter Password: ");
		t1=new JTextField(13);
		t2=new JPasswordField(10);
		b1=new JButton("LOGIN");
		b2=new JButton("BACK");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomePage w=new WelcomePage("");
				w.setVisible(true);
				dispose();
			}
		});
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/onlineexam_oasis","root","");
					String prn_no=t1.getText().toString();
					String pass=t2.getText().toString();
					String query="SELECT prn_no,password FROM login WHERE prn_no=? AND password=?";
					PreparedStatement st=con.prepareStatement(query);
					st.setString(1, prn_no);
					st.setString(2, pass);
					ResultSet rs=st.executeQuery();
					if(rs.next())
					{
						SelectExam s=new SelectExam(prn_no);
						s.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Please Enter Valid Username/Password");
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
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.setLayout(null);
	    l1.setBounds(45,40,220,30);
	    l2.setBounds(20, 100, 120, 25);
	    t1.setBounds(150, 100, 120, 25);
	    l3.setBounds(20, 150,120 , 25);
	    t2.setBounds(150, 150, 120, 25);
	    b1.setBounds(80,200,120,25);
	    b2.setBounds(80,230,120,25);
	}

}
