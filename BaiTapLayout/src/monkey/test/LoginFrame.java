/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey.test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class LoginFrame extends JFrame{
    public LoginFrame() {
        createJFrame();
    }
 
    // create JFrame
    private void createJFrame() {
        setTitle("Login use BorderLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        // add main panel
        add(createMainPanel());
        // display
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    // create main panel
    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.add(createTitlePanel(), BorderLayout.NORTH);
        panel.add(createNamePanel(), BorderLayout.WEST);
        panel.add(createInputPanel(), BorderLayout.CENTER);
        panel.add(createStatusPanel(), BorderLayout.EAST);
        panel.add(createLoginButtonPanel(), BorderLayout.SOUTH);
        return panel;
    }
 
    // create title panel
    private JPanel createTitlePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Login to my Blog"));
        return panel;
    }
 
    // create name item
    private JPanel createNamePanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.add(new JLabel("User name"));
        panel.add(new JLabel("Password"));
        return panel;
    }
 
    // create input panel
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.add(new JTextField(20));
        panel.add(new JPasswordField(20));
        return panel;
    }
 
    // create status panel
    private JPanel createStatusPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.add(new JLabel("Wrong"));
        panel.add(new JLabel("Wrong"));
        return panel;
    }
 
    // create login button panel
    private JPanel createLoginButtonPanel(){
        JPanel panel = new JPanel();
        panel.add(new JButton("Login"));
        return panel;
    }
 
    public static void main(String[] args) {
        new LoginFrame();
    }
}
