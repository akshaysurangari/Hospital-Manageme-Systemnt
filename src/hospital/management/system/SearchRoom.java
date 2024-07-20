package hospital.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;
public class SearchRoom extends JFrame
{
    Choice ch;
    JTable table;
    SearchRoom()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("Search For Room");
        label.setBounds(250,11,186,31);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("italic",Font.BOLD,20));
        panel.add(label);

        JLabel status=new JLabel("Status:");
        status.setBounds(70,73,80,20);
        status.setForeground(Color.BLACK);
        status.setFont(new Font("italic",Font.BOLD,14));
        panel.add(status);


        ch=new Choice();
        ch.setBounds(170,73,120,20);
        ch.add("Available");
        ch.add("Occupied");
        panel.add(ch);

        table=new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(Color.GRAY);
        table.setForeground(Color.WHITE);
        panel.add(table);

        try
        {
            Conn c=new Conn();
            String q="select * from room";
            ResultSet rs=c.stmt.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        JLabel Roomno=new JLabel("Roomno");
        Roomno.setBounds(23,162,80,20);
        Roomno.setForeground(Color.BLACK);
        Roomno.setFont(new Font("italic",Font.BOLD,14));
        panel.add(Roomno);


        JLabel available=new JLabel("Availability");
        available.setBounds(175,162,150,20);
        available.setForeground(Color.BLACK);
        available.setFont(new Font("italic",Font.BOLD,14));
        panel.add(available);


        JLabel price=new JLabel("Price");
        price.setBounds(358,162,150,20);
        price.setForeground(Color.BLACK);
        price.setFont(new Font("italic",Font.BOLD,14));
        panel.add(price);

        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(558,162,150,20);
        bed.setForeground(Color.BLACK);
        bed.setFont(new Font("italic",Font.BOLD,14));
        panel.add(bed);

        JButton search=new JButton("Search");
        search.setBounds(200,420,120,25);
        panel.add(search);
        search.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String q="select * from room where Availability='"+ch.getSelectedItem()+"'";
                try
                {
                    Conn c=new Conn();
                    ResultSet rs=c.stmt.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception E)
                {
                    E.printStackTrace();
                }
            }

        });

        JButton back=new JButton("Back");
        back.setBounds(380,420,120,25);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLocation(450,250);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new SearchRoom();
    }

}
