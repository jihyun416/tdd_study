package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount()==100000 ? 12 : payData.getPayAmount()/10000;
        if(payData.getFirstBillingDate()!=null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        }
        return payData.getBillingDate().plusMonths(addedMonths);
    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
        if(!isSameDayOfMonth(candidateExp, payData.getFirstBillingDate())) {
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp);
            if(dayLenOfCandiMon<dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    private boolean isSameDayOfMonth(LocalDate localDate1, LocalDate localDate2) {
        if(localDate1.getDayOfMonth()==localDate2.getDayOfMonth()) {
            return true;
        }
        return false;
    }

    private int lastDayOfMonth(LocalDate localDate) {
        return YearMonth.from(localDate).lengthOfMonth();
    }

}
