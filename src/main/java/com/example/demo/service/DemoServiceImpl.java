package com.example.demo.service;

import com.example.demo.excel.DemoData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YanQin
 * @version v1.0.0
 * @Description : TODO
 * @Create on : 2020/9/17 21:47
 **/
@Service
public class DemoServiceImpl implements DemoService{
    @Override
    public boolean save(List<DemoData> list) {
        return false;
    }

    @Override
    public List<DemoData> data(String typeIndex) {
        List<DemoData> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            DemoData data = new DemoData();
            data.setSno(i);
            data.setSname("宝宝"+i);
            data.setLoanBeginDate(new Date());
            list.add(data);

        }
        return list;
    }
}
