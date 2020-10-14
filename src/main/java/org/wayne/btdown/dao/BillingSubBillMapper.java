package org.wayne.btdown.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.wayne.btdown.domain.BillingSubBill;

//@Mapper
//@Component
public interface BillingSubBillMapper {

    int insertBill(BillingSubBill billingSubBill);

    BillingSubBill selectOne(long id);
}
