package com.example.demo.tbschedule.service;

import com.example.demo.tbschedule.demain.BillRule;

import java.util.List;

public interface BillRuleService {

    List<BillRule> getBillRules(int mod, List<Integer> remainder, int topNum);
}
