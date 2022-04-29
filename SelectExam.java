import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class SelectExam extends JFrame {

	private JPanel contentPane;
	private JLabel l1,l2;
	private String[] options={"C","C++","Java","Python"};
	private JButton b1,b2,b3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectExam frame = new SelectExam("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public SelectExam(String prn_no) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setLocation(500,150);
		setContentPane(contentPane);
		l1=new JLabel("Hello there, "+prn_no+ " Welcome Again!");
		l2=new JLabel("Select Exam: ");
		JComboBox<String> c1 = new JComboBox<>(options);
		b1=new JButton("START EXAM");
		b2=new JButton("LOG OUT");
		b3=new JButton("UPDATE PROFILE");
		contentPane.add(l1);
		contentPane.add(l2);
		contentPane.add(c1);
		contentPane.add(b1);
		contentPane.add(b3);
		contentPane.add(b2);
		
		contentPane.setLayout(null);
	    l1.setBounds(45,10,220,30);
	    l2.setBounds(20, 50, 120, 25);
	    c1.setBounds(100,50,120,25);
	    b1.setBounds(10,100, 120, 25);	    
	    b2.setBounds(80,130, 120, 25);
	    b3.setBounds(140,100, 140, 25);
	    b2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				WelcomePage w=new WelcomePage("Welcome Again!");
				w.setVisible(true);
				dispose();
			}
	    	
	    });
	    b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String str=c1.getItemAt(c1.getSelectedIndex());
				if(str=="C"){
					CExam c=new CExam("Online Test Of C");
					c.setVisible(true);
					dispose();
				}else if(str=="C++"){
					CppExam c1=new CppExam("Online Exam of C++");
					c1.setVisible(true);
					dispose();
				}else if(str=="Java"){
					JavaExam j1=new JavaExam("Online Test Of Java");
					j1.setVisible(true);
					dispose();
				}else if(str=="Python"){
					PythonExam p1=new PythonExam("Online Exam of Python");
					p1.setVisible(true);
					dispose();
				}
			}
	    });
	    b3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateProfile up=new UpdateProfile(prn_no);
				up.setVisible(true);
				dispose();
			}
	    	
	    });
	}

}
