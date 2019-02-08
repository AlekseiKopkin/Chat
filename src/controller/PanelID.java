package controller;

import javax.swing.*;

public class PanelID {
    public static JButton enterChat;
    public static JTextField chooseUserName;

    public static JTextField getTextField(){
        chooseUserName = new JTextField("Enter desired username");
        chooseUserName.setBounds(15, 20, 250, 50);
        return chooseUserName;
    }
    public static JButton getButton(){
        enterChat = new JButton("Enter Chat");
        enterChat.setBounds(80, 80, 120, 40);
        return  enterChat;
    }
}
