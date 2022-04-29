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


public class PythonExam extends JFrame implements ActionListener {

	private JLabel l,l1;  
    JRadioButton jb[]=new JRadioButton[5];  
    JButton b1,b2,b3;  
    ButtonGroup bg;  
    int count=0,current=0,x=1,y=1,now=0;  
    int m[]=new int[10];      
    PythonExam(String s)  
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
            l.setText("Que1: Who developed Python Programming Language?");  
            jb[0].setText("Wick van Rossum");jb[1].setText("Rasmus Lerdorf");jb[2].setText("Guido van Rossum");jb[3].setText("Niene Stom");   
        }  
        if(current==1)  
        {  
            l.setText("Que2: Which type of Programming does Python support?");  
            jb[0].setText("object-oriented programming");jb[1].setText("structured programming");jb[2].setText("functional programming");jb[3].setText("all of the mentioned");  
        }  
        if(current==2)  
        {  
            l.setText("Que3: Is Python case sensitive when dealing with identifiers?");  
            jb[0].setText("no");jb[1].setText("yes");jb[2].setText("machine dependent");jb[3].setText("none");  
        }  
        if(current==3)  
        {  
            l.setText("Que4: Which of the following is the correct extension of the Python file?");  
            jb[0].setText(".python");jb[1].setText(".pl");jb[2].setText(".py");jb[3].setText(".p");  
        }  
        if(current==4)  
        {  
            l.setText("Que5: Which of the following is used to define a block of code in Python language?");  
            jb[0].setText("Indentation");jb[1].setText("Key");jb[2].setText("Brackets");jb[3].setText("All of the mentioned");  
        }  
        if(current==5)  
        {  
            l.setText("Que6: Which keyword is used for function in Python language?");  
            jb[0].setText("Function");jb[1].setText("Def");jb[2].setText("Fun");jb[3].setText("Define");  
        }  
        if(current==6)  
        {  
            l.setText("Que7: Which of the following character is used to give single-line comments in Python?");  
            jb[0].setText("//");jb[1].setText("#");jb[2].setText("!");  
                        jb[3].setText("/*");  
        }  
        if(current==7)  
        {  
            l.setText("Que8: Which of the following is the truncation division operator in Python?");  
            jb[0].setText("|");jb[1].setText("//");jb[2].setText("/");  
                        jb[3].setText("%");         
        }  
        if(current==8)  
        {  
            l.setText("Que9: What arithmetic operators cannot be used with strings in Python?");  
            jb[0].setText("*");jb[1].setText("-");jb[2].setText("+");jb[3].setText("All of the mentioned");  
        }  
        if(current==9)  
        {  
            l.setText("Que10: Which of the following is not a core data type in Python programming?");  
            jb[0].setText("Tuples");jb[1].setText("Lists");jb[2].setText("Class");  
                        jb[3].setText("Dictionary");  
        }  
        l.setBounds(30,40,450,20);  
        for(int i=0,j=0;i<=90;i+=30,j++)  
            jb[j].setBounds(50,80+i,200,20);  
    }  
    boolean check()  
    {  
        if(current==0)  
            return(jb[2].isSelected());  
        if(current==1)  
            return(jb[3].isSelected());  
        if(current==2)  
            return(jb[0].isSelected());  
        if(current==3)  
            return(jb[2].isSelected());  
        if(current==4)  
            return(jb[0].isSelected());  
        if(current==5)  
            return(jb[1].isSelected());  
        if(current==6)  
            return(jb[1].isSelected());  
        if(current==7)  
            return(jb[1].isSelected());  
        if(current==8)  
            return(jb[1].isSelected());  
        if(current==9)  
            return(jb[2].isSelected());  
        return false;  
    }  
    public static void main(String s[])  
    {  
        new PythonExam("Online Exam of Python");  
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
