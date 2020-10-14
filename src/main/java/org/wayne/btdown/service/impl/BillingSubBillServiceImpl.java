package org.wayne.btdown.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.wayne.btdown.dao.BillingSubBillMapper;
import org.wayne.btdown.domain.BillingSubBill;
import org.wayne.btdown.service.BillingSubBillService;

@Service
public class BillingSubBillServiceImpl implements BillingSubBillService {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BillingSubBillMapper billingSubBillMapper;

    @Override
    public int addRecord(BillingSubBill billingSubBill) {
        logger.info("billingSubBill id:{}", billingSubBill.getId());
        return billingSubBillMapper.insertBill(billingSubBill);
    }

    @Override
    @Transactional
    public BillingSubBill getRecord(long id) {
        BillingSubBill billingSubBill1 = billingSubBillMapper.selectOne(2);
        BillingSubBill billingSubBill2 = billingSubBillMapper.selectOne(3);
        System.out.println(billingSubBill1.getId());
        System.out.println(billingSubBill2.getId());
        return null;
    }


}
