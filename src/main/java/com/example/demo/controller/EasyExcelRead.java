package com.example.demo.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;

import com.example.demo.entity.DemoData;
import com.example.demo.excel.DemoDataListener;
import com.example.demo.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/9/17 20:52
 **/
@RestController
@RequestMapping("test/")
public class EasyExcelRead {

    @Resource
    private DemoService demoService;

    /*
     * 导入
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), DemoData.class, new DemoDataListener(demoService)).sheet().doRead();
        return "success";
    }

    /*
     * 导出
     */
    @GetMapping("download")
    public void download(HttpServletResponse response, String typeIndex) throws IOException {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            // 这里需要设置不关闭流
            String fileName = URLEncoder.encode("导出模板", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), DemoData.class).autoCloseStream(Boolean.FALSE).sheet("模板").doWrite(demoService.data(typeIndex));
        } catch (Exception e) {
            // 重置response
            response.reset();
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            Map<String, String> map = new HashMap<String, String>();
            map.put("status", "failure");
            map.put("message", "下载文件失败" + e.getMessage());
            response.getWriter().println(JSON.toJSONString(map));
        }


    }
}
