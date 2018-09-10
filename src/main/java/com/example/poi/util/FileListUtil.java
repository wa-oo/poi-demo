package com.example.poi.util;

import java.io.*;
import java.util.*;

/**
 * @author wangtaog@mail.taiji.com.cn
 * @date 2018/9/9
 */

    public class FileListUtil {
        private String dir_name=null;
        private String list_name=null;
        private BufferedWriter out = null;
        Vector<String> ver=null;

        public void FileList(String dir_name,String list_name) throws IOException {
            //文件夹地址
            this.dir_name=dir_name;
            //保存文件列表的文件地址
            this.list_name=list_name;
            //用做堆栈
            ver=new Vector<String>();
        }

        public List<String> getList() throws Exception{
            List<String> list = new ArrayList<>();
            //以追加的方式写入到指定的文件
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(list_name, true)));
            ver.add(dir_name);
            while(ver.size()>0){
                //获取该文件夹下所有的文件(夹)名
                File[] files = new File(ver.get(0).toString()).listFiles();
                ver.remove(0);

                int len=files.length;
                for(int i=0;i<len;i++){
                    String tmp=files[i].getAbsolutePath();
                    //如果是目录，则加入队列。以便进行后续处理
                    if(files[i].isDirectory())  {
                        ver.add(tmp);
                    } else{
                        //如果是文件，则直接输出文件名到指定的文件。
                        out.write(tmp+"\r\n");
                        list.add(tmp);
                    }
                }
            }
            out.close();
            return list;
        }

        public void OutWrite(String path) throws FileNotFoundException {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));
            try {
                out.write(path+"\r\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

