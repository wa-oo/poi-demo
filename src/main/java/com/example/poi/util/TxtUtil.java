package com.example.poi.util;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

/**
 * 读取文本文件，并去除重复字段
 *
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/14
 */
public class TxtUtil {
    public void readTxtFile(String filePath) {
        try {
            String encoding = "UTF-8";
            File file = new File(filePath);
            // 判断文件是否存在
            if (file.isFile() && file.exists()) {
                InputStreamReader read = new InputStreamReader(
                        // 考虑到编码格式
                        new FileInputStream(file), encoding);
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                ArrayList<String> ayyarsListText = new ArrayList<String>();
                // 得到文件中的数据
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    ayyarsListText.add(lineTxt);
                }
                read.close();
                ArrayList<String> resultList = new ArrayList<String>();
                FileListUtil fileListUtilTest = new FileListUtil();
                PrintStream mytxt=new PrintStream("D:\\log1.txt");
                // 去除文件中的重复数据
                for (String item : ayyarsListText) {
                    if (!resultList.contains(item)) {
                        resultList.add(item);
                        fileListUtilTest.OutWrite(item);
                    }
                }
                System.out.println("结果:" + resultList);
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
    }

    @Test
    public void testReadFile() {
        String filePath = "d:\\log.txt";
        readTxtFile(filePath);
    }

}
