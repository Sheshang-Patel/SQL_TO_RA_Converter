package sql_to_ra_trc_drc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_help implements ActionListener {
    GUI gui;

    GUI_help(GUI gui)
    {
        this.gui = gui;
    }

    void createHelpMenu()
    {
        gui.about = new JMenuItem("About");

        // Adding about into the help menu
        gui.help.add(gui.about);

        // Adding Action Listener to the about
        gui.about.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new about(gui);
    }
}

class about extends JFrame
{
    GUI gui;
    JTextArea textArea;
    JScrollPane scrollPane;
    JLabel title , content;

    about(GUI gui)
    {
        this.gui = gui;
        setTitle("About Us");
        setVisible(true);
        setBounds(400 , 100 , 600 , 700);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon.jpg"));
        Image i2 = i1.getImage();
        i2.getScaledInstance(100 , 100 , Image.SCALE_AREA_AVERAGING);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i1);


        Font defaultFont = new Font("cambria" , Font.BOLD , 14 );
        title = new JLabel("SQL to RA CONVERTER");
        content = new JLabel();
        title.setFont(defaultFont);
        content.setFont(defaultFont);

        title.setBounds(215 , 25 , 200 , 30);
        l1.setBounds(190 , 55 , 200 , 150);
        content.setBounds(100 , 210 , 400 , 400);

        String s = "";
        s += "<html>";
        s += "Made By :<br>&nbsp;&nbsp;&nbsp;&nbsp; Sheshang Patel<br>";
        s += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shivang Patel<br>";
        s += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Atharva Singh<br>";
        s += "<br>";
        s += "SQL to RA converter converts the given sql query into its relational algebra form.<br>";
        s += "It can perform two task : <br>";
        s += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. Convert a generalized query into RA specified in a &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;particular format given on information page<br>";
        s += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2. Convert sql query into ra connected with database at &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;the backend using JDBC and displaying the " +
                "converted &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;query into ra as well as the output of the query given &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;by the database on the gui<br>";
        s += "<br>";
        s += "Contact us on : <br>";
        s += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Sheshang : 20BCE271@nirmauni.ac.in<br>";
        s += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Shivang : 20BCE272@nirmauni.ac.in<br>";
        s += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Atharva : 20BCE279@nirmauni.ac.in<br>";
        content.setText(s);
        add(title);
        add(l1);
        add(content);
    }
}