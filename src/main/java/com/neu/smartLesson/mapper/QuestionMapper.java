package com.neu.smartLesson.mapper;

import com.neu.smartLesson.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Optional;

@Mapper
public interface QuestionMapper {
    void insertQuestion(Question question);
    int updateQuestion(Question question);
    void deleteQuestionById(@Param("questionId") Integer questionId);
    Optional<Question> findQuestionById(@Param("questionId") Integer questionId);
    List<Question> findQuestionsByCourseId(@Param("courseId") Integer courseId);
}