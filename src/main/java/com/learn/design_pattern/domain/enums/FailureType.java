package com.learn.design_pattern.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum FailureType {
    NETWORK, TIMEOUT, RATE_LIMIT, INSUFFICIENT_FUNDS, INVALID_ID_REQUEST, FRAUD, UNKNOWN
}
