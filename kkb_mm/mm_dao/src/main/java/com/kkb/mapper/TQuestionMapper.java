package com.kkb.mapper;

import com.kkb.pojo.TQuestion;
import com.kkb.pojo.TQuestionExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TQuestionMapper {
    long countByExample(TQuestionExample example);

    int deleteByExample(TQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    // add new question
    int insert(TQuestion record);

    int insertSelective(TQuestion record);

    List<TQuestion> selectByExampleWithBLOBs(TQuestionExample example);

    List<TQuestion> selectByExample(TQuestionExample example);

    TQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    int updateByExampleWithBLOBs(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    int updateByExample(@Param("record") TQuestion record, @Param("example") TQuestionExample example);

    // update question as necessary
    int updateByPrimaryKeySelective(TQuestion record);

    int updateByPrimaryKeyWithBLOBs(TQuestion record);

    int updateByPrimaryKey(TQuestion record);

    List<TQuestion> selectIsClassicByPage(@Param("params") Map<String, Object> map);
}