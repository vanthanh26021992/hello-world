/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class Test {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat dateFormat1= new SimpleDateFormat("HH:mm:ss");
       //get current date time with Date()
       Date date = new Date();
       System.out.println(dateFormat.format(date));
       System.out.println(dateFormat1.format(date));
    }
    
    /*
    String temp[] = new String[list.size() * 5];
                panelInHangHoa = new JPanel(new GridLayout(list.size(), 5, 5, 5));
                JLabel labels[] = new JLabel[list.size() * 5];
                List<String> ss = new ArrayList<>();
                for (TinhTien t : list) {
                    ss.add(t.getMa());
                    ss.add(String.valueOf(t.getSoLuong()));
                    ss.add(String.valueOf(t.getGiaBan()));
                    ss.add(String.valueOf(t.getTongTien()));
                    ss.add(String.valueOf(t.getChietKhau()));
                }

                for (int i = 0; i < labels.length; i = i + 5) {
                    labels[i] = new JLabel(String.valueOf(ss.get(i)));
                    labels[i + 1] = new JLabel(ss.get(i + 1));
                    labels[i + 2] = new JLabel(ss.get(i + 2));
                    labels[i + 3] = new JLabel(ss.get(i + 3));
                    labels[i + 4] = new JLabel(ss.get(i + 4));
                    panelInHangHoa.add(labels[i]);
                    panelInHangHoa.add(labels[i + 1]);
                    panelInHangHoa.add(labels[i + 2]);
                    panelInHangHoa.add(labels[i + 3]);
                    panelInHangHoa.add(labels[i + 4]);
                    createPanelTinhTienThongTinHang().add(panelInHangHoa, BorderLayout.CENTER);
                }
    */
}
