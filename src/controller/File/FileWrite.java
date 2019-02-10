package controller.File;

import controller.PanelChat;

import java.io.*;

public class FileWrite {
    // записать чата в файл
    public FileWrite(){
        try {
            FileWriter writer = new FileWriter("name.txt", true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(PanelChat.textField.getText()+"\r\n");
            bufferWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
