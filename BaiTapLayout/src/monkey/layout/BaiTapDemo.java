/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monkey.layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import monkey.event.TextfieldEvent;
import monkey.model.TinhTien;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class BaiTapDemo  {

    private JFrame jframe;
    private JButton buttonInHoaDon;
    private JTextField txtDiaChi;
    private JTextField txtDienThoai;
    private JTextField txtSoGD;
    private JTextField txtThuNgan;
    private JTextField txtCongTienHang;
    private JTextField txtChietKhauIn;
    private JTextField txtGiamTru;
    private JTextField txtPhiThuThem;
    private JTextField txtTongGiaTriThanhTien;
    private JTextField txtTienKhachDua;
    private JTextField txtTienTraLai;
    private int countThemHang = 0;
    ArrayList<TinhTien> list;
    List<JTextField> jTextFields = new ArrayList<>();

    private JPanel panelThemHangHoa;
    private TextfieldEvent textfieldEvent;
    private JButton buttonThemHangInput;

    public static void main(String[] args) {
        new BaiTapDemo();
    }

    public BaiTapDemo() {
        createJframe();
    }
    private void createJframe() {
        jframe = new JFrame();
        jframe.setSize(400, 500);
        jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jframe.add(createPanelMain());
        jframe.setVisible(true);
    }

    //--------------Cấp 1--------------------------------------
    private JPanel createPanelMain() {
        JPanel panelMain = new JPanel(new BorderLayout());
        panelMain.add(createPanelNORTH(), BorderLayout.NORTH);
        panelMain.add(createPanelSOUTH(), BorderLayout.SOUTH);
        return panelMain;
    }

    //--------------Cấp 2--------------------------------------
    private JPanel createPanelNORTH() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createPanelNorthNOTH(), BorderLayout.NORTH);
        panel.add(createPanelCenterNORTH(), BorderLayout.CENTER);
        return panel;
    }

    private JPanel createPanelSOUTH() {
        JPanel panel = new JPanel();
        panel.add(createPanelSouthButton());
        return panel;
    }
    //--------------Cấp 2--------------------------------------END

    //--------------Cấp 3--------------------------------------START
    private JPanel createPanelNorthNOTH() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createPanelTitle(), BorderLayout.NORTH);
        panel.add(createPanelImfomation(), BorderLayout.WEST);
        panel.add(createPanelInputImfomation(), BorderLayout.CENTER);
        panel.add(createPanelPhieuTinhTien(), BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createPanelCenterNORTH() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createPanelNorthCENTER(), BorderLayout.NORTH);
        panel.add(createPanelSouthCENTER(), BorderLayout.SOUTH);
        return panel;
    }
    //--------------Cấp 3--------------------------------------END
    
    //--------------Cấp 4--------------------------------------START
    //--------------CENTER------------
    private JPanel createPanelNorthCENTER() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createPanelTinhTienNhapHang(), BorderLayout.NORTH);
        return panel;
    }

    private JPanel createPanelSouthCENTER() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(createPanelTinhTienLabel(), BorderLayout.WEST);
        panel.add(createPanelTinhTienInput(), BorderLayout.CENTER);
        return panel;
    }

    //--------------Cấp 4--------------------------------------END
    private JPanel createPanelTitle() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("GIÁ RẺ MỖI NGÀY"));
        return panel;
    }

    private JPanel createPanelImfomation() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.add(new JLabel("Đ/c(Add): "));
        panel.add(new JLabel("ĐT(Tel): "));
        panel.add(new JLabel("Số GD(Receipt): "));
        panel.add(new JLabel("Thu ngân(Cashier): "));
        return panel;
    }

    private JPanel createPanelInputImfomation() {
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        txtDiaChi = new JTextField("Tầng 1 tòa nhà OCT1, KĐT Resco Cổ Nhuế 2, Từ Liêm", 2);
        txtDienThoai = new JTextField("04-8880.3434", 2);
        txtSoGD = new JTextField("PA020202", 2);
        txtThuNgan = new JTextField("TM_UY", 2);
        panel.add(txtDiaChi);
        panel.add(txtDienThoai);
        panel.add(txtSoGD);
        panel.add(txtThuNgan);
        return panel;
    }

    private JPanel createPanelPhieuTinhTien() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("PHIẾU TÍNH TIỀN"));
        return panel;
    }

    private JPanel createPanelTinhTienNhapHang() {
        panelThemHangHoa = new JPanel(new BorderLayout());
        JPanel panelThemHangHoa1 = new JPanel(new GridLayout(1, 6, 5, 5));
        panelThemHangHoa1.add(new JLabel("Mã"));
        panelThemHangHoa1.add(new JLabel("Số lượng"));
        panelThemHangHoa1.add(new JLabel("Giá bán"));
        panelThemHangHoa1.add(new JLabel("Tổng tiền"));
        panelThemHangHoa1.add(new JLabel("Chiết khấu"));

        buttonThemHangInput = new JButton("Thêm hàng");
        buttonThemHangInput.setSize(50, 50);
        panelThemHangHoa1.add(buttonThemHangInput);
        buttonThemHangInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel1 = new JPanel(new GridLayout(countThemHang + 1, 6, 5, 5));
                for (int i = 0; i < 6; i++) {
                    jTextFields.add(new JTextField());
                }

                for (JTextField t : jTextFields) {
                    panel1.add(t);
                }
                // panel1.add(new JButton("Nothing"));
                for (int i = 0; i < jTextFields.size(); i = i + 6) {
                    jTextFields.get(i + 5).setVisible(false);
                    jTextFields.get(i + 3).enable(false);
                    jTextFields.get(i + 4).setText("0");

                    jTextFields.get(i + 2).addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                            float tong = 0;
                            textfieldEvent = new TextfieldEvent();
                            for (int i = 0; i < jTextFields.size(); i = i + 6) {
                                textfieldEvent.tinhTongTien(jTextFields.get(i + 1), jTextFields.get(i + 2), jTextFields.get(i + 3));
                                if (!jTextFields.get(i + 3).getText().equals("")) {
                                    tong = tong + Float.parseFloat(jTextFields.get(i + 3).getText());
                                    txtCongTienHang.setText(String.valueOf(tong));
                                    txtTongGiaTriThanhTien.setText(String.valueOf(tong));
                                }
                            }
                        }
                    });
                    jTextFields.get(i + 1).addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(java.awt.event.KeyEvent evt) {
                            float tong = 0;
                            textfieldEvent = new TextfieldEvent();
                            for (int i = 0; i < jTextFields.size(); i = i + 6) {
                                textfieldEvent.tinhTongTien(jTextFields.get(i + 2), jTextFields.get(i + 1), jTextFields.get(i + 3));
                                if (!jTextFields.get(i + 3).getText().equals("")) {
                                    tong = tong + Float.parseFloat(jTextFields.get(i + 3).getText());
                                    txtCongTienHang.setText(String.valueOf(tong));
                                    txtTongGiaTriThanhTien.setText(String.valueOf(tong));
                                }
                            }
                        }
                    });
                }
                jframe.revalidate();
                jframe.repaint();
                countThemHang++;
                System.out.println(countThemHang);
                panelThemHangHoa.add(panel1, BorderLayout.SOUTH);
                panelThemHangHoa.revalidate();  // For JDK 1.7 or above.
                panelThemHangHoa.repaint();
            }
        });

        panelThemHangHoa.add(panelThemHangHoa1, BorderLayout.NORTH);
        return panelThemHangHoa;
    }

    private JPanel createPanelTinhTienLabel() {
        JPanel panel = new JPanel(new GridLayout(7, 1, 5, 5));
        panel.add(new JLabel("Cộng tiền hàng: "));
        panel.add(new JLabel("Chiết khấu: "));
        panel.add(new JLabel("Giảm trừ: "));
        panel.add(new JLabel("Phí thu thêm: "));
        panel.add(new JLabel("Tổng giá trị thành tiền: "));
        panel.add(new JLabel("Tiền khách đưa: "));
        panel.add(new JLabel("Tiền trả lại: "));

        return panel;
    }

    private JPanel createPanelTinhTienInput() {
        JPanel panel = new JPanel(new GridLayout(7, 1, 5, 5));

        txtCongTienHang = new JTextField(15);
        txtChietKhauIn = new JTextField("0", 15);
        txtGiamTru = new JTextField("0", 15);
        txtPhiThuThem = new JTextField("0", 15);
        txtTongGiaTriThanhTien = new JTextField(15);
        txtTienKhachDua = new JTextField(15);
        txtTienTraLai = new JTextField(15);

        txtCongTienHang.enable(false);
        txtTienTraLai.enable(false);
        txtTongGiaTriThanhTien.enable(false);

        txtPhiThuThem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (!txtPhiThuThem.getText().equals("")) {
                    txtTongGiaTriThanhTien.setText(String.valueOf(Float.parseFloat(txtPhiThuThem.getText()) + Float.parseFloat(txtCongTienHang.getText())
                            - Float.parseFloat(txtCongTienHang.getText()) * Float.parseFloat(txtChietKhauIn.getText()) / 100));
                }
            }
        });
        txtChietKhauIn.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (!txtChietKhauIn.getText().equals("")) {
                    txtTongGiaTriThanhTien.setText(String.valueOf(Float.parseFloat(txtPhiThuThem.getText()) + Float.parseFloat(txtCongTienHang.getText())
                            - Float.parseFloat(txtCongTienHang.getText()) * Float.parseFloat(txtChietKhauIn.getText()) / 100));
                }
            }
        });
        txtTienKhachDua.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                if (!txtTienKhachDua.getText().equals("")) {
                    txtTienTraLai.setText(String.valueOf(Float.parseFloat(txtTienKhachDua.getText()) - Float.parseFloat(txtTongGiaTriThanhTien.getText())));
                }
            }
        });
        panel.add(txtCongTienHang);
        panel.add(txtChietKhauIn);
        panel.add(txtGiamTru);
        panel.add(txtPhiThuThem);
        panel.add(txtTongGiaTriThanhTien);
        panel.add(txtTienKhachDua);
        panel.add(txtTienTraLai);

        return panel;
    }

    private JPanel createPanelSouthButton() {
        JPanel panel = new JPanel();
        buttonInHoaDon = new JButton("In hóa đơn");
        buttonInHoaDon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
                //get current date time with Date()
                Date date = new Date();
                
                Map<String, Object> parameter = new HashMap<String, Object>();
                parameter.put("diachi", txtDiaChi.getText());
                parameter.put("dienthoai", txtDienThoai.getText());
                parameter.put("sogiaodich", txtSoGD.getText());
                parameter.put("thungan", txtThuNgan.getText());
                parameter.put("ngay", dateFormat.format(date));
                parameter.put("gio", dateFormat1.format(date));
                parameter.put("congtienhang", txtCongTienHang.getText());
                parameter.put("chietkhau", txtChietKhauIn.getText());
                parameter.put("giamtru", txtGiamTru.getText());
                parameter.put("phithuthem", txtPhiThuThem.getText());
                parameter.put("tonggiatrithanhtien", txtTongGiaTriThanhTien.getText());
                parameter.put("tienkhachdua", txtTienKhachDua.getText());
                parameter.put("tientralai", txtTienTraLai.getText());

                list = new ArrayList<>();
                for (int i = 0; i < jTextFields.size(); i += 6) {
                    if (!jTextFields.get(i).getText().equals("") && !jTextFields.get(i + 1).getText().equals("")
                            && !jTextFields.get(i + 2).getText().equals("") && !jTextFields.get(i + 3).getText().equals("")
                            && !jTextFields.get(i + 4).getText().equals("")) {
                        list.add(new TinhTien(jTextFields.get(i).getText(),
                                            Integer.parseInt(jTextFields.get(i + 1).getText()),
                                            Float.parseFloat(jTextFields.get(i + 2).getText()),
                                            Float.parseFloat(jTextFields.get(i + 3).getText()),
                                            Float.parseFloat(jTextFields.get(i + 4).getText()),
                                            "Tên sản phẩm " + i+ 1));
                    }
                }
                for (TinhTien t : list) {
                    System.out.println(t.getGiaBan() + "  " + t.getTongTien());
                }
                try {
                    JasperReport jasperReport2 = JasperCompileManager.compileReport("report2.jrxml");
                    JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(list);
                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport2, parameter, beanColDataSource);
                    JasperViewer view = new JasperViewer(jasperPrint, true);
                    view.setVisible(true);
                    System.out.println("BaiTapSwing.pdf has been generated!");
                } catch (JRException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        panel.add(buttonInHoaDon);
        return panel;
    }

}
