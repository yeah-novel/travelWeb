package com.example.travel.dao;

import com.example.travel.domain.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {

	public List<Comment> getCommentBySpotid(Long spotid);//根据景点编号筛选评论
	
	public List<Comment> getCommentById(Long id);
	
	public int deleteCommentByContent(String content);//根据评论内容删除评论
}
