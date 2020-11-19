package com.guagua.test;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Copyright (C), 2020-2020, guagua
 *
 * @author lxc
 * Date: 2020/11/18 11:00
 * Version: 1.0.0
 * Description:
 * History:
 * <author> <time> <version> <desc>
 */
public class Utils {

    private static List<AndroidDanBean> androidDanList = new ArrayList<>();
    private static List<AndroidDanBean> compileDanList = new ArrayList<>();
    private static List<AndroidDanBean> compileDuoList = new ArrayList<>();
    private static List<CompilePdBean> compilePdList = new ArrayList<>();
    private static List<CompilePdBean> compileTkList = new ArrayList<>();

    public synchronized static List<AndroidDanBean> getAndroidSingle(Context context) {
        if (androidDanList.size() > 0) {
            return androidDanList;
        }
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(context.getAssets().open("android_single.xls"));
            Sheet sheet = workbook.getSheet(0);
            int row = 0;
            int i = 1;
            while (i < sheet.getRows()) {
                androidDanList.add(new AndroidDanBean(sheet.getCell(6, i).getContents(), sheet.getCell(9, i).getContents(),
                        sheet.getCell(10, i).getContents(), sheet.getCell(11, i).getContents(),
                        sheet.getCell(12, i).getContents(), "", sheet.getCell(14, i).getContents()));
                //获取每一行的单元格
                Log.e("getAndroidSingle", "get" + sheet.getCell(6, i).getContents());
                Log.e("getAndroidSingle", "get" + sheet.getCell(9, i).getContents());
                Log.e("getAndroidSingle", "get" + sheet.getCell(10, i).getContents());
                Log.e("getAndroidSingle", "get" + sheet.getCell(11, i).getContents());
                Log.e("getAndroidSingle", "get" + sheet.getCell(12, i).getContents());
                Log.e("getAndroidSingle", "get" + sheet.getCell(14, i).getContents());
                i++;
                row++;
            }
            workbook.close();
            Log.e("getAndroidSingle", "row : " + row);
        } catch (IOException e) {
            Log.e("getAndroidSingle", "exception message: " + e.getMessage());
            e.printStackTrace();
            workbook.close();
        } catch (BiffException e) {
            Log.e("getAndroidSingle", "exception message: " + e.getMessage());
            e.printStackTrace();
            workbook.close();
        }
        return androidDanList;
    }

    public synchronized static List<AndroidDanBean> getCompileDan(Context context) {
        if (compileDanList.size() > 0) {
            return compileDanList;
        }
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(context.getAssets().open("bianyi_danx.xls"));
            Sheet sheet = workbook.getSheet(0);
            int row = 0;
            int i = 1;
            while (i < sheet.getRows()) {
                compileDanList.add(new AndroidDanBean(sheet.getCell(6, i).getContents(), sheet.getCell(9, i).getContents(),
                        sheet.getCell(10, i).getContents(), sheet.getCell(11, i).getContents(),
                        sheet.getCell(12, i).getContents(), "", sheet.getCell(14, i).getContents()));
                //获取每一行的单元格
                Log.e("getCompileDan", "get" + sheet.getCell(6, i).getContents());
                Log.e("getCompileDan", "get" + sheet.getCell(9, i).getContents());
                Log.e("getCompileDan", "get" + sheet.getCell(10, i).getContents());
                Log.e("getCompileDan", "get" + sheet.getCell(11, i).getContents());
                Log.e("getCompileDan", "get" + sheet.getCell(12, i).getContents());
                Log.e("getCompileDan", "get" + sheet.getCell(14, i).getContents());
                i++;
                row++;
            }
            workbook.close();
            Log.e("getCompileDan", "row : " + row);
        } catch (IOException e) {
            Log.e("getCompileDan", "exception message: " + e.getMessage());
            e.printStackTrace();
            workbook.close();
        } catch (BiffException e) {
            Log.e("getCompileDan", "exception message: " + e.getMessage());
            e.printStackTrace();
            workbook.close();
        }
        return compileDanList;
    }

    public synchronized static List<AndroidDanBean> getCompileDuo(Context context) {
        if (compileDuoList.size() > 0) {
            return compileDuoList;
        }
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(context.getAssets().open("bianyi_duox.xls"));
            Sheet sheet = workbook.getSheet(0);
            int i = 1;
            while (i < sheet.getRows()) {
                compileDuoList.add(new AndroidDanBean(sheet.getCell(6, i).getContents(), sheet.getCell(9, i).getContents(),
                        sheet.getCell(10, i).getContents(), sheet.getCell(11, i).getContents(),
                        sheet.getCell(12, i).getContents(),sheet.getCell(13, i).getContents(),  sheet.getCell(14, i).getContents()));
                //获取每一行的单元格
                Log.e("getCompileDuo", "get" + sheet.getCell(6, i).getContents());
                Log.e("getCompileDuo", "get" + sheet.getCell(9, i).getContents());
                Log.e("getCompileDuo", "get" + sheet.getCell(10, i).getContents());
                Log.e("getCompileDuo", "get" + sheet.getCell(11, i).getContents());
                Log.e("getCompileDuo", "get" + sheet.getCell(12, i).getContents());
                Log.e("getCompileDuo", "get" + sheet.getCell(14, i).getContents());
                i++;
            }
            workbook.close();
        } catch (IOException e) {
            Log.e("getCompileDuo", "exception message: " + e.getMessage());
            e.printStackTrace();
            workbook.close();
        } catch (BiffException e) {
            Log.e("getCompileDuo", "exception message: " + e.getMessage());
            e.printStackTrace();
            workbook.close();
        }
        return compileDuoList;
    }

    public synchronized static List<CompilePdBean> getCompilePd(Context context, String fileName) {
        if ("bianyi_pd.xls".equals(fileName)) {
            if (compilePdList.size() > 0) {
                return compilePdList;
            }
        } else {
            if (compileTkList.size() > 0) {
                return compileTkList;
            }
        }
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(context.getAssets().open(fileName));
            Sheet sheet = workbook.getSheet(0);
            int i = 1;
            while (i < sheet.getRows()) {
                if ("bianyi_pd.xls".equals(fileName)) {
                    compilePdList.add(new CompilePdBean(sheet.getCell(6, i).getContents(), sheet.getCell(9, i).getContents()));
                } else {
                    compileTkList.add(new CompilePdBean(sheet.getCell(6, i).getContents(), sheet.getCell(9, i).getContents()));
                }

                //获取每一行的单元格
                Log.e("getCompilePd", "get" + sheet.getCell(6, i).getContents());
                Log.e("getCompilePd", "get" + sheet.getCell(9, i).getContents());
                i++;
            }
            workbook.close();
        } catch (IOException e) {
            Log.e("getCompilePd", "exception message: " + e.getMessage());
            e.printStackTrace();
            workbook.close();
        } catch (BiffException e) {
            Log.e("getCompilePd", "exception message: " + e.getMessage());
            e.printStackTrace();
            workbook.close();
        }

        if ("bianyi_pd.xls".equals(fileName)) {
            return compilePdList;
        } else {
            return compileTkList;
        }
    }
}
