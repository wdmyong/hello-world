package com.what;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdmyong on 2017/11/3.
 */
public class FileTest {
    public static void main(String[] args) throws Exception {
        File file = new File("/Users/duanyong/Documents/wdmyong/yun-s45/author.log");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        List<Long> authorIds = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            long authorId = Long.parseLong(line);
            authorIds.add(authorId);
        }
        System.out.println(authorIds.size());
    }
}
