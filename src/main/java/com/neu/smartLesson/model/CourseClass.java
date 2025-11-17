package com.neu.smartLesson.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseClass {

    private Integer classId;

    private Integer courseId;

    private String className;

    private Integer teacherId;

    private String semester;
}