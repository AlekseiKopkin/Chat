package controller.File;

import java.io.*;

public class CheckFile {
    //Есть данные в файле
    public int CheckingEmptinessFile() {
        try {
            if(new CheckFile().CreateNewFile()) {
                //создаем объект FileReader для объекта File
                FileReader fr = new FileReader("name.txt");
                //создаем BufferedReader с существующего FileReader для построчного считывания
                BufferedReader reader = new BufferedReader(fr);
                // считаем сначала первую строку
                String line = reader.readLine();
                if (line.length() > 1) {
                    return 1;
                } else {
                    return 0;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return 0;
        }
    }
    // Существует ли файл
    public boolean ExistFile() {
        String filename="name.txt";
        final File file = new File(filename);
        if (file.exists()) {
            return  true;
        } else {
            return  false;
        }
    }

    private boolean CreateNewFile(){
        //Указываем только имя файла
        File file = new File("name.txt");
        try {
            if(file.createNewFile()){
                return false;
            }
            else {
                return true;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            return false;
        }
    }
}