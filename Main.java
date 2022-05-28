package sql_to_ra_trc_drc;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        new GUI();
    }
}

class GUI extends JFrame
{
    // Menubar items
    JMenuBar menuBar;
    JMenu convert , information , help;

    // Information menu items
    JTextArea area;
    JScrollPane scrollPane;

    // Convert menu items
    JMenuItem convertall , withDatabase , withoutDatabase;

    // Help menu items
    JMenuItem about;

    GUI()
    {
        setVisible(true);
        setSize(700 , 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("SQL to RA Converter");


        GUI_menu guiMenu = new GUI_menu(this);
        guiMenu.createMenuBar();

        GUI_information guiInformation = new GUI_information(this);
        guiInformation.writeInformation();

        GUI_convert guiConvert = new GUI_convert(this);
        guiConvert.createConvertMenu();

        GUI_help guiHelp = new GUI_help(this);
        guiHelp.createHelpMenu();
    }
}