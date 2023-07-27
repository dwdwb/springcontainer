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
	
	public void insert(Ch13Board board) {
		sst.insert(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.insert", 
			board
		);
	}
	
	public List<Ch13Board> selectAll() {
		List<Ch13Board> list = sst.selectList(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.selectAll"
		);
		for(Ch13Board board : list) {
			log.info(board.toString());
		}
		return list;
	}

	public void updateByBno() {
		List<Ch13Board> list = selectAll();
		Ch13Board board = list.get(0);
		board.setBtitle("변경제목");
		board.setBcontent("변경내용");
		
		sst.update(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.updateByBno",
			board
		);
	}

	public void deleteByBno() {
		int bno = 2;
		sst.delete(
			"com.mycompany.springcontainer.dao.mybatis.Ch13BoardDao.deleteByBno",
			bno
		);
	}
}
