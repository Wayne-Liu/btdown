package com.example.demo.tbschedule.task.vo;

import com.example.demo.tbschedule.demain.BillRule;

import java.io.Serializable;

public class UsageTaskItem implements Serializable {

    private BillRule billRule;

    public UsageTaskItem(BillRule billRule) {
        this.billRule = billRule;
    }

    public BillRule getBillRule() {
        return billRule;
    }

    @Override
    public String toString() {
        return "UsageTaskItem{" +
                "billRule=" + billRule +
                '}';
    }
}
