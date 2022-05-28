package sql_to_ra_trc_drc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

class withDatabase extends JFrame implements ActionListener
{
    JTextPane input;
    JLabel sql , ra , data;
    JButton convert , enlarge;
    JLabel output , outputData;
    JScrollPane scrollPane;
    String normalOutput;

    withDatabase()
    {
        setTitle("Conversion With Database");
        setVisible(true);
        setBounds(400 , 100 , 700 , 700);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        sql = new JLabel("Enter the SQL Query : ");
        ra = new JLabel("Query in Relational Algebra : ");
        data = new JLabel("Executed Query Results : ");
        input = new JTextPane();
        convert = new JButton("Convert");
        output = new JLabel();
        outputData = new JLabel();
        enlarge = new JButton("Enlarge");

        sql.setBounds(275 , 30 , 150 , 30);
        input.setBounds(140 , 60 , 400 , 150);
        convert.setBounds(290 , 220 , 100 , 20);
        ra.setBounds(255 , 250 , 200 , 30);
        output.setBounds(140 , 280  , 400 , 150);
        data.setBounds(270 , 430 , 200 , 30);
        enlarge.setBounds(290 , 460 , 100 , 20);
        outputData.setBounds(140 , 490 , 400 , 150);

        output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        input.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        outputData.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        output.setOpaque(true);
        outputData.setOpaque(true);
        output.setBackground(Color.white);
        outputData.setBackground(Color.white);

        Font defaultFont = new Font("cambria" , Font.PLAIN , 14 );
        Font defaultFont1 = new Font("cambria" , Font.BOLD , 14 );
        input.setFont(defaultFont);
        sql.setFont(defaultFont);
        ra.setFont(defaultFont);
        data.setFont(defaultFont);
        output.setFont(defaultFont1);
        convert.setFont(defaultFont);
        enlarge.setFont(defaultFont);
        outputData.setFont(defaultFont1);

        this.add(sql);
        this.add(input);
        this.add(convert);
        this.add(ra);
        this.add(output);
        this.add(data);
        this.add(outputData);
        this.add(enlarge);

        convert.addActionListener(this);
        enlarge.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Enlarge"))
        {
            new detailedView(normalOutput);
            return;
        }
        String content = input.getText();
        String convertedText = "";
        content = content.substring(0 , content.length() - 1);

        // Set operations
        String temp = content.toLowerCase();
        if(temp.indexOf("union") != -1)
        {
            String part1 = content.substring(0 , temp.indexOf("union"));
            part1 = part1.trim();
            ConvertIntoRA convertIntoRA1 = new ConvertIntoRA(part1);
            String convertedText1 = "<html>";
            if(convertIntoRA1.project != "")
                convertedText1 += "\u03C0 <sub>" + convertIntoRA1.project + "</sub><br>";
            if(convertIntoRA1.having != "")
                convertedText1 += "σ <sub>" + convertIntoRA1.having + "</sub><br>";
            if(convertIntoRA1.groupby != "")
                convertedText1 += "γ <sub>" + convertIntoRA1.groupby + "</sub><br>";
            if(convertIntoRA1.select != "")
                convertedText1 += "σ <sub>" + convertIntoRA1.select + "</sub><br>";
            if(convertIntoRA1.tableRelation != "")
                convertedText1 += "( " + convertIntoRA1.tableRelation + ")<br>";

            convertedText1 += " U <br>";

            String part2 = content.substring(temp.indexOf("union") + 5 , content.length());
            part2 = part2.trim();
            ConvertIntoRA convertIntoRA2 = new ConvertIntoRA(part2);
            if(convertIntoRA2.project != "")
                convertedText1 += "\u03C0 <sub>" + convertIntoRA2.project + "</sub><br>";
            if(convertIntoRA2.having != "")
                convertedText1 += "σ <sub>" + convertIntoRA2.having + "</sub><br>";
            if(convertIntoRA2.groupby != "")
                convertedText1 += "γ <sub>" + convertIntoRA2.groupby + "</sub><br>";
            if(convertIntoRA2.select != "")
                convertedText1 += "σ <sub>" + convertIntoRA2.select + "</sub><br>";
            if(convertIntoRA2.tableRelation != "")
                convertedText1 += "( " + convertIntoRA2.tableRelation + ")<br>";
            convertedText1 += "</html>";
            convertedText = convertedText1;
        }
        else if(temp.indexOf("intersection") != -1)
        {
            String part1 = content.substring(0 , temp.indexOf("intersection"));
            part1 = part1.trim();
            ConvertIntoRA convertIntoRA1 = new ConvertIntoRA(part1);
            String convertedText1 = "<html>";
            if(convertIntoRA1.project != "")
                convertedText1 += "\u03C0 <sub>" + convertIntoRA1.project + "</sub><br>";
            if(convertIntoRA1.having != "")
                convertedText1 += "σ <sub>" + convertIntoRA1.having + "</sub><br>";
            if(convertIntoRA1.groupby != "")
                convertedText1 += "γ <sub>" + convertIntoRA1.groupby + "</sub><br>";
            if(convertIntoRA1.select != "")
                convertedText1 += "σ <sub>" + convertIntoRA1.select + "</sub><br>";
            if(convertIntoRA1.tableRelation != "")
                convertedText1 += "( " + convertIntoRA1.tableRelation + ")<br>";

            convertedText1 += " ∩ <br>";

            String part2 = content.substring(temp.indexOf("union") + 5 , content.length());
            part2 = part2.trim();
            ConvertIntoRA convertIntoRA2 = new ConvertIntoRA(part2);
            if(convertIntoRA2.project != "")
                convertedText1 += "\u03C0 <sub>" + convertIntoRA2.project + "</sub><br>";
            if(convertIntoRA2.having != "")
                convertedText1 += "σ <sub>" + convertIntoRA2.having + "</sub><br>";
            if(convertIntoRA2.groupby != "")
                convertedText1 += "γ <sub>" + convertIntoRA2.groupby + "</sub><br>";
            if(convertIntoRA2.select != "")
                convertedText1 += "σ <sub>" + convertIntoRA2.select + "</sub><br>";
            if(convertIntoRA2.tableRelation != "")
                convertedText1 += "( " + convertIntoRA2.tableRelation + ")<br>";
            convertedText1 += "</html>";
            convertedText = convertedText1;
        }
        else if(temp.indexOf("minus") != -1)
        {
            String part1 = content.substring(0 , temp.indexOf("minus"));
            part1 = part1.trim();
            ConvertIntoRA convertIntoRA1 = new ConvertIntoRA(part1);
            String convertedText1 = "<html>";
            if(convertIntoRA1.project != "")
                convertedText1 += "\u03C0 <sub>" + convertIntoRA1.project + "</sub><br>";
            if(convertIntoRA1.having != "")
                convertedText1 += "σ <sub>" + convertIntoRA1.having + "</sub><br>";
            if(convertIntoRA1.groupby != "")
                convertedText1 += "γ <sub>" + convertIntoRA1.groupby + "</sub><br>";
            if(convertIntoRA1.select != "")
                convertedText1 += "σ <sub>" + convertIntoRA1.select + "</sub><br>";
            if(convertIntoRA1.tableRelation != "")
                convertedText1 += "( " + convertIntoRA1.tableRelation + ")<br>";

            convertedText1 += " - <br>";

            String part2 = content.substring(temp.indexOf("union") + 5 , content.length());
            part2 = part2.trim();
            ConvertIntoRA convertIntoRA2 = new ConvertIntoRA(part2);
            if(convertIntoRA2.project != "")
                convertedText1 += "\u03C0 <sub>" + convertIntoRA2.project + "</sub><br>";
            if(convertIntoRA2.having != "")
                convertedText1 += "σ <sub>" + convertIntoRA2.having + "</sub><br>";
            if(convertIntoRA2.groupby != "")
                convertedText1 += "γ <sub>" + convertIntoRA2.groupby + "</sub><br>";
            if(convertIntoRA2.select != "")
                convertedText1 += "σ <sub>" + convertIntoRA2.select + "</sub><br>";
            if(convertIntoRA2.tableRelation != "")
                convertedText1 += "( " + convertIntoRA2.tableRelation + ")<br>";
            convertedText1 += "</html>";
            convertedText = convertedText1;
        }
        else {
            ConvertIntoRA convertIntoRA = new ConvertIntoRA(content);

            convertedText = "<html>";
            if (convertIntoRA.project != "")
                convertedText += "\u03C0 <sub>" + convertIntoRA.project + "</sub><br>";
            if (convertIntoRA.having != "")
                convertedText += "σ <sub>" + convertIntoRA.having + "</sub><br>";
            if (convertIntoRA.groupby != "")
                convertedText += "γ <sub>" + convertIntoRA.groupby + "</sub><br>";
            if (convertIntoRA.select != "")
                convertedText += "σ <sub>" + convertIntoRA.select + "</sub><br>";
            if (convertIntoRA.tableRelation != "")
                convertedText += "( " + convertIntoRA.tableRelation + ")<br>";
            convertedText += "</html>";
            if (!convertIntoRA.correct)
                convertedText = "Invalid SQL Query";
        }


        database dbase = new database(content);
        String ans = dbase.returnString();
        normalOutput = dbase.output;
        if(!dbase.valid) {
            ans = "NOT A VALID SQL QUERY";
            normalOutput = "NOT A VALID SQL QUERY";
        }
        outputData.setText(ans);
        outputData.setSize(400 , outputData.getPreferredSize().height);
        if(!dbase.valid) {
            convertedText = "NOT A VALID SQL QUERY";
            normalOutput = "NOT A VALID SQL QUERY";
        }
        output.setText(convertedText);
        output.setSize(400 , output.getPreferredSize().height);
//        this.setSize(this.getPreferredSize());
    }
}


