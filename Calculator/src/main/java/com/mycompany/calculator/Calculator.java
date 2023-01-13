/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.calculator;

/**
 *
 * @author HP
 */
import java.awt.Font ;
import java.awt.GridLayout ;
import java.awt.event.ActionListener ;
import java.awt.event.ActionEvent ;

import javax.swing.JFrame ;
import javax.swing.JButton ;
import javax.swing.JPanel ;
import javax.swing.JTextField ;


public class Calculator implements ActionListener{
    
    
    JFrame frame ;
    JTextField textField ;
    JButton[] Numberbutton = new JButton[10];
    JButton[] functionbutton = new JButton[9];
    JButton addButton , subButton , mulButton , divButton ;
    JButton decButton , clrButton , delButton , eqlButton , negButton ;
    JPanel panel ;
    
    Font myFont = new Font("serif",Font.BOLD,30);
    double num1 = 0, num2 = 0, result = 0;
    char Operator ;

    
    Calculator(){
        frame =  new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 530);
        frame.setLayout(null);
        
        textField =  new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);
        
         addButton = new JButton("+");
         subButton = new JButton("-");
         mulButton = new JButton("*");
         divButton = new JButton("/");
         decButton = new JButton(".");
         eqlButton = new JButton("=");
         delButton = new JButton("del");
         clrButton = new JButton("clr");
         negButton = new JButton("(-)");
        
        functionbutton[0] = addButton;
        functionbutton[1] = subButton;
        functionbutton[2] = mulButton;
        functionbutton[3] = divButton;
        functionbutton[4] = decButton;
        functionbutton[5] = eqlButton;
        functionbutton[6] = delButton;
        functionbutton[7] = clrButton;
        functionbutton[8] =  negButton;
        
        for(int i = 0; i< 9 ;i++){
            functionbutton[i].addActionListener(this);
            functionbutton[i].setFont(myFont);
            functionbutton[i].setFocusable(false);
        }
         for(int i = 0; i< 10 ;i++){
            Numberbutton[i] = new JButton(String.valueOf(i));
            Numberbutton[i].addActionListener(this);
            Numberbutton[i].setFont(myFont);
            Numberbutton[i].setFocusable(false);
        }
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        
        panel = new JPanel();
        
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10,10));
        
        panel.add(Numberbutton[1]);
        panel.add(Numberbutton[2]);
        panel.add(Numberbutton[3]);
        panel.add(addButton);
        panel.add(Numberbutton[4]);
        panel.add(Numberbutton[5]);
        panel.add(Numberbutton[6]);
        panel.add(subButton);
        panel.add(Numberbutton[7]);
        panel.add(Numberbutton[8]);
        panel.add(Numberbutton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(Numberbutton[0]);
        panel.add(eqlButton);
        panel.add(divButton);
        
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String ar[]){
        Calculator Calculator1 = new Calculator();
    }
    public void actionPerformed(ActionEvent e){
        for(int i = 0; i < 10; i++){
            if(e.getSource() == Numberbutton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
    
        }
         if(e.getSource() == decButton){
                textField.setText(textField.getText().concat("."));
            }
         
         if(e.getSource() == addButton){
               num1 = Double.parseDouble(textField.getText());
               Operator = '+';
               textField.setText("");
            }
         
         if(e.getSource() == subButton){
                num1 = Double.parseDouble(textField.getText());
               Operator = '-';
               textField.setText("");
            }
         if(e.getSource() == mulButton){
               num1 = Double.parseDouble(textField.getText());
               Operator = '*';
               textField.setText("");
            }
         if(e.getSource() == divButton){
               num1 = Double.parseDouble(textField.getText());
               Operator = '/';
               textField.setText("");
            }
         if(e.getSource() == eqlButton){
               num2 = Double.parseDouble(textField.getText());
               
               switch(Operator){
                   case '+':
                       result = num1 + num2 ;
                       break ;
                       
                         case '-':
                       result = num1 - num2 ;
                       break ;
                       
                         case '*':
                       result = num1 * num2 ;
                       break ;
                       
                         case '/':
                       result = num1 / num2 ;
                       break ;
                       
               }
               textField.setText(String.valueOf(result));
               num1 = result ;
            }
         if(e.getSource() == clrButton){
             textField.setText("");
         }
         if(e.getSource() == delButton){
             String temp = textField.getText();
             textField.setText("");
             for(int i=0; i<temp.length()-1; i++){
                 textField.setText(textField.getText() + temp.charAt(i));
             }
            
         }
          if(e.getSource() == negButton){
             double temp = Double.parseDouble(textField.getText());
             temp *= -1 ;
             textField.setText(String.valueOf(temp));
          }
    }
    
}
