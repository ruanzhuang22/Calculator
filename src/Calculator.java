import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{
    private JPanel pnlMain;
    private JButton a9Button;
    private JButton a8Button;
    private JButton btnChia;
    private JButton a7Button;
    private JButton a6Button;
    private JButton btnNhan;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a3Button;
    private JButton a2Button;
    private JButton btnTru;
    private JButton a1Button;
    private JButton btnClear;
    private JButton btnCong;
    private JButton btnKetqua;
    private JButton a0Button;
    private JTextField txtNhap;

    //Ham tao
    Calculator(){
        txtNhap.setHorizontalAlignment(SwingConstants.RIGHT);
        txtNhap.setFocusable(false);
        txtNhap.setEditable(false);

        a0Button.addActionListener(setNumberListener);
        a1Button.addActionListener(setNumberListener);
        a2Button.addActionListener(setNumberListener);
        a3Button.addActionListener(setNumberListener);
        a4Button.addActionListener(setNumberListener);
        a5Button.addActionListener(setNumberListener);
        a6Button.addActionListener(setNumberListener);
        a7Button.addActionListener(setNumberListener);
        a8Button.addActionListener(setNumberListener);
        a9Button.addActionListener(setNumberListener);
        btnCong.addActionListener(setNumberListener);
        btnChia.addActionListener(setNumberListener);
        btnNhan.addActionListener(setNumberListener);
        btnTru.addActionListener(setNumberListener);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                strExpression = " ";
                txtNhap.setText("0");
            }
        });
        btnKetqua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ScriptEngineManager ngr = new ScriptEngineManager();
                ScriptEngine engine = ngr.getEngineByName("JavaScript");
                try{
                    strExpression = engine.eval(strExpression).toString();
                }catch (ScriptException scriptException){
                    scriptException.printStackTrace();
                }
                txtNhap.setText(strExpression);
            }
        });
    }
    ActionListener setNumberListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            strExpression= strExpression+ e.getActionCommand();
            txtNhap.setText(strExpression);
        }
    };

    String strExpression  =" ";
    
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setContentPane(calculator.pnlMain);
        calculator.setSize(600,500);
        calculator.setTitle("Máy tính thông minh");
        calculator.setLocationRelativeTo(null);
        calculator.setVisible(true);

    }
}
