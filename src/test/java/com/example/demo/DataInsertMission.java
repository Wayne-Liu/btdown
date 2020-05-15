package com.example.demo;

import org.wayne.btdown.domain.BillingSubBill;
import org.wayne.btdown.service.BillingSubBillService;

public class DataInsertMission implements Runnable {

    private int id;
    private int count;
    private BillingSubBillService billingSubBillService;

    public DataInsertMission(int id, int count, BillingSubBillService billingSubBillService) {
        this.id = id;
        this.count = count;
        this.billingSubBillService = billingSubBillService;
    }

    @Override
    public void run() {

        for (int i=0; i<count; i++) {
            id ++;
            String formula = "[{\"key\":\"m\",\"unit\":\"\",\"value\":1.0}]";
            BillingSubBill billingSubBill = new BillingSubBill();
            billingSubBill.setId(id);
            billingSubBill.setBillId(id);
            billingSubBill.setFormula(formula);

            billingSubBillService.addRecord(billingSubBill);
        }

    }
}
