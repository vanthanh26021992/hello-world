/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey.test;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class JTextFieldTest {
    private JFrame frame;
    private JButton button;
    private JTextField tfield;
    private String nameTField;
    private int count;

    public JTextFieldTest()
    {
        nameTField = "tField";
        count = 0;
    }

    private void displayGUI()
    {
        frame = new JFrame("JFrame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1, 2, 2));
        button = new JButton("Add JTextField");
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                tfield = new JTextField();
                tfield.setName(nameTField + count);
                count++;
                frame.add(tfield);
                frame.revalidate();  // For JDK 1.7 or above.
                //frame.getContentPane().revalidate(); // For JDK 1.6 or below.
                frame.repaint();
            }
        });
        frame.add(button);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new JTextFieldTest().displayGUI();
            }
        });
    }
}
