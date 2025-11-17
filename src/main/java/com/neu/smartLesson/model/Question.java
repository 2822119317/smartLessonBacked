package com.neu.smartLesson.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * 对应数据库 'Questions' 表的 POJO (题干)
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Integer questionId;
    private Integer courseId;
    private String prompt; // 题干
    private QuestionType questionType;
    private Difficulty difficulty;
    private Boolean supportsAiGrading;
    private Integer creatorId;
}