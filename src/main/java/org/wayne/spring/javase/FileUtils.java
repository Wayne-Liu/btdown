package org.wayne.spring.javase;

import java.io.*;

public class FileUtils {

    public static void decodeFile(String path) {
        File file = new File(path);

        try {
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(path+"en");
            int b = 0;
            int b1 = 0;
            while ((b = fis.read()) != -1) {
                fos.write(b ^ 2);
            }
            fos.close();
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
