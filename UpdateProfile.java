import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class UpdateProfile extends JFrame {

	private JPanel contentPane;
	private JLabel l1,l2,l3,l4,l5;
	private JTextArea t1,t2,t3,t4;
	private JButton b1,b2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProfile frame = new UpdateProfile("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public UpdateProfile(String prn_no) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setLocation(500,150);
		setContentPane(contentPane);
		l1=new JLabel("Hello there, Update Your Profile Here!");
		l2=new JLabel("First Name: ");
		l3=new JLabel("Last Name: ");
		l4=new JLabel("PRN No.: ");
		t1=new JTextArea(10,40);
		t2=new JTextArea(10,40);
		t3=new JTextArea(10,40);
		l5=new JLabel("Password: ");
		t4=new JTextArea(10,40);
		b1=new JButton("UPDATE");
		b2=new JButton("BACK");
		contentPane.add(l1);
		contentPane.add(l2);
		contentPane.add(l3);
		contentPane.add(l4);
		contentPane.add(l5);
		contentPane.add(t4);
		contentPane.add(t1);
		contentPane.add(t2);
		contentPane.add(t3);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.setLayout(null);
		l1.setBounds(45,10,220,30);
		l2.setBounds(20, 50, 120, 25);
	    t1.setBounds(100,50, 150, 25);
	    l3.setBounds(20, 100,120 , 25);
	    t2.setBounds(100, 100, 150, 25);
	    l4.setBounds(20,150,120,25);
	    t3.setBounds(100,150,150,25);
	    l5.setBounds(20,200,120,25);
	    t4.setBounds(100,200,150,25);
	    b1.setBounds(20,250,100,25);
	    b2.setBounds(150,250,100,25);
	    try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/onlineexam_oasis","root","");
			Statement st = con.createStatement();
			String query="SELECT f_name,l_name,prn_no,password FROM login Where prn_no='"+prn_no+"'";
			ResultSet rs=st.executeQuery(query);
			if(rs.next())
			{
				t1.setText(rs.getString("f_name"));
				t2.setText(rs.getString("l_name"));
				t3.setText(rs.getString("prn_no"));
				t4.setText(rs.getString("password"));
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please Enter Valid Username/Password");
			}
	    }catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String f_name=t1.getText();
				String l_name=t2.getText();
				String prn_no=t3.getText().toString();
				String password=t4.getText().toString();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/onlineexam_oasis","root","");
					Statement st=con.createStatement();
					int b1=st.executeUpdate("update login set f_name='"+f_name+"' where prn_no='"+prn_no+"'");	
					int b2=st.executeUpdate("update login set l_name='"+l_name+"' where prn_no='"+prn_no+"'");
					int b3=st.executeUpdate("update login set prn_no='"+prn_no+"' where prn_no='"+prn_no+"'");
					int b4=st.executeUpdate("update login set password='"+password+"' where prn_no='"+prn_no+"'");
					WelcomePage w=new WelcomePage("Welcome Again!");
					JOptionPane.showMessageDialog(w, "Updation Successful!");				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	    b2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				SelectExam se=new SelectExam(prn_no);
				se.setVisible(true);
				dispose();
			}
	    	
	    });
	}
}
