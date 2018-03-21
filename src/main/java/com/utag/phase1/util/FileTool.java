package com.utag.phase1.util;

/**
 * 读写文件的工具类，读文件返回list便于将jsonStr 转化为 java bean
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTool {

    private static final String prefixPath = "src/main/resources/static/data/";

    public static boolean writeFile(String fileName, String content) throws IOException{

        try {
            String filePath = prefixPath + fileName;

            File file = new File(filePath);
            FileWriter writer = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.write(content);
            printWriter.println();
            writer.close();
            printWriter.close();

            return true;
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return false;
    }


    public static List<String> readFile(String fileName) throws IOException{
        List<String> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(new File(prefixPath + fileName));
            BufferedReader reader = new BufferedReader(fileReader);
            String str = null;
            while ((str = reader.readLine()) != null) {
                list.add(str);
            }
            reader.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return list;
    }

    public static boolean rewriteFile(String fileName, ArrayList<String> contentList) throws IOException{
        try {
            String filePath = prefixPath + fileName;

            File file = new File(filePath);
            FileWriter writer = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(writer);

            for (String content: contentList){
                printWriter.write(content);
                printWriter.println();
            }
            writer.close();
            printWriter.close();

            return true;
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return false;
    }


}
