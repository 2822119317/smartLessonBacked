package com.neu.smartLesson.model;

import lombok.Builder;
import lombok.Data;

/**
 * 对应数据库 'QuestionOptions' 表的 POJO
 */
@Data
@Builder
public class QuestionOption {
    private Integer optionId;
    private Integer questionId;
    private String optionText;
    private Boolean isCorrect;
}