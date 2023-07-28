package com.mycompany.springcontainer.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.springcontainer.dto.Ch13Board;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class Ch13BoardDaoOld {
	@Autowired
	private SqlSessionTemplate sst;
	
	public int insert(Ch13Board board) {
		/*
		 1) com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao: Mapper XML 선택
		    ==> com.mycompany.springcontainer.dao.Ch13BoardDao 수정!
		 2) .insert: Mapper XML 안에 선언된 ID
		 3) 리턴값: 실제 테이블에 반영된 행의 수
		 */
		int rows = sst.insert(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.insert", 
			board
		);
		return rows;
	}
	
	public List<Ch13Board> selectAll() {
		List<Ch13Board> list = sst.selectList(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.selectAll"
		);
		return list;
	}
	
	public Ch13Board selectByBno(int bno) {
		Ch13Board board = sst.selectOne(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.selectByBno",
			bno
		);
		return board;
	}

	public int updateByBno(Ch13Board board) {
		int rows = sst.update(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.updateByBno",
			board
		);
		return rows;
	}

	public int deleteByBno(int bno) {
		int rows = sst.delete(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.deleteByBno",
			bno
		);
		return rows;
	}
}
