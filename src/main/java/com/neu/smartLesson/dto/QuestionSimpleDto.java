package com.neu.smartLesson.dto;

import com.neu.smartLesson.model.Difficulty;
import com.neu.smartLesson.model.QuestionType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionSimpleDto {
    private Integer questionId;
    private String prompt;
    private QuestionType questionType;
    private Difficulty difficulty;
}