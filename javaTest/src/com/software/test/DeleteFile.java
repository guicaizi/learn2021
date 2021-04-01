package com.software.test;

import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File allfile = new File("D:\\software\\heiheziapp\\Hbijiawang2\\Hbijiawang");
        boolean isdelete = deleteDir(allfile);
        for (int i = 0; i < 10; i++) {
            System.out.println("---------是否成功--------" + isdelete);
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        if (dir.getName().equals("build")) {
            deleteDirAll(dir);
        } else if (dir.getName().equals(".idea")) {
            if (dir.isDirectory()) {
                deleteDirAll(dir);
            }
        } else if (dir.getName().equals(".gradle")) {
            if (dir.isDirectory()) {
                deleteDirAll(dir);
            }
        } else {
            if (islocalfile(dir.getName(), ".iml")) {
                System.out.println("删除文件" + dir.getAbsoluteFile());
                dir.delete();
            }
            if (islocalfile(dir.getName(), "local.properties")) {
                System.out.println("删除文件" + dir.getAbsoluteFile());
                dir.delete();
            }
        }
        return true;
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

    public static boolean isimlfile(String name) {
        if (name.contains(".iml")) {
            int end = name.lastIndexOf(".iml");
            if (end == name.length() - 4) {

                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public static boolean islocalfile(String name, String deletname) {
        if (name.contains(deletname)) {
            int end = name.lastIndexOf(deletname);
            if (end == name.length() - deletname.length()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }
}
