package org.wayne.btdown.domain;

import java.math.BigDecimal;
import java.util.Date;

public class BillingSubBill {
    private long id;
    private String pin;
    private long billId;
    private Date startTime;
    private Date endTime;
    private int site;
    private String region;
    private String appCode;
    private String resourceId;
    private int billingType;
    private String formula;
    private BigDecimal billFee;
    private BigDecimal billFee2;
    private BigDecimal discountFee;
    private String cashCouponId;
    private BigDecimal cashCouponFee;
    private BigDecimal balancePayFee;
    private BigDecimal cashPayFee;
    private Date settleTime;
    private Date billTime;
    private String transactionNo;
    private String refundNo;
    private String org;
    private int payState;
    private int payResult;
    private Date payTime;
    private int isDeleted;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public int getBillingType() {
        return billingType;
    }

    public void setBillingType(int billingType) {
        this.billingType = billingType;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public BigDecimal getBillFee() {
        return billFee;
    }

    public void setBillFee(BigDecimal billFee) {
        this.billFee = billFee;
    }

    public BigDecimal getBillFee2() {
        return billFee2;
    }

    public void setBillFee2(BigDecimal billFee2) {
        this.billFee2 = billFee2;
    }

    public BigDecimal getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee) {
        this.discountFee = discountFee;
    }

    public String getCashCouponId() {
        return cashCouponId;
    }

    public void setCashCouponId(String cashCouponId) {
        this.cashCouponId = cashCouponId;
    }

    public BigDecimal getCashCouponFee() {
        return cashCouponFee;
    }

    public void setCashCouponFee(BigDecimal cashCouponFee) {
        this.cashCouponFee = cashCouponFee;
    }

    public BigDecimal getBalancePayFee() {
        return balancePayFee;
    }

    public void setBalancePayFee(BigDecimal balancePayFee) {
        this.balancePayFee = balancePayFee;
    }

    public BigDecimal getCashPayFee() {
        return cashPayFee;
    }

    public void setCashPayFee(BigDecimal cashPayFee) {
        this.cashPayFee = cashPayFee;
    }

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public int getPayState() {
        return payState;
    }

    public void setPayState(int payState) {
        this.payState = payState;
    }

    public int getPayResult() {
        return payResult;
    }

    public void setPayResult(int payResult) {
        this.payResult = payResult;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "BillingSubBill{" +
                "id=" + id +
                ", pin='" + pin + '\'' +
                ", billId=" + billId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", site=" + site +
                ", region='" + region + '\'' +
                ", appCode='" + appCode + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", billingType=" + billingType +
                ", formula='" + formula + '\'' +
                ", billFee=" + billFee +
                ", billFee2=" + billFee2 +
                ", discountFee=" + discountFee +
                ", cashCouponId='" + cashCouponId + '\'' +
                ", cashCouponFee=" + cashCouponFee +
                ", balancePayFee=" + balancePayFee +
                ", cashPayFee=" + cashPayFee +
                ", settleTime=" + settleTime +
                ", billTime=" + billTime +
                ", transactionNo='" + transactionNo + '\'' +
                ", refundNo='" + refundNo + '\'' +
                ", org='" + org + '\'' +
                ", payState=" + payState +
                ", payResult=" + payResult +
                ", payTime=" + payTime +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
