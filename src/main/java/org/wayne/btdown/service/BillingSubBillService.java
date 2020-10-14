package org.wayne.btdown.service;

import org.wayne.btdown.domain.BillingSubBill;

public interface BillingSubBillService {

    int addRecord(BillingSubBill billingSubBill);

    BillingSubBill getRecord(long id);
}
