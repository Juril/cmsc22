/**
 * Created by Juril on 10/28/2016.
 */
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.math.BigDecimal;

public class JCalculator extends JFrame {
    private JButton clear;
    private JButton posneg;
    private JButton percent;
    private JButton divide;
    private JButton mult;
    private JButton minus;
    private JButton add;
    private JButton equals;
    private JButton point;
    private JButton numbers[];
    private JTextArea txtArea;
    private JPanel buttons;
    private BigDecimal ans = BigDecimal.valueOf(0);
    private BigDecimal perc = BigDecimal.valueOf(100);
    private BigDecimal neg = BigDecimal.valueOf(-1);
    private int temp = 0;
    private int choice = 0;
    private boolean isClicked = false;
    private boolean flag = false;

    JCalculator() {
        buttons = new JPanel();
        //setting the grid
        buttons.setLayout(new GridLayout(5, 4));

        //creating different colors
        Color bgColor = new Color(150, 150, 150);
        Color btnsColor = new Color(245, 146, 62);
        Color topColor = new Color(224, 224, 224);
        Color numColor = new Color(214, 214, 214);

        //creating the buttons and text area
        clear = new JButton("AC");
        posneg = new JButton("+/-");
        percent = new JButton("%");
        divide = new JButton("÷");
        mult = new JButton("×");
        minus = new JButton("–");
        add = new JButton("+");
        equals = new JButton("=");
        point = new JButton(".");
        numbers = new JButton[11];
        txtArea = new JTextArea();

        //setting the number buttons and their bgcolor and font
        for(int i = 0; i <= 10; i++){
            if(i!=10) {
                numbers[i] = new JButton(String.valueOf(i));
                numbers[i].setBackground(numColor);
                numbers[i].setFont(new Font("Arial", Font.PLAIN, 24));
            }
            else{
                numbers[i] = new JButton("");
                numbers[i].setBackground(numColor);
            }
        }
        //setting the text area
        txtArea.setBackground(bgColor);
        txtArea.setPreferredSize(new Dimension(1, 100));
        txtArea.setLineWrap(true);
        txtArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        txtArea.setFont(new Font("Helvetica", Font.PLAIN, 36));

        //AC button
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.setText(null);
                ans = BigDecimal.valueOf(0);
                temp = 0;
                flag = false;
                choice = 0;
                isClicked = false;
            }
        });

        //+/- button
        posneg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isClicked || txtArea.getText().contains(".")){
                    ans = BigDecimal.valueOf(Double.parseDouble(txtArea.getText()));
                }
                else{
                    ans = BigDecimal.valueOf(Long.parseLong(txtArea.getText()));
                }
                ans = ans.multiply(neg);
                txtArea.setText(String.valueOf(ans));
            }
        });

        //percentage button
        percent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isClicked || txtArea.getText().contains(".")) {
                    ans = BigDecimal.valueOf(Double.parseDouble(txtArea.getText()));
                    ans = ans.divide(perc, 2, BigDecimal.ROUND_HALF_UP);
                }
                else{
                    ans = BigDecimal.valueOf(Long.parseLong(txtArea.getText()));
                    ans = ans.divide(perc, 2, BigDecimal.ROUND_HALF_UP);
                }
                txtArea.append("%");

                System.out.println(ans);
                isClicked = false;
                choice = 5;
            }
        });

        //divide button
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (temp != 0 && flag == false) {
                    ans = ans.divide(BigDecimal.valueOf(Double.parseDouble(txtArea.getText())), 10, BigDecimal.ROUND_HALF_UP);
                } else {
                    ans = BigDecimal.valueOf(Double.parseDouble(txtArea.getText()));
                    temp++;
                }
                choice = 4;
                txtArea.setText(null);
            }
        });

        //multiply button
        mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isClicked || txtArea.getText().contains(".")) {
                    if (temp != 0 && flag == false) {
                        ans = ans.multiply(BigDecimal.valueOf(Double.parseDouble(txtArea.getText())));
                    } else {
                        ans = BigDecimal.valueOf(Double.parseDouble(txtArea.getText()));
                        temp++;
                    }
                }
                else{
                    if (temp != 0 && flag == false) {
                        ans = ans.multiply(BigDecimal.valueOf(Long.parseLong(txtArea.getText())));
                    } else {
                        ans = BigDecimal.valueOf(Long.parseLong(txtArea.getText()));
                        temp++;
                    }
                }
                choice = 3;
                isClicked = false;
                txtArea.setText(null);
            }
        });

        //subtract button
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isClicked || txtArea.getText().contains(".")) {
                    if (temp != 0 && flag == false) {
                        ans = ans.subtract(BigDecimal.valueOf(Double.parseDouble(txtArea.getText())));
                    } else {
                        ans = BigDecimal.valueOf(Double.parseDouble(txtArea.getText()));
                        temp++;
                    }
                }
                else{
                    if (temp != 0 && flag == false) {
                        ans = ans.subtract(BigDecimal.valueOf(Long.parseLong(txtArea.getText())));
                    } else {
                        ans = BigDecimal.valueOf(Long.parseLong(txtArea.getText()));
                        temp++;
                    }
                }
                choice = 2;
                isClicked = false;
                txtArea.setText(null);
            }
        });

        //sum button
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isClicked || txtArea.getText().contains(".")){
                    if (temp != 0 && flag == false) {
                        ans = ans.add(BigDecimal.valueOf(Double.parseDouble(txtArea.getText())));
                    } else {
                        ans = BigDecimal.valueOf(Double.parseDouble(txtArea.getText()));
                        temp++;
                    }
                }
                else {
                    if (temp != 0 && flag == false) {
                        ans = ans.add(BigDecimal.valueOf(Long.parseLong(txtArea.getText())));
                    } else {
                        ans = BigDecimal.valueOf(Long.parseLong(txtArea.getText()));
                        temp++;
                    }
                }
                choice = 1;
                isClicked = false;
                txtArea.setText(null);
            }
        });

        //equal button
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(choice == 1){
                    if(isClicked){
                        ans = ans.add(BigDecimal.valueOf(Double.parseDouble(txtArea.getText())));
                    }
                    else {
                        ans = ans.add(BigDecimal.valueOf(Long.parseLong(txtArea.getText())));
                    }
                }
                else
                if(choice == 2){
                    if(isClicked){
                        ans = ans.subtract(BigDecimal.valueOf(Double.parseDouble(txtArea.getText())));
                    }
                    else{
                        ans = ans.subtract(BigDecimal.valueOf(Long.parseLong(txtArea.getText())));
                    }
                }
                else
                if(choice == 3){
                    if(isClicked) {
                        ans = ans.multiply(BigDecimal.valueOf(Double.parseDouble(txtArea.getText())));
                    }
                    else{
                        ans = ans.multiply(BigDecimal.valueOf(Long.parseLong(txtArea.getText())));

                    }
                }
                else
                if(choice == 4){
                    ans = ans.divide(BigDecimal.valueOf(Double.parseDouble(txtArea.getText())), 10, BigDecimal.ROUND_HALF_UP);

                }
                flag = true;
                txtArea.setText(String.valueOf(ans));
            }
        });
        numbers[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("7");
            }
        });
        numbers[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("8");
            }
        });
        numbers[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("9");
            }
        });
        numbers[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("4");
            }
        });
        numbers[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("5");
            }
        });
        numbers[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("6");
            }
        });
        numbers[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("1");
            }
        });
        numbers[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("2");
            }
        });
        numbers[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("3");
            }
        });
        numbers[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtArea.append("0");
            }
        });
        point.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!isClicked){
                    txtArea.append(".");
                    isClicked = true;
                }
            }
        });

        //setting of bg color, font, etc.
        buttons.add(clear);         clear.setBackground(topColor);      clear.setFont(new Font("Arial", Font.PLAIN, 20));
        buttons.add(posneg);        posneg.setBackground(topColor);     posneg.setFont(new Font("Arial", Font.PLAIN, 20));
        buttons.add(percent);       percent.setBackground(topColor);    percent.setFont(new Font("Arial", Font.PLAIN, 20));
        buttons.add(divide);        divide.setBackground(btnsColor);    divide.setFont(new Font("Arial", Font.PLAIN, 30));      divide.setForeground(Color.WHITE);
        buttons.add(numbers[7]);
        buttons.add(numbers[8]);
        buttons.add(numbers[9]);
        buttons.add(mult);          mult.setBackground(btnsColor);      mult.setFont(new Font("Arial", Font.PLAIN, 30));        mult.setForeground(Color.WHITE);
        buttons.add(numbers[4]);
        buttons.add(numbers[5]);
        buttons.add(numbers[6]);
        buttons.add(minus);         minus.setBackground(btnsColor);     minus.setFont(new Font("Arial", Font.PLAIN, 26));       minus.setForeground(Color.WHITE);
        buttons.add(numbers[1]);
        buttons.add(numbers[2]);
        buttons.add(numbers[3]);
        buttons.add(add);           add.setBackground(btnsColor);       add.setFont(new Font("Arial", Font.PLAIN, 30));         add.setForeground(Color.WHITE);
        buttons.add(numbers[0]);
        buttons.add(numbers[10]);
        buttons.add(point);         point.setBackground(numColor);      point.setFont(new Font("Arial", Font.PLAIN, 24));
        buttons.add(equals);        equals.setBackground(btnsColor);    equals.setFont(new Font("Arial", Font.PLAIN, 30));      equals.setForeground(Color.WHITE);
        buttons.setVisible(true);
        add(buttons, BorderLayout.CENTER);
        add(txtArea, BorderLayout.NORTH);

        setTitle("Calculator");
        setSize(300, 400);
        setVisible(true);
        JOptionPane.showMessageDialog(this,"                 Mini Calculator v1.0 \n \nSTBF (Soon to be fixed): \n1. Negative sign not in its proper position\n2. Text starts from top to bottom (fugly)\n3. Quotient with plenty of trailing zeros\n4. You'll need to clear every time\n\nCreated by Juril Digamon",
                "Welcome!", JOptionPane.YES_NO_OPTION);

    }
    public static void main(String[] args){
        new JCalculator();
    }
}
