package com.neu.smartLesson.dto;

import com.neu.smartLesson.model.Difficulty;
import com.neu.smartLesson.model.QuestionType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
public class QuestionFullDto {

    private Integer questionId; // 响应时填充

    @NotBlank(message = "题干 (prompt) 不能为空")
    private String prompt;

    @NotNull(message = "题型 (questionType) 不能为空")
    private QuestionType questionType;

    @NotNull(message = "难度 (difficulty) 不能为空")
    private Difficulty difficulty;

    private Boolean supportsAiGrading; // (US13)

    // (US11, 12) 选项列表 (如果是选择题)
    @Valid // 嵌套校验
    private List<QuestionOptionDto> options;

    // (US11, 12, 13) 关联的知识点
    @NotEmpty(message = "必须至少关联一个知识点")
    private List<Integer> knowledgePointIds;
}