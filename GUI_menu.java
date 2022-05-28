package sql_to_ra_trc_drc;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI_menu
{
    GUI gui;
    GUI_menu(GUI gui)
    {
        this.gui = gui;
    }

    void createMenuBar()
    {
        gui.menuBar = new JMenuBar();
        gui.information = new JMenu("Information");
        gui.convert = new JMenu("Convert");
        gui.help = new JMenu("Help");

        // Adding all items into the menubar
        gui.menuBar.add(gui.information);
        gui.menuBar.add(gui.convert);
        gui.menuBar.add(gui.help);
        gui.setJMenuBar(gui.menuBar);
    }
}
