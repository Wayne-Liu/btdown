package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wayne.btdown.service.BillingSubBillService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BillingSubBillTest {

    @Autowired
    BillingSubBillService billingSubBillService;

    @Test
    public void test1() {
        billingSubBillService.getRecord(2);
        //billingSubBillService.getRecord(2);
    }
}
