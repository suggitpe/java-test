package org.suggs.test.sandbox.concordion.settlement.securitiessettlement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AgencyBusiness extends AbstractSecuritiesSettlementFixture {

    private static final Logger LOG = LoggerFactory.getLogger(AgencyBusiness.class);

    public void createBookingReportsWith(String flowType, Integer quantity) {
        LOG.info("creating a {} for {}", flowType, quantity);
    }

    public String checkThatFundingHasBeenUpdatedWithPending(String text) {
        return text;
    }

    public String checkThatFundingHasBeenUpdatedWithSettled(String text) {
        return text;
    }

    public String checkOpenSettlementRiskPosted(String text) {
        return text;
    }

    public String checkCloseSettlementRiskPosted(String text) {
        return text;
    }

    public String checkBicBalances(String text) {
        return text;
    }

}


