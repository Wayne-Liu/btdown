package org.wayne.spring.javase;

import java.io.*;

public class DiskClassLoader extends ClassLoader {

    private String mLibPath;

    public DiskClassLoader(String mLibPath) {
        this.mLibPath = mLibPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        String fileName = getFileName(name);

        File file = new File(mLibPath, fileName);

        try {
            FileInputStream fis = new FileInputStream(file);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len = 0;
            try {
                while ((len = fis.read()) != -1) {
                    bos.write(len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            byte[] data = bos.toByteArray();
            fis.close();
            bos.close();

            return defineClass(name, data, 0, data.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private String getFileName(String name) {
        int index = name.lastIndexOf(".");

        if (index == -1) {
            return name+".class";
        } else {
            return name.substring(index+1)+".class";
        }
    }
}
