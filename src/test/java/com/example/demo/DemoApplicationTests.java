package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.wayne.btdown.domain.BillingSubBill;
import org.wayne.btdown.service.BillingSubBillService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private BillingSubBillService billingSubBillService;

	@Test
	public void contextLoads() throws InterruptedException {
		int id = 1;
		int count = 10000;

		DataInsertMission d1 = new DataInsertMission(id, count, billingSubBillService);
		DataInsertMission d2 = new DataInsertMission(id+count*1, count, billingSubBillService);
		DataInsertMission d3 = new DataInsertMission(id+count*2, count, billingSubBillService);
		DataInsertMission d4 = new DataInsertMission(id+count*3, count, billingSubBillService);
		DataInsertMission d5 = new DataInsertMission(id+count*4, count, billingSubBillService);
		DataInsertMission d6 = new DataInsertMission(id+count*5, count, billingSubBillService);
		DataInsertMission d7 = new DataInsertMission(id+count*6, count, billingSubBillService);
		DataInsertMission d8 = new DataInsertMission(id+count*7, count, billingSubBillService);
		DataInsertMission d9 = new DataInsertMission(id+count*8, count, billingSubBillService);
		DataInsertMission d10 = new DataInsertMission(id+count*9, count, billingSubBillService);

		Thread t1 = new Thread(d1);
		Thread t2 = new Thread(d2);
		Thread t3 = new Thread(d3);
		Thread t4 = new Thread(d4);
		Thread t5 = new Thread(d5);
		Thread t6 = new Thread(d6);
		Thread t7 = new Thread(d7);
		Thread t8 = new Thread(d8);
		Thread t9 = new Thread(d9);
		Thread t10 = new Thread(d10);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();
		t6.join();
		t7.join();
		t8.join();
		t9.join();
		t10.join();

	}

}
