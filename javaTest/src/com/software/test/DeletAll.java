package com.software.test;

import java.io.File;

public class DeletAll {
    public static void main(String[] args) {
        File allfile = new File("C:\\aswrok");
        boolean isdelete = deleteDirAll(allfile);
        for (int i = 0; i < 10; i++) {
            System.out.println("---------是否成功--------" + isdelete);
        }
    }
    public static boolean deleteDirAll(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDirAll(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        System.out.println("删除文件夹===" + dir.getAbsoluteFile());
        return dir.delete();
    }
}
