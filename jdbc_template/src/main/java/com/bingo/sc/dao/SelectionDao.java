package com.bingo.sc.dao;

import com.bingo.entity.Selection;

import java.util.List;
import java.util.Map;

public interface SelectionDao {

    public void insert(List<Selection> seles);
    public void delete(int sid,int cid);
    public List<Map<String,Object>> selectByStudent(int sid);
    public List<Map<String,Object>> selectByCourse(int cid);


}
