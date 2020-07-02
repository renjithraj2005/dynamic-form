package com.demo.form.repository;

import com.demo.form.dao.SurveyAnswerStatistics;
import com.demo.form.model.FilledForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilledFormRepository extends JpaRepository<FilledForm,Integer> {

    @Query(nativeQuery = true, value =
            "SELECT " +
                    "    F.field_id AS field, COUNT(*) AS count " +
                    "FROM " +
                    "    filled_form F " +
                    "WHERE FORM_ID=?1 GROUP BY " +
                    "    F.field_id ORDER BY COUNT(*) DESC")
    List<SurveyAnswerStatistics> findMostAnsweredQuestion(int formId);


    @Query(nativeQuery = true, value =
            "SELECT " +
                    "    F.value AS field, COUNT(*) AS count " +
                    "FROM " +
                    "    filled_form F " +
                    "WHERE FORM_ID=?1 GROUP BY " +
                    "    F.value ORDER BY COUNT(*) DESC")
    List<SurveyAnswerStatistics> findCommonAnswer(int formId);
}
