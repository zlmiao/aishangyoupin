package com.taotao.content.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * 内容处理的接口
 * @title ContentService.java
 * <p>description</p>
 * <p>company: www.itheima.com</p>
 * @author ljh 
 * @version 1.0
 */
public interface ContentService {
	/**
	 * 插入内容表
	 * @param content
	 * @return
	 */
	public TaotaoResult saveContent(TbContent content);
    /**
     * 根据内容分类的ID 查询其下的内容列表
     * @param categoryId
     * @return
     */
    public List<TbContent> getContentListByCatId(Long categoryId);
}
