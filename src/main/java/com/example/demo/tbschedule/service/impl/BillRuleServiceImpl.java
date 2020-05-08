package com.example.demo.tbschedule.service.impl;

import com.example.demo.tbschedule.demain.BillRule;
import com.example.demo.tbschedule.service.BillRuleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillRuleServiceImpl implements BillRuleService {
    @Override
    public List<BillRule> getBillRules(int mod, List<Integer> remainder, int topNum) {
        return BillRuleDao.getAll().stream()
                .filter(user -> remainder.contains(user.getId() % mod) && user.getIsDel().equals("0"))
                .limit(topNum)
                .collect(Collectors.toList());
    }


    static class BillRuleDao {
        private static ArrayList<BillRule> billRules;

        private static List<BillRule> getAll() {
            if (null == billRules) {
                billRules = new ArrayList<>(10);
                billRules.add(new BillRule(1,"zhangsan","0"));
                billRules.add(new BillRule(2,"lisi","0"));
                billRules.add(new BillRule(3,"job","0"));
                billRules.add(new BillRule(4,"way","1"));
                billRules.add(new BillRule(5,"bush","0"));
                billRules.add(new BillRule(6,"hh","1"));
                billRules.add(new BillRule(7,"liang","1"));
                billRules.add(new BillRule(8,"wozhu","0"));
                billRules.add(new BillRule(9,"yuan","0"));
                billRules.add(new BillRule(10,"wuzetian","0"));
            }
            return billRules;
        }
    }
}
