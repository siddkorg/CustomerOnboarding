package com.bank.customer.onboarding.mapper;

import com.bank.customer.onboarding.model.overview.OverviewResponseDetails;
import com.bank.customer.onboarding.repository.entity.CustomerAccountOverview;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author siddharthkorgaonkar
 * 18/06/2023
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountOverviewMapper {

    AccountOverviewMapper MAPPER = Mappers.getMapper(AccountOverviewMapper.class);

    @Mapping(target = "accountNumber", source = "account")
    @Mapping(target = "accountType", source = "type")
    @Mapping(target = "currency", source = "currency")
    @Mapping(target = "balance", source = "balance")
    OverviewResponseDetails toMAP(CustomerAccountOverview customerAccountOverview);
}
