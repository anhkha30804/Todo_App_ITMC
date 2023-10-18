package com.todo.demo.entity;

import com.todo.demo.common.Priority;
import com.todo.demo.common.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Status status;

    private Priority priority;

    private String title;

    private LocalDate startDay;

    private LocalDate finishDay;

    private String note;

}
