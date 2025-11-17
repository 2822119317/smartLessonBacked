package com.neu.smartLesson.service.impl;

import com.neu.smartLesson.dto.ClassResponseDto;
import com.neu.smartLesson.dto.CreateClassRequestDto;
import com.neu.smartLesson.mapper.ClassDtoMapper;
import com.neu.smartLesson.mapper.ClassMapper;
import com.neu.smartLesson.model.CourseClass;
import com.neu.smartLesson.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Autowired
    private ClassDtoMapper classDtoMapper;

    @Override
    public ClassResponseDto createClass(CreateClassRequestDto requestDto, Integer courseId, Integer teacherId) {

        CourseClass newClass = CourseClass.builder()
                .courseId(courseId)
                .className(requestDto.getClassName())
                .semester(requestDto.getSemester())
                .teacherId(teacherId)
                .build();

        classMapper.insertClass(newClass);

        return classDtoMapper.toClassResponseDto(newClass);
    }

    @Override
    public List<ClassResponseDto> getClassesForCourse(Integer courseId) {

        List<CourseClass> classes = classMapper.findClassesByCourseId(courseId);

        return classDtoMapper.toClassResponseDtoList(classes);
    }
}