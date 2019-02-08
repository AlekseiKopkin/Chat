package view;

import controller.Action;

import javax.swing.*;
import java.awt.*;

import static controller.PanelChat.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
// фрейм для чата
public class FrameChat {

    public FrameChat(){
        JFrame preFrame = new JFrame("Chat");
        preFrame.add(getTextField());
        preFrame.add(getButton());
        preFrame.add(getTextArea(),BorderLayout.CENTER);
        preFrame.setSize(450, 240);
        preFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        preFrame.setLayout(null);
        preFrame.setVisible(true);
        new Action().ActionChat();
    }
}
