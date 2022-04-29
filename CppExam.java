import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;


public class CppExam extends JFrame implements ActionListener{

	private JLabel l,l1;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    CppExam(String s)  
    {  
        super(s);  
        l1=new JLabel();
        l=new JLabel(); 
        add(l1);
        add(l);  
        bg=new ButtonGroup();  
        l1.setBounds(250, 10, 100, 20);
        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int i = 600;
            public void run() {
                l1.setText("Time left: " + i);
                i--;
                if (i < 0) {
                    timer.cancel();
                    l1.setText("Time Over");
                    b1.setEnabled(false);
                } 
            }
        }, 0, 1000);
        for(int i=0;i<5;i++)  
        {  
            jb[i]=new JRadioButton();     
            add(jb[i]);  
            bg.add(jb[i]);  
        }  
        b1=new JButton("Next");  
        b2=new JButton("Bookmark"); 
        b3=new JButton("Show Result");
        b1.addActionListener(this);  
        b2.addActionListener(this);
        b3.addActionListener(this);
        add(b1);add(b2);add(b3);
        set();
        
        l.setBounds(30,40,450,20);  
        jb[0].setBounds(50,80,100,20);  
        jb[1].setBounds(50,110,100,20);  
        jb[2].setBounds(50,140,100,20);  
        jb[3].setBounds(50,170,100,20);  
        b1.setBounds(100,240,100,30);  
        b2.setBounds(270,240,100,30);
        b3.setBounds(440,240,120,30); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setLayout(null);  
        setLocation(400,150);  
        setVisible(true);  
        setSize(600,350);  
    }  
   
    void set()  
    {  
        jb[4].setSelected(true);  
        if(current==0)  
        {  
            l.setText("Que1: Who invented C++?");  
            jb[0].setText("Dennis Ritchie");jb[1].setText("Ken Thompson");jb[2].setText("Brian Kernighan");jb[3].setText("Bjarne Stroustrup");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: What is C++?");  
            jb[0].setText("C++ is an object oriented programming language");jb[1].setText("C++ is a procedural programming language");jb[2].setText("C++ supports both procedural and object oriented programming language");jb[3].setText("C++ is a functional programming language");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Which of the following is used for comments in C++?");  
            jb[0].setText("/* comment */");jb[1].setText("// comment */");jb[2].setText("// comment");jb[3].setText("both // comment or /* comment */");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Which of the following user-defined header file extension used in c++?");  
            jb[0].setText("hg");jb[1].setText("cpp");jb[2].setText("h");jb[3].setText("hf");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which of the following is not a type of Constructor in C++?");  
            jb[0].setText("Default constructor");jb[1].setText("Parameterized constructor");jb[2].setText("Copy constructor");jb[3].setText("Friend Constructor");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which of the following approach is used by C++?");  
            jb[0].setText("Left-right");jb[1].setText("Right-left");jb[2].setText("Bottom-up");jb[3].setText("Top-down");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which one among these is not a class? ");  
            jb[0].setText("Swing");jb[1].setText("Actionperformed");jb[2].setText("ActionEvent");  
                        jb[3].setText("Button");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Which of the following correctly declares an array in C++?");  
            jb[0].setText("array{10};");jb[1].setText("array array[10];");jb[2].setText("int array;");  
                        jb[3].setText("int array[10];");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: Which of the following is used to terminate the function declaration in C++?");  
            jb[0].setText(";");jb[1].setText("]");jb[2].setText(")");jb[3].setText(":");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: What is Inheritance in C++?");  
            jb[0].setText("Deriving new classes from existing classes");jb[1].setText("Overloading of classes");jb[2].setText("Classes with same names");  
                        jb[3].setText("Wrapping of data into a single class");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[3].isSelected());  
        if(current==1)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[3].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[3].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[0].isSelected());  
        if(current==9)  
            return(jb[0].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new CppExam("Online Exam of C++");  
    }
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1)  
        {  
            if(check())  
                count=count+1;  
            current++;  
            set();    
            if(current==9)  
            {  
                b1.setEnabled(false);  
                b2.setEnabled(false);
            }  
        }  
        if(e.getActionCommand().equals("Bookmark"))  
        {  
            JButton bk=new JButton("Bookmark"+x);  
            bk.setBounds(480,20+30*x,100,30);  
            add(bk);  
            bk.addActionListener(this);  
            m[x]=current;  
            x++;  
            current++;  
            set();    
            if(current==9)  
                b2.setText("Result");  
            setVisible(false);  
            setVisible(true);  
        }  
        for(int i=0,y=1;i<x;i++,y++)  
        {  
        if(e.getActionCommand().equals("Bookmark"+y))  
        {  
            if(check())  
                count=count+1;  
            now=current;  
            current=m[y];  
            set();  
            ((JButton)e.getSource()).setEnabled(false);  
            current=now;  
        }  
        }  
        
        if(e.getActionCommand().equals("Show Result"))  
        {  
        	if(check())  
                count=count+1;  
            current++;  
            //System.out.println("correct ans="+count);  
            int test = JOptionPane.showConfirmDialog(this, "Your Result: "+count, "Result", JOptionPane.OK_CANCEL_OPTION);
            switch(test) {
            case 0: SelectExam se = new SelectExam("");
                    se.setVisible(true);
                    this.dispose(); // Yes option
                    break;
            }  
        }
        
	}

}
