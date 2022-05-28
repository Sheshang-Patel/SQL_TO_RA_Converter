package sql_to_ra_trc_drc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_convert implements ActionListener {
    GUI gui;

    GUI_convert(GUI gui)
    {
        this.gui = gui;
    }

    void createConvertMenu()
    {
        gui.withoutDatabase = new JMenuItem("Without Database");
        gui.withDatabase = new JMenuItem("With Database");

        // Adding convertall into Convert Menu
        gui.convert.add(gui.withoutDatabase);
        gui.convert.add(gui.withDatabase);

        // Adding action Listener to converall
        gui.withoutDatabase.addActionListener(this);
        gui.withDatabase.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Without Database"))
            new withoutDatabase();
        else
            new withDatabase();
    }
}

class withoutDatabase extends JFrame implements ActionListener
{
    JTextPane input;
    JLabel sql , ra;
    JScrollPane scrollpane;
    JButton convert;
    JLabel output;

    withoutDatabase()
    {
        setVisible(true);
        setBounds(400 , 100 , 600 , 500);
        setTitle("Conversion Without Database");
        setLayout(null);

        sql = new JLabel("Enter the SQL Query : ");
        ra = new JLabel("Query in Relational Algebra : ");
        input = new JTextPane();
        convert = new JButton("Convert");
        output = new JLabel();

        sql.setBounds(225 , 30 , 150 , 30);
        input.setBounds(140 , 60 , 300 , 150);
        convert.setBounds(240 , 220 , 100 , 20);
        ra.setBounds(205 , 250 , 200 , 30);
        output.setBounds(140 , 280  , 300 , 150);

        output.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        input.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        output.setOpaque(true);
        output.setBackground(Color.white);

        Font defaultFont = new Font("cambria" , Font.PLAIN , 14 );
        Font defaultFont1 = new Font("cambria" , Font.BOLD , 14 );
        input.setFont(defaultFont);
        sql.setFont(defaultFont);
        ra.setFont(defaultFont);
        output.setFont(defaultFont1);
        convert.setFont(defaultFont);

        this.add(sql);
        this.add(input);
        this.add(convert);
        this.add(ra);
        this.add(output);

        convert.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String content = input.getText();
        String convertedText = "";

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
        output.setText(convertedText);
        output.setSize(300 , output.getPreferredSize().height + 30);
    }
}

class ConvertIntoRA
{
    String content;
    String fin = "";
    String project = "";
    String select = "";
    String tableRelation = "";
    String groupby = "";
    String thetaCondition = "";
    String having = "";
    boolean correct = true;

    ConvertIntoRA(String content)
    {
        this.content = content;
        convertSQL();
    }

    int min(int a, int b)
    {
        if(a < b)
            return a;
        else
            return b;
    }

