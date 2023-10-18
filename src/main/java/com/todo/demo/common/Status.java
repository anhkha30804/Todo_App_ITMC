package com.todo.demo.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    IN_COMPLETE("Chưa hoàn thành"),
    IN_PROGRESS("Đang làm"),
    COMPLETED("Hoàn thành"),
    CANCELLED("Bị hủy"),
    OVERDUE("Quá hạn");

    private final String displayName;

}
