package com.neu.smartLesson.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 创建班级时 (US-T05) 的请求 DTO
 */
@Data
public class CreateClassRequestDto {

    @NotBlank(message = "班级名称不能为空")
    private String className;

    private String semester;
}