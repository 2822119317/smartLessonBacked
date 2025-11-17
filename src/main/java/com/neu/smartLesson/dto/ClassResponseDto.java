package com.neu.smartLesson.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 查看班级时 (US-T06) 返回的响应 DTO
 */
@Data
@Builder
public class ClassResponseDto {
    private Integer classId;
    private Integer courseId;
    private String className;
    private Integer teacherId;
    private String semester;
}