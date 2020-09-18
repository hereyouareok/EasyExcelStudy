package com.example.demo.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

import java.util.Date;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/9/17 19:28
 **/
@Data
@ContentRowHeight(20)
@HeadRowHeight(20)
@ColumnWidth(15)
public class DemoData {

    /**
    * 设置excel表头名称
    */
    @ExcelProperty(value = "学生编号",index = 0)
    private Integer sno;

    @ExcelProperty(value = "学生姓名",index = 1)
    private String sname;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(value = "日期",index = 2 )
    private Date loanBeginDate;

}
