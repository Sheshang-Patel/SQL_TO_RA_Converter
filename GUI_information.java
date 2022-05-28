package sql_to_ra_trc_drc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_information {
    GUI gui;
    GUI_information(GUI gui)
    {
        this.gui = gui;
    }

    void writeInformation()
    {
        gui.area = new JTextArea();
        gui.scrollPane = new JScrollPane(gui.area);

        // Setting vertical scrollbar and textarea to non editable
        Font defaultFont = new Font("courier" , Font.BOLD , 14 );
        gui.area.setFont(defaultFont);
        gui.area.setEditable(false);
        gui.scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        gui.scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        String contentForRA = "";
        String procedureForRA = "";
        String contentForTableStudent = "";
        String contentForTableCourses = "";
        String contentForTableMarks = "";
        String contentForNote = "";

        contentForRA = "\t              Conversion into Relational Algebra from SQL\n\n" +
                "        SQL equivalent to RA\n" +
                "   1) SELECT -> \u03C0 \n" +
                "   2) FROM -> ([table name])\n" +
                "   3) WHERE -> σ\n" +
                "   4) GROUP BY -> γ\n" +
                "   5) HAVING -> σ\n" +
                "   6) UNION -> U\n" +
                "   7) INTERSECTION -> ∩\n" +
                "   8) MINUS -> -\n" +
                "   9) Aggregate Functions -> γ , σ\n" +
                "   10) natural join -> \u2a1d\n" +
                "   11) left outer join -> \u27d5\n" +
                "   12) right outer join -> \u27d6\n" +
                "   13) full outer join -> \u27d7\n" +
                "   14) AND -> ∧\n" +
                "   15) OR -> ∨\n\n\n";

        contentForTableStudent += "                   TABLE STUDENT\n";
        contentForTableStudent += String.format("  %-15s%-20s %-20s\n" , "ROLLNO" , "FNAME" , "LNAME");
        contentForTableStudent += String.format("  %-20s %-20s   %-20s\n" , "101" , "Umesh" , "Patel");
        contentForTableStudent += String.format("  %-20s %-20s   %-20s\n" , "102" , "Rajesh" , "Shah");
        contentForTableStudent += String.format("  %-20s %-20s   %-20s\n" , "103" , "Suresh" , "Patel");
        contentForTableStudent += String.format("  %-20s %-20s    %-20s\n" , "104" , "Bansi" , "Lunagariya");
        contentForTableStudent += String.format("  %-20s %-20s %-20s\n" , "105" , "Kamlesh" , "gandhi");
        contentForTableStudent += String.format("  %-20s %-20s   %-20s\n" , "106" , "Omkar" , "jadhav");
        contentForTableStudent += String.format("  %-20s %-20s     %-20s\n\n\n" , "107" , "Lata" , "Shah");

        contentForTableCourses += "                   TABLE COURSES\n";
        contentForTableCourses += String.format("   %-20s %-20s\n" , "CID" , "CNAME");
        contentForTableCourses += String.format("   %-20s %-20s\n" , "CS101" , "CA");
        contentForTableCourses += String.format("   %-20s %-20s\n" , "CS102" , "DBMS");
        contentForTableCourses += String.format("   %-20s %-20s\n" , "CS103" , "OS");
        contentForTableCourses += String.format("   %-20s %-20s\n" , "CS104" , "PSC");
        contentForTableCourses += String.format("   %-20s %-20s\n" , "CS105" , "PS");
        contentForTableCourses += String.format("   %-20s %-20s\n\n\n" , "CS106" , "POE");

        contentForTableMarks += "                    TABLE MARKS\n";
        contentForTableMarks += String.format("   %-10s %-15s %-20s\n" , "ROLLNO" , "COURSEID" , "MARKS");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "101" , "CS101" , "89");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "101" , "CS103" , "80");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "101" , "CS104" , "77");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "102" , "CS102" , "70");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "102" , "CS103" , "68");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "102" , "CS105" , "88");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "103" , "CS102" , "89");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "103" , "CS103" , "90");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "103" , "CS104" , "83");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "104" , "CS101" , "80");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "104" , "CS104" , "90");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "104" , "CS105" , "92");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "105" , "CS101" , "84");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "105" , "CS102" , "90");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "105" , "CS103" , "81");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "106" , "CS103" , "70");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "106" , "CS105" , "74");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "106" , "CS104" , "71");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "107" , "CS101" , "65");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n" , "107" , "CS102" , "69");
        contentForTableMarks += String.format("   %-20s %-20s %-20s\n\n\n" , "107" , "CS103" , "73");

        contentForNote += "     NOTE : Please write your query only in the following format : \n"
                + "       -> SELECT...FROM(...JOINS...ON...)...WHERE...GROUP BY... HAVING...\n" +
                "       -> Aggregate functions can be used in select as well as having clause\n" +
                "       -> You can join two queries with UNION, INTERSECT, MINUS\n\n\n";

        String Content = contentForRA + contentForTableStudent + contentForTableCourses + contentForTableMarks + contentForNote;
        gui.area.setText(Content);
        gui.area.setWrapStyleWord(true);
        gui.area.setLineWrap(true);

        // Adding the components into gui
        gui.add(gui.scrollPane);
    }
}
