package com.henghao.Garden.util;

import com.henghao.Garden.entity.user.Wallet;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.xssf.usermodel.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * function excel工具类
 * <p>
 * date 2017.03.12
 *
 * @author 严彬荣
 */
public class CreateExcelUtil {
    /**
     * 创建CreateExcelUtil类单例
     **/

    private volatile static CreateExcelUtil instance;

    private CreateExcelUtil() {
    }

    public static CreateExcelUtil getInstance() {
        if (instance == null) {
            synchronized (CreateExcelUtil.class) {
                if (instance == null)
                    instance = new CreateExcelUtil();
            }
        }
        return instance;
    }

    // 获取UUID类
    private UUIDUtil uuid = UUIDUtil.getInstance();

    // 下载我的钱包Excel表格方法
    public String downloadWalletExcel(HttpServletRequest req,
                                      List<Wallet> list, String excel) {
        String rootPath = null;
        String tomcatPath = null;
        String excelPath = null;
        String excelFilePath = null;
        String path = null;
        // 获取服务器存放路径
        rootPath = req.getSession().getServletContext().getRealPath("");
        // 截取文件存放服务器路径
        tomcatPath = rootPath.substring(0, rootPath.lastIndexOf("Garden"));
        // 创建Excel文件存放路径
        excelPath = tomcatPath + "gardenFile/excel/";
        File filePath = new File(excelPath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        // 判断服务器是否存在文件
        if (excel == null) {
            // 创建Excel文件
            String path1 = excelPath;
            // 单独定义path2给UUID，防止将值赋给excelFilePath时再次调用getUUID方法导致文件名不一致
            String path2 = this.uuid.getUUID() + ".xlsx";
            excelFilePath = path1 + path2;
            // 用于返回存放数据库文件路径
            path = "gardenFile/excel/" + path2;
        } else {
            // 服务器存在文件之后的路径用于更新文件
            excelFilePath = tomcatPath + excel;
            // 用于返回存放数据库文件路径
            path = excel;
        }
        File file = new File(excelFilePath);
        try {
            // 判断文件是否存在
            if (file.exists()) {
                // 存在则覆盖更新
                file.delete();
                FileOutputStream excelFile = new FileOutputStream(file);
                createHeaderStyle(list).write(excelFile);
                excelFile.close();
            } else {
                // 不存在则创建文件
                FileOutputStream excelFile = new FileOutputStream(file);
                createHeaderStyle(list).write(excelFile);
                excelFile.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return path;
    }

    // 创建EXCEL表样式方法
    private static XSSFWorkbook createHeaderStyle(List<Wallet> list) {
        // 创建一个webbook，对应的一个Excel文件
        XSSFWorkbook wb = new XSSFWorkbook();
        // 在webbook中添加一个sheet，对应Excel文件中的sheet
        XSSFSheet sheet = wb.createSheet("我的钱包记录");
        // 在sheet中添加表头，第0行
        XSSFRow row = sheet.createRow(0);
        // 设置列宽
        sheet.setDefaultColumnWidth(20);
        // 设置行高
        row.setHeight((short) ((short) 16 * 25));
        // 设置表头样式
        XSSFCellStyle style = wb.createCellStyle();
        // 设置居中
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
        // 设置单元格背景颜色
        style.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        style.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);
        // 设置下边框
        style.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        // 设置左边框
        style.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        // 设置右边框
        style.setBorderRight(XSSFCellStyle.BORDER_THIN);
        // 设置上边框
        style.setBorderTop(XSSFCellStyle.BORDER_THIN);
        // 自动换行
        style.setWrapText(true);
        // 设置表样式
        XSSFCellStyle style1 = wb.createCellStyle();
        // 表内容样式
        style1.setAlignment(XSSFCellStyle.ALIGN_CENTER);// 水平居中
        style1.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);// 垂直居中
        // 设置下边框
        style1.setBorderBottom(XSSFCellStyle.BORDER_THIN);
        // 设置左边框
        style1.setBorderLeft(XSSFCellStyle.BORDER_THIN);
        // 设置右边框
        style1.setBorderRight(XSSFCellStyle.BORDER_THIN);
        // 设置上边框
        style1.setBorderTop(XSSFCellStyle.BORDER_THIN);
        // 自动换行
        style1.setWrapText(true);
        // 创建表头字体样式
        XSSFFont font = wb.createFont();
        // 设置字体颜色
        font.setColor(HSSFColor.BLACK.index);
        // 设置字体样式
        font.setFontName("微软雅黑");
        // 设置字体大小
        font.setFontHeightInPoints((short) 12);
        // 设置字体粗细
        font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
        // 把字体应用到当前的样式中
        style.setFont(font);

        // 创建表内容字体样式
        XSSFFont font1 = wb.createFont();
        // 设置字体颜色
        font1.setColor(HSSFColor.BLACK.index);
        // 设置字体样式
        font1.setFontName("微软雅黑");
        // 设置字体大小
        font1.setFontHeightInPoints((short) 11);
        // 设置字体粗细
        font1.setBoldweight(XSSFFont.BOLDWEIGHT_NORMAL);
        // 把字体应用到当前的样式中
        style1.setFont(font1);

        // 创建单元格
        XSSFCell cell = null;
        // 表头
        cell = row.createCell(0);
        cell.setCellValue("记录时间");
        cell.setCellStyle(style);
        cell = row.createCell(1);
        cell.setCellValue("金额");
        cell.setCellStyle(style);
        cell = row.createCell(2);
        cell.setCellValue("收入/支出");
        cell.setCellStyle(style);
        cell = row.createCell(3);
        cell.setCellValue("备注");
        cell.setCellStyle(style);
        // 表内容
        for (int i = 0, length = list.size(); i < length; i++) {
            row = sheet.createRow(i + 1);
            cell = row.createCell(0);
            cell.setCellValue(list.get(i).getTransactionTime());
            cell.setCellStyle(style1);
            cell = row.createCell(1);
            cell.setCellValue(list.get(i).getMoney());
            cell.setCellStyle(style1);
            cell = row.createCell(2);
            if (list.get(i).getTypes() == 0) {
                cell.setCellValue("收入");
            } else if (list.get(i).getTypes() == 1) {
                cell.setCellValue("支出");
            } else {
                cell.setCellValue("");
            }
            cell.setCellStyle(style1);
            cell = row.createCell(3);
            cell.setCellValue(list.get(i).getComment());
            cell.setCellStyle(style1);
        }
        return wb;
    }
}
