/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey.test;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import monkey.model.TinhTien;

/**
 *
 * @author Administrator
 */
public class JLabelTest {

    private JFrame frame;
    List<Student> list = new ArrayList<>();
    private JPanel panel1;

    public static void main(String[] args) {
        new JLabelTest();
    }

    public JLabelTest() {
        frame = new JFrame();
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(creatPanelMain(), BorderLayout.CENTER);
        //panel.add(createPanelButton(), BorderLayout.NORTH);
        panel.add(createPanelSOUTH(), BorderLayout.NORTH);
        frame.add(panel);

    }

    private JPanel createPanelSOUTH()
    {
        JPanel panel= new JPanel();
        panel.add(createPanelButton());
        return panel;
    }
    private JPanel createPanelButton() {
        panel1 = new JPanel();
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                list.add(new Student(1, "Name 1"));
                list.add(new Student(2, "Name 2"));
                list.add(new Student(3, "Name 3"));
                list.add(new Student(4, "Name 4"));
                String temp[] = new String[list.size() * 2];
                List<String> ss = new ArrayList<>();

                JPanel panel = new JPanel(new GridLayout(list.size()/2, 2, 5, 5));
                JLabel labels[] = new JLabel[8];

                for (Student s : list) {
                    ss.add(String.valueOf(s.getId()));
                    ss.add(s.getName());
                }
                for (int i = 0; i < labels.length; i = i + 2) {
                    labels[i] = new JLabel(String.valueOf(ss.get(i)));
                    labels[i + 1] = new JLabel(ss.get(i + 1));
                    panel.add(labels[i]);
                    panel.add(labels[i + 1]);
                    panel1.add(panel);
                }
                panel1.revalidate();  // For JDK 1.7 or above.
                panel1.repaint();
            }
        });
        panel1.add(button);
        
        return panel1;
    }

    private JPanel creatPanelMain() {
        list.add(new Student(1, "Name 1"));
        list.add(new Student(2, "Name 2"));
        list.add(new Student(3, "Name 3"));
        list.add(new Student(4, "Name 4"));
        String temp[] = new String[list.size() * 2];
        List<String> ss = new ArrayList<>();

        JPanel panel = new JPanel(new GridLayout(list.size(), 1, 5, 5));
        JLabel labels[] = new JLabel[8];

        for (Student s : list) {
            ss.add(String.valueOf(s.getId()));
            ss.add(s.getName());
        }

        for (int i = 0; i < labels.length; i = i + 2) {
            labels[i] = new JLabel(String.valueOf(ss.get(i)));
            labels[i + 1] = new JLabel(ss.get(i + 1));
            panel.add(labels[i]);
            panel.add(labels[i + 1]);
        }
        return panel;
    }

}
