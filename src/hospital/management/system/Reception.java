package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame
{
    Reception()
    {
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,1525,150);
        panel1.setBackground(new Color(198,198,198));
        add(panel1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/Dr.png"));
        Image i2=i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(1250,0,150,150);
        panel1.add(label);

        ImageIcon j1=new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image j2=j1.getImage().getScaledInstance(350,100,Image.SCALE_DEFAULT);
        ImageIcon j3=new ImageIcon(j2);
        JLabel label1=new JLabel(j3);
        label1.setBounds(900,50,350,100);
        panel1.add(label1);

        JButton btn1=new JButton("Add New Patient");
        btn1.setBounds(30,15,200,30);
        btn1.setBackground(Color.GRAY);
        btn1.setForeground(Color.WHITE);
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener()

        {
            public void actionPerformed(ActionEvent e)
            {
                new NewPatient();

            }
        });




        JButton btn2=new JButton("Room");
        btn2.setBounds(30,58,200,30);
        btn2.setBackground(Color.GRAY);
        btn2.setForeground(Color.WHITE);
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener()

        {
            public void actionPerformed(ActionEvent e)
            {
                new Room();
            }
        });


        JButton btn3=new JButton("Department");
        btn3.setBounds(30,100,200,30);
        btn3.setBackground(Color.GRAY);
        btn3.setForeground(Color.WHITE);
        panel1.add(btn3);;
        btn3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Department();
            }
        });


        JButton btn4=new JButton("All Employee Info");
        btn4.setBounds(270,15,200,30);
        btn4.setBackground(Color.GRAY);
        btn4.setForeground(Color.WHITE);
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Employee();
            }
        });


        JButton btn5=new JButton("Patient Info");
        btn5.setBounds(270,58,200,30);
        btn5.setBackground(Color.GRAY);
        btn5.setForeground(Color.WHITE);
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new PatientInfo();
            }
        });

        JButton btn6=new JButton("Patient Discharge");
        btn6.setBounds(270,100,200,30);
        btn6.setBackground(Color.GRAY);
        btn6.setForeground(Color.WHITE);
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Discharge();
            }
        });


        JButton btn7=new JButton("Update Patient Details");
        btn7.setBounds(510,15,200,30);
        btn7.setBackground(Color.GRAY);
        btn7.setForeground(Color.WHITE);
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new UpdatePatient();
            }
        });


        JButton btn8=new JButton("Hospital Ambulance");
        btn8.setBounds(510,58,200,30);
        btn8.setBackground(Color.GRAY);
        btn8.setForeground(Color.WHITE);
        panel1.add(btn8);
        btn8.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Ambulance();
            }
        });


        JButton btn9=new JButton("Search Room");
        btn9.setBounds(510,100,200,30);
        btn9.setBackground(Color.GRAY);
        btn9.setForeground(Color.WHITE);
        panel1.add(btn9);
        btn9.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new SearchRoom();
            }
        });



        JButton btn10=new JButton("Logout");
        btn10.setBounds(750,15,200,30);
        btn10.setBackground(Color.GRAY);
        btn10.setForeground(Color.WHITE);
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new Login();
            }
        });


        ImageIcon k1=new ImageIcon(ClassLoader.getSystemResource("icon/hospital2.png.png"));
        Image k2=k1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon k3=new ImageIcon(k2);
        JLabel k4=new JLabel(k3);
        k4.setBounds(350,0,700,700);
        panel.add(k4);

        setSize(1950,1090);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }


    public static void main(String[] args)
    {
        new Reception();
    }
}
