import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class CExam extends JFrame implements ActionListener {

	private JLabel l,l1;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    CExam(String s)  
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
        jb[0].setBounds(50,80,300,20);  
        jb[1].setBounds(50,110,300,20);  
        jb[2].setBounds(50,140,300,20);  
        jb[3].setBounds(50,170,300,20);  
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
            l.setText("Que1: Who is the father of C language?");  
            jb[0].setText("Steve Jobs");jb[1].setText("James Gosling");jb[2].setText("Dennis Ritchie");jb[3].setText("Rasmus Lerdorf");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Which of the following is not a valid C variable name?");  
            jb[0].setText("int number;");jb[1].setText("float rate;");jb[2].setText("int variable_count;");jb[3].setText("int $main;");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: All keywords in C are in ____________");  
            jb[0].setText("LowerCase letters");jb[1].setText("UpperCase letters");jb[2].setText("CamelCase letters");jb[3].setText("None of the mentioned");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Which is valid C expression?");  
            jb[0].setText("int my_num = 100,000;");jb[1].setText("int my_num = 100000;");jb[2].setText("int my num = 1000;");jb[3].setText("int $my_num = 10000;");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which of the following declaration is not supported by C language?");  
            jb[0].setText("String str;");jb[1].setText("char *str;");jb[2].setText("float str = 3e2;");jb[3].setText("Both a & c");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which keyword is used to prevent any changes in the variable within a C program?");  
            jb[0].setText("immutable");jb[1].setText("mutable");jb[2].setText("const");jb[3].setText("volatile");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: What is an example of iteration in C?");  
            jb[0].setText("for");jb[1].setText("while");jb[2].setText("do-while");  
                        jb[3].setText("all of the mentioned");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Which of the following is not an operator in C?");  
            jb[0].setText(",");jb[1].setText("sizeof()");jb[2].setText("~");  
                        jb[3].setText("None of the mentioned");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: C is a which level language.?");  
            jb[0].setText("Low");jb[1].setText("High");jb[2].setText("Low & High");jb[3].setText("None");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: C is _______ type of programming language.?");  
            jb[0].setText("Object Oriented");jb[1].setText("Procedural");jb[2].setText("Bit Level");  
                        jb[3].setText("Function");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==2)  
            return(jb[1].isSelected());  
        if(current==3)  
            return(jb[2].isSelected());  
        if(current==2)  
            return(jb[0].isSelected());  
        if(current==3)  
            return(jb[1].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[2].isSelected());  
        if(current==6)  
            return(jb[3].isSelected());  
        if(current==7)  
            return(jb[3].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[1].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new CExam("Online Exam of C");  
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
