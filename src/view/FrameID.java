package view;

import controller.Action;

import javax.swing.*;
import java.awt.*;

import static controller.PanelID.*;

// фрейм для индетификатора пользователя
public class FrameID extends JFrame {
    public static JFrame preFrame;

    public FrameID(){
        preFrame = new JFrame("Индетификатор");
        preFrame.add(getTextField(), BorderLayout.CENTER);
        preFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        preFrame.add(getButton());
        preFrame.setSize(300, 200);
        preFrame.setLayout(null);
        preFrame.setVisible(true);
        new Action().ActionId();
    }
}
