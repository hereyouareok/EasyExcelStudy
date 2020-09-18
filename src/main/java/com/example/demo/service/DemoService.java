package com.example.demo.service;



import com.example.demo.entity.DemoData;

import java.util.List;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/9/17 21:39
 **/
public interface DemoService {
    //导入
    boolean save(List<DemoData> list);
    //导出
    List<DemoData> data(String typeIndex);
}
