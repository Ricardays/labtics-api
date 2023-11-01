package com.zenithdev.labtics.domain.exam;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public enum ExamType {
    NUMERIC,
    ALPHANUMERIC,
    SELECTOR,
    CHECK
}
