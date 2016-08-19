package utils;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WorkWithFiles {

    public static List getListLines(String filePath){
        List list = new ArrayList();
        String line;
        try {
            try (
                    InputStream fis = new FileInputStream(filePath);
                    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
                    BufferedReader br = new BufferedReader(isr)
            ) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    list.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static String directoryOfTest(){
        Properties props = new Properties();
        try {
            props.load(WorkWithFiles.class.getResourceAsStream("/project.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = props.getProperty("project.build.testOutputDirectory");
        String sep = System.getProperty("file.separator");
        return path + sep;
    }
}