package application;

import javax.swing.*;
import java.awt.*;

public class display extends JFrame {


    public void assembleDisplay(){
        JFrame mainFrame = new JFrame();
        mainFrame.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();

        Panel tab1 = new Panel();
        tabs.add("tab1", tab1);
        tab1.add(new JLabel("MEOWMEOW",SwingConstants.CENTER));

        Panel tab2 = new Panel();
        tabs.add("tab2", tab2);

        Panel tab3 = new Panel();
        tabs.add("tab3", tab3);



        //Adding
        mainFrame.add(tabs);

        //WINDOW SETTINGS
        mainFrame.setSize(1200, 800);
        mainFrame.setVisible(true);
        mainFrame.setFocusable(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.setTitle("TEST");

    }


    public static void main(String[] args) {
        new display().assembleDisplay();
    }
}