public class database {
    String finalString = "";
    String output = "";
    boolean valid = true;

    database(String query){
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        try {
            // Connecting to loader class
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver Loaded");

            // Establishing connection
            Connection con = DriverManager.getConnection(url , "dbmsInnovative" , "dbmsInnovative");
            System.out.println("Connection Established");

            // Create the statement object
            Statement statement = con.createStatement();

            // Query to be executed
            String execute = query;

            // Execute query
            ResultSet resultSet = statement.executeQuery(execute);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            output = "";
            finalString += "<html>";
            for(int i = 1 ; i <= columnsNumber ; i++){
                finalString += String.format("%-20s" ,rsmd.getColumnName(i));
                output += String.format("%-20s" ,rsmd.getColumnName(i));
            }
            finalString += "<br>";
            output += "\n";
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = resultSet.getString(i);
                    finalString += String.format("%-20s" ,columnValue);
                    output += String.format("%-20s" ,columnValue);
                }
                finalString += "<br>";
                output += "\n";
            }
            finalString += "</html>";
        }
        catch(ClassNotFoundException E)
        {
            System.out.println("Driver not Loaded");
        }
        catch (SQLException E)
        {
            valid = false;
            E.printStackTrace();
            System.out.println("Connection Not Established");
        }
    }

    String returnString()
    {
        return finalString;
    }
}

class detailedView extends JFrame
{
    detailedView(String content)
    {
        this.setTitle("Detailed View");
        setVisible(true);
        setBounds(400 , 100 , 700 , 700);
        JTextArea details = new JTextArea(content);
        details.setEditable(false);
        details.setBackground(Color.white);
        Font defaultFont = new Font("courier" , Font.BOLD , 14 );
        details.setFont(defaultFont);
        JScrollPane scrollPane = new JScrollPane(details);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        this.add(scrollPane);
    }
}