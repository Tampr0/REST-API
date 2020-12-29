package com.crud.tasks.domain;

import lombok.*;

@AllArgsConstructor
@Getter
public class TaskDto {
    private Long id;
    private String title;
    private String content;
}
