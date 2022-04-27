package com.miladro.simplgateway.dal.repository;

import com.miladro.simplgateway.dal.entity.ApiCallRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface APICallsRepository extends PagingAndSortingRepository<ApiCallRequest, String> {
    List<ApiCallRequest> findAllByIpIsAndAndTimeBetween(String ip, LocalDateTime from, LocalDateTime to);
}
