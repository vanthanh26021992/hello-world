/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey.event;

import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class TextfieldEvent {

    public void tinhTongTien(JTextField txt1, JTextField txt2, JTextField txt3) {
        if (!txt1.getText().equals("") && !txt2.getText().equals("")) {
            txt3.setText((String.valueOf(Integer.parseInt(txt1.getText()) * Float.parseFloat(txt2.getText()))));
        } else {
            txt3.setText("");
        }
    }
}
