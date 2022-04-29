import java.awt.*;

import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WelcomePage extends JFrame {

	private JPanel contentPane;
	private JLabel l1,l2,l3;
	private JButton b1,b2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage("Welcome");
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
	public WelcomePage(String s) {
		super(s);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,350);
		setLocation(500,150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		l1=new JLabel("Welcome to the Online Exam Portal!");
	    b1 = new JButton("REGISTER");
	    b2=new JButton("LOGIN");
	    b2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Login l=new Login("Login");
				l.setVisible(true);
				dispose();
	    	}
	    });
	    contentPane.add(l1);
		contentPane.add(b1);
		contentPane.add(b2);
		contentPane.setLayout(null);
		
	    l1.setBounds(45,40,220,30);
	    b1.setBounds(20, 100, 120, 25);
	    b2.setBounds(150, 100, 120, 25);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration r=new Registration("Registration");
				r.setVisible(true);
				dispose();
			}
		});
		
	}

}
