package com.example.poi;

import com.example.poi.util.CommonTypes;
import com.example.poi.util.FileListUtil;
import com.example.poi.util.TypesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/20
 */
public class mainTypes {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //获取数据暂存到本地数据库中
        List<String> list = new ArrayList<>();
        FileListUtil fileListUtil = new FileListUtil();
        try {
            fileListUtil.FileList("D:\\王涛\\天津一网通办\\事项模板","D:\\log.txt");
            list = fileListUtil.getList();
        } catch (Exception e) {
            e.printStackTrace();
        }

        TypesUtil typesUtil = new TypesUtil();
        Connection conn = null;
        Class.forName(CommonTypes.DRIVER);
        conn = DriverManager.getConnection(CommonTypes.URL, CommonTypes.USERNAME, CommonTypes.PASSWORD);
        for (int i = 0; i < list.size(); i++) {
            try {
                typesUtil.readExcelToObj(list.get(i),conn);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conn!=null){
                    conn.close();
                }
            }
        }
    }
}
