package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.model.Score;

public interface ScoreMapper {


	public List<Score> selectAll();

	
	public int insert(Score s);


	public int delete(@Param("sid")Integer sid,@Param("cid") Integer cid);
}
