package com.fang.dbController;

import com.fang.model.Author;

/**
 * 对作者的操作
 * @author fang
 *
 */
public interface AuthorOpration {
   
	/**
	 * 添加一个作者的信息
	 * @param author
	 * @return
	 */
   int addAuthor(Author author);
   
   /**
    * 删除一个作者的信息
    */
   int delAuthor(Author author);
   
   int getAuthorInfo(Author author);
   
   
   
   
    
   
}
