package view;

import javax.swing.*;
// вывод сообщений предупрждений
public class PrintMessages {
    //нет введенного сообщения
    public void NoMessage(){
        JOptionPane.showMessageDialog(null,"Вы не ввели сообщение!");
    }
    // нет имени индетификатора
    public void NoName(){
        JOptionPane.showMessageDialog(null,"Вы не ввели имя!");
    }
}