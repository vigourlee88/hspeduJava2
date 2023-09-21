package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(22);
        book.setType("测试数据abcdefg");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(21);
    }

    @Test
    void testGetAll(){
//     System.out.println(bookDao.selectList(null));
       bookDao.selectList(null);
    }

    @Test
    void testGetPage(){//分页要和MP拦截器一起使用
        IPage page = new Page(2,5);
        bookDao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        String name = "1";
        //进行语法检查
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        //if(name != null) lqw.like(Book::getName,name);
        lqw.like(name != null,Book::getName,name);
        bookDao.selectList(lqw);
    }

}










