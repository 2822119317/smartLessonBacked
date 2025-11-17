package com.neu.smartLesson.mapper;

import com.neu.smartLesson.dto.ClassResponseDto;
import com.neu.smartLesson.model.CourseClass;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClassDtoMapper {

    public ClassResponseDto toClassResponseDto(CourseClass courseClass) {
        if (courseClass == null) {
            return null;
        }
        return ClassResponseDto.builder()
                .classId(courseClass.getClassId())
                .courseId(courseClass.getCourseId())
                .className(courseClass.getClassName())
                .teacherId(courseClass.getTeacherId())
                .semester(courseClass.getSemester())
                .build();
    }

    public List<ClassResponseDto> toClassResponseDtoList(List<CourseClass> classes) {
        return classes.stream()
                .map(this::toClassResponseDto)
                .collect(Collectors.toList());
    }
}