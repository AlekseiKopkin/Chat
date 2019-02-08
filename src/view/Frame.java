package view;

import javax.swing.*;


public class Frame extends JFrame {
    private static FrameID frameID;
    private static FrameChat frameChat;

    public static FrameID getFrameID() {
        if (frameID == null) {
            frameID = new FrameID();
        }
        return frameID;
    }

    public static FrameChat getFrameChat() {
        if (frameChat == null) {
            frameID.dispose();
            frameChat = new FrameChat();
        }
        return frameChat;
    }
}
