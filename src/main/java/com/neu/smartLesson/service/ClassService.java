package com.neu.smartLesson.service;

import com.neu.smartLesson.dto.ClassResponseDto;
import com.neu.smartLesson.dto.CreateClassRequestDto;

import java.util.List;

public interface ClassService {

    /**
     * 教师为课程创建新班级 (US-T05)
     * @param requestDto 班级信息
     * @param courseId 班级所属的课程ID
     * @param teacherId 创建者 (教师) 的 ID
     * @return 创建成功的班级信息
     */
    ClassResponseDto createClass(CreateClassRequestDto requestDto, Integer courseId, Integer teacherId);

    /**
     * 获取指定课程下的所有班级 (US-T06)
     * @param courseId 课程的 ID
     * @return 班级 DTO 列表
     */
    List<ClassResponseDto> getClassesForCourse(Integer courseId);
}