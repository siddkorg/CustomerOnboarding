package com.bank.customer.onboarding.controller;

import com.bank.customer.onboarding.model.overview.OverviewResponseDetails;
import com.bank.customer.onboarding.service.OverviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Overview controller.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
@RestController
@RequestMapping("/bank/v1/overview")
@RequiredArgsConstructor
public class OverviewController {

    @Autowired
    OverviewService overviewService;

    /**
     * Gets customer.
     *
     * @param username the username
     * @return the customer
     */
    @RequestMapping(value = {"/{username}"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<OverviewResponseDetails> getCustomerAccountDetails(@PathVariable(value = "username", required = true) String username) {

        OverviewResponseDetails overviewResponseDetails = overviewService.getCustomerAccountDetails(username);
        return new ResponseEntity<>(overviewResponseDetails, HttpStatus.OK);
    }

}
