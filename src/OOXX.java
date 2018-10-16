import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class OOXX extends JFrame {
    public OOXX() {
        init();
    }
    private Container cp;
    private JLabel jLabel = new JLabel("O優先");
    private JButton
            jButton_Run = new JButton("Play"),
            jButton_Exit = new JButton("EXIT"),
            jButton_OX[][] = new JButton[3][3];  //2維陣列按鈕
    private JPanel
            jPanel_OX = new JPanel(new GridLayout(3, 3, 3, 3)),
            jPanel_Options = new JPanel(new GridLayout(1, 2, 3, 3));
    private boolean
            Boolean_flag = true,
            Boolean_sequence =true,
            Boolean_BtnText_Enabled = true;

    private void init()
    {
        this.setBounds(400, 100, 600, 500);
        this.setVisible(true);
        this.setTitle("OOXX小遊戲");
        cp = this.getContentPane();
        jLabel.setPreferredSize(new Dimension(600,50));
        jLabel.setFont(new Font(null,Font.BOLD,28));
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        jPanel_Options.setPreferredSize(new Dimension(600,40));
        jPanel_Options.add(jButton_Run);
        jPanel_Options.add(jButton_Exit);
        cp.add(jPanel_OX, BorderLayout.CENTER);
        cp.add(jPanel_Options, BorderLayout.SOUTH);
        cp.add(jLabel,BorderLayout.NORTH);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new MainFrame();
            }
        });
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jButton_OX[i][j] = new JButton();
                jPanel_OX.add(jButton_OX[i][j]);  //新增
                jButton_OX[i][j].setEnabled(false);
                jButton_OX[i][j].setBackground(new Color(255, 255, 255));  //背景顏色
                jButton_OX[i][j].setFont(new Font(null, Font.BOLD, 72));
                jButton_OX[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jButton_Run.setText("Replay");
                        jButton_Run.setEnabled(true);
                        JButton tempBtn = (JButton) e.getSource(); //臨時按鈕ｅ事件
                        if (tempBtn.getText().equals("")) {
                            if (Boolean_flag == true) {
                                tempBtn.setText("O");
                            } else {
                                tempBtn.setText("X");
                            }
                            Boolean_flag = !Boolean_flag;
                        }
                        checkStat();
                    }
                });
            }
        }
        jButton_Run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                jButton_Run.setEnabled(false);
                Boolean_BtnText_Enabled = !Boolean_BtnText_Enabled;
                if(Boolean_sequence == true){
                    jLabel.setText("O優先");
                }
                else{
                    jLabel.setText("X優先");
                }
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        jButton_OX[i][j].setEnabled(true);
                        jButton_OX[i][j].setText("");
                    }
                }
            }
        });
        jButton_Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new MainFrame();
                dispose();
            }
        });
    }

    private void checkStat() {
        /* --------------行判斷-----------------*/
        if (jButton_OX[0][0].getText().equals(jButton_OX[0][1].getText()) &&
                jButton_OX[0][0].getText().equals(jButton_OX[0][2].getText()) &&
                !jButton_OX[0][0].getText().equals(""))
        {
            JOptionPane(0,0);
        }
        else if( jButton_OX[1][0].getText().equals(jButton_OX[1][1].getText()) &&
                jButton_OX[1][0].getText().equals(jButton_OX[1][2].getText()) &&
                !jButton_OX[1][0].getText().equals(""))
        {
            JOptionPane(1,0);
        }
        else if(jButton_OX[2][0].getText().equals(jButton_OX[2][1].getText()) &&
                jButton_OX[2][0].getText().equals(jButton_OX[2][2].getText()) &&
                !jButton_OX[2][0].getText().equals(""))
        {
            JOptionPane(2,0);
        }
        /* --------------直判斷-----------------*/
        else if (jButton_OX[0][0].getText().equals(jButton_OX[1][0].getText()) &&
                jButton_OX[0][0].getText().equals(jButton_OX[2][0].getText()) &&
                !jButton_OX[0][0].getText().equals(""))
        {
            JOptionPane(0,0);
        }
        else if (jButton_OX[0][1].getText().equals(jButton_OX[1][1].getText()) &&
                jButton_OX[0][1].getText().equals(jButton_OX[2][1].getText()) &&
                !jButton_OX[0][1].getText().equals(""))
        {
            JOptionPane(0,1);
        }
        else if (jButton_OX[0][2].getText().equals(jButton_OX[1][2].getText()) &&
                jButton_OX[0][2].getText().equals(jButton_OX[2][2].getText()) &&
                !jButton_OX[0][2].getText().equals(""))
        {
            JOptionPane(0,2);
        }
        /* --------------斜判斷-----------------*/
        else if (jButton_OX[0][0].getText().equals(jButton_OX[1][1].getText()) &&
                jButton_OX[0][0].getText().equals(jButton_OX[2][2].getText()) &&
                !jButton_OX[0][0].getText().equals(""))
        {
            JOptionPane(0,0);
        }
        else if (jButton_OX[0][2].getText().equals(jButton_OX[1][1].getText()) &&
                jButton_OX[0][2].getText().equals(jButton_OX[2][0].getText()) &&
                !jButton_OX[0][2].getText().equals(""))
        {
            JOptionPane(0,2);
        }
        else
        {
            int aa=9;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(jButton_OX[i][j].getText().length()!=0){
                        aa--;
                    }
                }
            }
            if(aa==0){
                jButton_OX_EnabledFalse();
                JOptionPane.showMessageDialog(OOXX.this,  "平手");
            }
        }
    }

    public void JOptionPane(int i,int j){
        JOptionPane.showMessageDialog(OOXX.this,  jButton_OX[i][j].getText()+"贏了!!");
        jButton_OX_EnabledFalse();
    }

    public void jButton_OX_EnabledFalse(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Boolean_sequence = !Boolean_sequence;
                Boolean_flag = Boolean_sequence;
                jButton_OX[i][j].setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        new OOXX();
    }

}