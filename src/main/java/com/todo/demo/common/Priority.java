package com.todo.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {

    IN_DAY("Trong ngày"),
    IN_THREE_DAYS("Trong ba ngày"),
    IN_WEEK("Trong tuần"),
    IN_TWO_WEEKS("Trong hai tuần"),
    IN_MONTH("Trong tháng");

    private final String displayName;

}
