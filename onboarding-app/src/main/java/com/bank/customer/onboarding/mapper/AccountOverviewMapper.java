package com.bank.customer.onboarding.mapper;

import com.bank.customer.onboarding.model.overview.OverviewResponseDetails;
import com.bank.customer.onboarding.repository.entity.CustomerAccountOverview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * The interface Account overview mapper.
 *
 * @author siddharthkorgaonkar  18/06/2023
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountOverviewMapper {

    /**
     * The constant MAPPER.
     */
    AccountOverviewMapper MAPPER = Mappers.getMapper(AccountOverviewMapper.class);

    /**
     * To map overview response details.
     *
     * @param customerAccountOverview the customer account overview
     * @return the overview response details
     */
    @Mapping(target = "accountNumber", source = "account")
    @Mapping(target = "accountType", source = "type")
    @Mapping(target = "currency", source = "currency")
    @Mapping(target = "balance", source = "balance")
    @Mapping(target = "accountCreationTime", source = "datetime")
    OverviewResponseDetails toMAP(CustomerAccountOverview customerAccountOverview);
}
