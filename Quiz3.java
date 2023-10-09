
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Quiz3 extends JFrame implements ActionListener
{
    
    String[] que={  "Who is known as Father of Computer?",
                    "Who invented Java Programming?",
                    "In which Country Sun rises first?",
                   
                   
                   
                   
                };

    String[][] options={ 
                           {"Pascal","Hollerith","Newman","Charles Babbage"},
                           {"Guido van Rossum","James Gosling","Dennis Ritchie","Bjarne Stroustrup"},
                           {"USA","Canada","India","Japan"},

                       };

    char[] answer=     {
                          'D',
                          'B',
                          'D'
                          

                       };

    char guess,answers;
    int index=0,correct_guess=0;
    int total_questions=que.length;
    int result;
    int sec=15;
    JButton b1,b2,b3,b4;
    JTextField t1,number_right,per,time,time_label;//Question and Result(Title)
    JTextArea a1;//To display Question
    JLabel l1,l2,l3,l4;
    Timer timer=new Timer(700,new ActionListener()
     {
            @Override
            public void actionPerformed(ActionEvent e)
            {

              sec--;
              time.setText(String.valueOf(sec));
              if(sec<=0)
              {
                  display();
              }
            }
      });
     
    Quiz3()
    {
       setBounds(200,60,1100,575);
      getContentPane().setBackground(Color.GRAY);
      setResizable(false);
      setLayout(null);
      t1=new JTextField("Quiz");
      t1.setBounds(0,0,1100,50);
      t1.setForeground(new Color(25,25,25));
      t1.setBackground(new Color(192,192,192));
      t1.setEditable(false);
      t1.setFont(new Font("Bahnschrift",Font.BOLD,20));
      t1.setHorizontalAlignment(JTextField.CENTER);
      add(t1);

//Questions
      a1=new JTextArea();
      a1.setLineWrap(true);
      a1.setWrapStyleWord(true);
      a1.setBounds(0,50,1100,40);
      a1.setForeground(new Color(25,25,25));
      a1.setBackground(new Color(192,192,192));
      a1.setBorder(BorderFactory.createBevelBorder(1));
      a1.setFont(new Font("Bahnschrift",Font.BOLD,20));
      //a1.setHorizontalAlignment(JTextArea.CENTER);
      a1.setEditable(false);
      add(a1);


//Buttons
      b1=new JButton("A");
      b1.setBounds(50,130,100,100);
      b1.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
      b1.setBackground(new Color(192,192,192));
      b1.setFocusable(false);
      b1.addActionListener(this);
      add(b1);
      
      b2=new JButton("B");
      b2.setBounds(50,230,100,100);
      b2.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
      b2.setBackground(new Color(192,192,192));
      b2.setFocusable(false);
      b2.addActionListener(this);
      add(b2);
      
      b3=new JButton("C");
      b3.setBounds(50,330,100,100);
      b3.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
      b3.setBackground(new Color(192,192,192));
      b3.setFocusable(false);
      b3.addActionListener(this);
      add(b3);
      
      b4=new JButton("D");
      b4.setBounds(50,430,100,100);
      b4.setFont(new Font("Mongolian Baiti",Font.BOLD,20));
      b4.setBackground(new Color(192,192,192));
      b4.setFocusable(false);
      b4.addActionListener(this);
      add(b4);


//Options




      l1=new JLabel();
      l1.setBounds(200,130,300,100);
      l1.setFont(new Font("Bahnschrift",Font.BOLD,15));
      l1.setForeground(new Color(25,25,25));
      add(l1);


      l2=new JLabel();
      l2.setBounds(200,230,300,100);
      l2.setFont(new Font("Bahnschrift",Font.BOLD,15));
      l2.setForeground(new Color(25,25,25));
      add(l2);


      l3=new JLabel();
      l3.setBounds(200,330,300,100);
      l3.setFont(new Font("Bahnschrift",Font.BOLD,15));
      l3.setForeground(new Color(25,25,25));
      add(l3);

      l4=new JLabel();
      l4.setBounds(200,430,300,100);
      l4.setFont(new Font("Bahnschrift",Font.BOLD,15));
      l4.setForeground(new Color(25,25,25));
      add(l4);


//Timer

      time=new JTextField();//Seconds_left
      time.setBounds(950,450,50,50);
      time.setForeground(new Color(255,0,0));
      time.setOpaque(true);
      time.setHorizontalAlignment(JTextField.CENTER);
      time.setBackground(new Color(192,192,192));
      time.setFont(new Font("Bahnschrift",Font.BOLD,20));
      time.setText(String.valueOf(sec));
      add(time);


      time_label=new JTextField();
      time_label.setBounds(950,415,50,35);
      time_label.setBackground(new Color(192,192,192));
      time_label.setForeground(new Color(255,0,0));
      time_label.setEditable(false);
      time_label.setFont(new Font("Bahnschrift",Font.BOLD,20));
      time_label.setHorizontalAlignment(JTextField.CENTER);
      time_label.setText("Timer");
      add(time_label);


      number_right=new JTextField();
      number_right.setBounds(500,200,200,100);
      number_right.setBackground(new Color(25,25,25));
      number_right.setForeground(new Color(255,255,255));
      number_right.setHorizontalAlignment(JTextField.CENTER);
      number_right.setFont(new Font("Bahnschrift",Font.BOLD,20));
      number_right.setEditable(false);
      


      per=new JTextField();
      per.setBounds(500,300,200,100);
      per.setBackground(new Color(25,25,25));
      per.setForeground(new Color(255,255,255));
      per.setHorizontalAlignment(JTextField.CENTER);
      per.setFont(new Font("Bahnschrift",Font.BOLD,20));
      per.setEditable(false);
      


    }
   public void nextQue()
    {
      if(index>=total_questions)
      {
            results();

      }
      else
      {
            t1.setText("Question "+(index+1));//For Question Number
            a1.setText(que[index]);//Questions
            l1.setText(options[index][0]);//ans_label
            l2.setText(options[index][1]);
            l3.setText(options[index][2]);
            l4.setText(options[index][3]);
            timer.start();



      }

    }
    public void actionPerformed(ActionEvent e)
    {
      b1.setEnabled(false);
      b2.setEnabled(false);
      b3.setEnabled(false);
      b4.setEnabled(false);

      if(e.getSource()==b1)
      {
            answers= 'A';
            if(answers== answer[index])
            {
                  correct_guess++;
            }
      }
      if(e.getSource()==b2)
      {
            answers= 'B';
            if(answers== answer[index])
            {
                  correct_guess++;
            }
      }
      if(e.getSource()==b3)
      {
            answers= 'C';
            if(answers== answer[index])
            {
                  correct_guess++;
            }
      }
       if(e.getSource()==b4)
      {
            answers= 'D';
            if(answers== answer[index])
            {
                  correct_guess++;
            }
      }
      
     display();
    }
      public void display()
    {
      timer.stop();
       b1.setEnabled(false);
      b2.setEnabled(false);
      b3.setEnabled(false);
      b4.setEnabled(false);
      if(answer[index]!='A')
      {
            l1.setForeground(new Color(255,0,0));
      }
       if(answer[index]!='B')
      {
            l2.setForeground(new Color(255,0,0));
      }
       if(answer[index]!='C')
      {
            l3.setForeground(new Color(255,0,0));
      }
       if(answer[index]!='D')
      {
            l4.setForeground(new Color(255,0,0));
      }

      Timer pause=new Timer(2000,new ActionListener()
      {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               l1.setForeground(new Color(25,255,0));  
               l2.setForeground(new Color(25,255,0));  
               l3.setForeground(new Color(25,255,0));  
               l4.setForeground(new Color(25,255,0));   

               answers=' ';
               sec=15;
               time.setText(String.valueOf(sec));//convert to string
               b1.setEnabled(true);
               b2.setEnabled(true);
               b3.setEnabled(true);
               b4.setEnabled(true);
               index++;
               nextQue();

            }
      });
      pause.setRepeats(false);
      pause.start();

    }
    public void results()
    {
      b1.setEnabled(false);
      b2.setEnabled(false);
      b3.setEnabled(false);
      b4.setEnabled(false);


      result=(int)(correct_guess/(double)total_questions*100);
      t1.setText("Results");
      a1.setText("");
      l1.setText(" ");
      l2.setText(" ");
      l3.setText(" ");
      l4.setText(" ");
     
      number_right.setText("("+correct_guess+"/"+total_questions+")");
      per.setText(result+"%");
      add(per);
      add(number_right);
      
      

    }
    public static void main(String[] args)
    {
       Quiz3 q3=new Quiz3();
       //q3.setVisible(true);
       q3.nextQue();
       //q3.setBounds(200,60,1100,575);
       //System.out.println("Hi");
       q3.setVisible(true);
    }
}