package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
public class PatientInfo extends JFrame
{
    PatientInfo()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        add(panel);


        JTable table=new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(Color.GRAY);
        table.setForeground(Color.WHITE);
        table.setFont(new Font("italic",Font.BOLD,14));
        panel.add(table);


        try
        {
            Conn c=new Conn();
            String q="select * from patient_info";
            ResultSet rs=c.stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        JLabel label1=new JLabel("ID");
        label1.setBounds(31,11,100,14);
        label1.setForeground(Color.BLACK);
        label1.setFont(new Font("italic",Font.BOLD,16));
        panel.add(label1);

        JLabel label2=new JLabel("Number");
        label2.setBounds(130,11,100,14);
        label2.setForeground(Color.BLACK);
        label2.setFont(new Font("italic",Font.BOLD,16));
        panel.add(label2);


        JLabel label3=new JLabel("Name");
        label3.setBounds(250,11,100,14);
        label3.setForeground(Color.BLACK);
        label3.setFont(new Font("italic",Font.BOLD,16));
        panel.add(label3);

        JLabel label4=new JLabel("Gender");
        label4.setBounds(360,11,100,14);
        label4.setForeground(Color.BLACK);
        label4.setFont(new Font("italic",Font.BOLD,16));
        panel.add(label4);

        JLabel label5=new JLabel("Disease");
        label5.setBounds(465,11,100,14);
        label5.setForeground(Color.BLACK);
        label5.setFont(new Font("italic",Font.BOLD,16));
        panel.add(label5);

        JLabel label6=new JLabel("Room");
        label6.setBounds(580,11,100,14);
        label6.setForeground(Color.BLACK);
        label6.setFont(new Font("italic",Font.BOLD,16));
        panel.add(label6);

        JLabel label7=new JLabel("Time");
        label7.setBounds(690,11,100,14);
        label7.setForeground(Color.BLACK);
        label7.setFont(new Font("italic",Font.BOLD,16));
        panel.add(label7);

        JLabel label8=new JLabel("Deposit");
        label8.setBounds(800,11,100,14);
        label8.setForeground(Color.BLACK);
        label8.setFont(new Font("italic",Font.BOLD,16));
        panel.add(label8);

        JButton back=new JButton("BACK");
        back.setBounds(450,510,120,30);
        back.setFont(new Font("Italic",Font.BOLD,16));
        panel.add(back);
        back.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }

        });


        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,200);
        setVisible(true);

    }

    public static void main(String[] args)
    {
        new PatientInfo();
    }

}
