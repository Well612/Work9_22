import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Work9_22 extends JFrame {
    public Work9_22 (){ init(); }

    private Container cp;
    private int buttonText = 1;     //提供按鈕 文字 及 指令
    private String password = "1234567";    //預設密碼
    private JButton jButton_Clear = new JButton("清除");
    private JButton jButton_Input[][] = new JButton[4][3];
    private JPasswordField jPasswordField = new JPasswordField();
    private JLabel jLabel =new JLabel("");
    private JPanel jPanel_Input = new JPanel(new GridLayout(3,4,3,3));
    private JPanel jPanel_passdword = new JPanel(new GridLayout(1,2,3,3));

    private void init(){
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(200,40,800,500);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout());
        /*-------------------NORTH-------------------*/
        jPanel_passdword.add(jPasswordField);
        jPanel_passdword.add(jButton_Clear);
        jPanel_passdword.setPreferredSize(new Dimension(800,70));
        jPasswordField.setFont(new Font(null,Font.ITALIC,40));
        jButton_Clear.setFont(new Font(null,Font.BOLD,48));
        jButton_Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPasswordField.setText("");
                jLabel.setText("");
                jLabel.setBackground(Color.PINK);
            }
        });
        /*-------------------SOUTH-------------------*/
        jLabel.setPreferredSize(new Dimension(800,100));
        jLabel.setFont(new Font(null,Font.BOLD,30));
        jLabel.setOpaque(true);
        jLabel.setBackground(Color.PINK);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        /*-------------------CENTER-------------------*/
        for(int i=0;i<=3;i++){          //雙for迴圈建立Button
            for(int j=0;j<=2;j++){
                jButton_Input[i][j] = new JButton();
                jButton_Input[i][j].setFont(new Font(null,Font.BOLD,48));
                jButton_Input[i][j].setText(Integer.toString(buttonText));
                jPanel_Input.add(jButton_Input[i][j]);
                jButton_Input[i][j].setActionCommand(Integer.toString(buttonText)); //設定按鈕指令,利用buttonText

                /*-------------------Set 1~9 ActionListener-------------------*/
                if(i<3){
                    jButton_Input[i][j].addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jPasswordField.setText(String.valueOf(jPasswordField.getPassword())+e.getActionCommand());
                            //設定密碼文字 = 將密碼字元轉字串 + 使用者輸入指令
                        }
                    });
                }
                buttonText++;
            }
        }
        /*-------------------Set 0-送出-離開 ActionListener-------------------*/
        jButton_Input[3][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jPasswordField.setText(String.valueOf(jPasswordField.getPassword())+"0");
            }
        });
        jButton_Input[3][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(String.valueOf(jPasswordField.getPassword()).equals(password)){
                    jLabel.setText("成功    密碼為 : "+ String.valueOf(jPasswordField.getPassword()));
                    jLabel.setBackground(new Color(50, 202, 75));
                    jLabel.setForeground(Color.BLACK);
                }
                else {
                    jLabel.setText("密碼錯誤    本次輸入為 : " + String.valueOf(jPasswordField.getPassword()));
                    jLabel.setBackground(new Color(202, 23, 18));
                    jLabel.setForeground(Color.WHITE);
                }
            }
        });
        jButton_Input[3][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        jButton_Input[3][0].setText("0");
        jButton_Input[3][1].setText("送出");
        jButton_Input[3][2].setText("Exit");
        /*-------------------cp.add-------------------*/
        cp.add(jPanel_passdword,BorderLayout.NORTH);
        cp.add(jPanel_Input,BorderLayout.CENTER);
        cp.add(jLabel,BorderLayout.SOUTH);
    }
    public static void main(String[] args) {
        Work9_22 a = new Work9_22();
        a.setVisible(true);
    }
}