    void convertSQL()
    {
        String sqlInput = content.toLowerCase();

        int posSelect = -1;
        int posFrom = -1;
        int posWhere = -1;
        int posGroup = -1;
        int posHaving = -1;
        posSelect = sqlInput.indexOf("select");
        posFrom = sqlInput.indexOf("from");
        posWhere = sqlInput.indexOf("where");
        posGroup = sqlInput.indexOf("group by");
        posHaving = sqlInput.indexOf("having");

        if(posSelect == -1 || posFrom == -1)
        {
            correct = false;
        }
        if(posWhere == -1)
        {
            posWhere = content.length();
        }
        if(posGroup == -1)
        {
            posGroup = content.length();
        }
        if(posHaving == -1)
        {
            posHaving = content.length();
        }

        project = content.substring(posSelect + 7 , posFrom - 1);
        tableRelation = content.substring(posFrom + 5 , min(posWhere , posGroup) - 1);
        // Where -> end of the sql query or start of group by clause
        if(posWhere != content.length())
            select = content.substring(posWhere + 6 , min(content.length() , posGroup) - 1);
        if(posGroup != content.length())
            groupby = content.substring(posGroup + 8 , posHaving - 1);
        if(posHaving != content.length())
            having = content.substring(posHaving + 6 , content.length() - 1);

        // Checking for and and or in condition statement
        select = select.replaceAll("(?i)and" , "∧");
        select = select.replaceAll("(?i)or" , "∨");
        having = having.replaceAll("(?i)and" , "∧");
        having = having.replaceAll("(?i)or" , "∨");


        // on operator for outer joins
        boolean req = false;
        int posOn = -1;
        int posComma = -1;
        if(tableRelation.indexOf("left outer join") != -1 || tableRelation.indexOf("right outer join") != -1 || tableRelation.indexOf("full outer join") != -1)
        {
            posOn = tableRelation.indexOf("on");
            posComma = tableRelation.indexOf(",");
            if(posOn == -1) {
                correct = false;
                return;
            }
            if(posComma == -1)
            {
                posComma = tableRelation.length();
            }
            thetaCondition = "<sub>" + tableRelation.substring(posOn + 2 , min(tableRelation.length() , posComma)) + "</sub>";
            if(tableRelation.indexOf("left outer join") != -1)
            {
                String newRelation = tableRelation.substring(0 , tableRelation.indexOf("left outer join") + 16);
                newRelation += thetaCondition;
                newRelation += tableRelation.substring(tableRelation.indexOf("left outer join") + 15 , posOn - 1);
                if(tableRelation.contains(","))
                {
                    newRelation += " " + tableRelation.substring(tableRelation.indexOf(",") , tableRelation.length());
                }
                tableRelation = newRelation;
            }
            if(tableRelation.indexOf("right outer join") != -1)
            {
                String newRelation = tableRelation.substring(0 , tableRelation.indexOf("right outer join") + 17);
                newRelation += thetaCondition;
                newRelation += tableRelation.substring(tableRelation.indexOf("right outer join") + 16 , posOn - 1);
                if(tableRelation.contains(","))
                {
                    newRelation += " " + tableRelation.substring(tableRelation.indexOf(",") , tableRelation.length());
                }
                tableRelation = newRelation;
                tableRelation = newRelation;
            }
            if(tableRelation.indexOf("full outer join") != -1)
            {
                String newRelation = tableRelation.substring(0 , tableRelation.indexOf("full outer join") + 16);
                newRelation += thetaCondition;
                newRelation += tableRelation.substring(tableRelation.indexOf("full outer join") + 15 , posOn - 1);
                if(tableRelation.contains(","))
                {
                    newRelation += " " + tableRelation.substring(tableRelation.indexOf(",") , tableRelation.length());
                }
                tableRelation = newRelation;
                tableRelation = newRelation;
            }
        }

        // Joins
        tableRelation = tableRelation.replaceAll("(?i)natural join" , "\u2a1d");
        tableRelation = tableRelation.replaceAll("(?i)left outer join" , "\u27d5");
        tableRelation = tableRelation.replaceAll("(?i)right outer join" , "\u27d6");
        tableRelation = tableRelation.replaceAll("(?i)full outer join" , "\u27d7");
        tableRelation = tableRelation.replaceAll("," , "x");

        // Aggregate functions in project clause
        String temp = project.toLowerCase();
        int posSum = -1;
        int posCount = -1;
        int posMin = -1;
        int posMax = -1;
        int posAvg = -1;
        if(temp.indexOf("sum") != -1)
        {
            while(true) {
                posSum = temp.indexOf("sum" , posSum + 1);
                if(posSum == -1)
                    break;
                String addOn = "";
                addOn += project.substring(posSum + 4 , temp.indexOf(")" , posSum + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "SUM(" + addOn + ")";
            }
        }
        if(temp.indexOf("count") != -1)
        {
            while(true) {
                posCount = temp.indexOf("count" , posCount + 1);
                if(posCount == -1)
                    break;
                String addOn = "";
                addOn += project.substring(posCount + 6 , temp.indexOf(")" , posCount + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "COUNT(" + addOn + ")";
            }
        }
        if(temp.indexOf("min") != -1)
        {
            while(true) {
                posMin = temp.indexOf("min" , posMin + 1);
                if(posMin == -1)
                    break;
                String addOn = "";
                addOn += project.substring(posMin + 4 , temp.indexOf(")" , posMin + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "MIN("+addOn+")";
            }
        }
        if(temp.indexOf("max") != -1)
        {
            while(true) {
                posMax = temp.indexOf("max" , posMax + 1);
                if(posMax == -1)
                    break;
                String addOn = "";
                addOn += project.substring(posMax + 4 , temp.indexOf(")" , posMax + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "MAX(" + addOn + ")";
            }
        }
        if(temp.indexOf("avg") != -1)
        {
            while(true) {
                posAvg = temp.indexOf("avg" , posAvg + 1);
                if(posAvg == -1)
                    break;
                String addOn = "";
                addOn += project.substring(posAvg + 4 , temp.indexOf(")" , posAvg + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "AVG(" + addOn + ")";
            }
        }

        // Aggregate Function in having clause
        temp = having.toLowerCase();
        posSum = -1;
        posCount = -1;
        posMin = -1;
        posMax = -1;
        posAvg = -1;
        if(temp.indexOf("sum") != -1)
        {
            while(true) {
                posSum = temp.indexOf("sum" , posSum + 1);
                if(posSum == -1)
                    break;
                String addOn = "";
                addOn += having.substring(posSum + 4 , temp.indexOf(")" , posSum + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "SUM(" + addOn + ")";
            }
        }
        if(temp.indexOf("count") != -1)
        {
            while(true) {
                posCount = temp.indexOf("count" , posCount + 1);
                if(posCount == -1)
                    break;
                String addOn = "";
                addOn += having.substring(posCount + 6 , temp.indexOf(")" , posCount + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "COUNT(" + addOn + ")";
            }
        }
        if(temp.indexOf("min") != -1)
        {
            while(true) {
                posMin = temp.indexOf("min" , posMin + 1);
                if(posMin == -1)
                    break;
                String addOn = "";
                addOn += having.substring(posMin + 4 , temp.indexOf(")" , posMin + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "MIN("+addOn+")";
            }
        }
        if(temp.indexOf("max") != -1)
        {
            while(true) {
                posMax = temp.indexOf("max" , posMax + 1);
                if(posMax == -1)
                    break;
                String addOn = "";
                addOn += having.substring(posMax + 4 , temp.indexOf(")" , posMax + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "MAX(" + addOn + ")";
            }
        }
        if(temp.indexOf("avg") != -1)
        {
            while(true) {
                posAvg = temp.indexOf("avg" , posAvg + 1);
                if(posAvg == -1)
                    break;
                String addOn = "";
                addOn += having.substring(posAvg + 4 , temp.indexOf(")" , posAvg + 2));
                if(groupby != "")
                    groupby += " , ";
                groupby += "AVG(" + addOn + ")";
            }
        }
    }
}