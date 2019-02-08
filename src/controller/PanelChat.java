package controller;

import javax.swing.*;

public class PanelChat {
    public static JButton buttonOk;
    public static JTextField textField;
    public static JTextArea textArea;
    public static JScrollPane scrollPane;

    public static JScrollPane getTextArea(){
        textArea=new JTextArea();
        textArea.setEnabled(false);
        scrollPane=new JScrollPane(textArea);
        scrollPane.setBounds(10,10,400,100);
        return scrollPane;
    }
    public static JTextField getTextField(){
        textField=new JTextField(PanelID.chooseUserName.getText()+":");
        textField.setBounds(10,120,250,50);
        return textField;
    }
    public static JButton getButton(){
        buttonOk = new JButton("ok");
        buttonOk.setBounds(270, 130, 120, 40);
        return buttonOk;
    }
}
