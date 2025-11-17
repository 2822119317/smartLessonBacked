package com.neu.smartLesson.mapper;

import com.neu.smartLesson.model.QuestionOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface QuestionOptionMapper {
    void insertBatchOptions(@Param("options") List<QuestionOption> options);
    void deleteOptionsByQuestionId(@Param("questionId") Integer questionId);
    List<QuestionOption> findOptionsByQuestionId(@Param("questionId") Integer questionId);
}