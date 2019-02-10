package controller.File;

import controller.PanelChat;

import java.io.*;

public class ReadFile {
    public ReadFile() {
        try {
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader("name.txt");
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                PanelChat.textArea.setText(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    PanelChat.textArea.setText(PanelChat.textArea.getText() + "\n" + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}