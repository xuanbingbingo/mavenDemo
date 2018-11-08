package com.imooc.shop.service;

import com.imooc.shop.bean.Article;
import com.imooc.shop.bean.ArticleType;
import com.imooc.shop.utils.Pager;

import java.util.List;
import java.util.Map;

public interface ShopService {
    List<ArticleType> getArticleTypes();

    Map<String,Object> login(String loginName, String passWord);

    List<ArticleType> loadFirstArticleTypes();

    List<Article> searchArticles(String typeCode, String secondType , String title , Pager pager);

    List<ArticleType> loadSecondTypes(String typeCode);

    void deleteById(String id);

    Article getArticleById(String id);

    void updateArticle(Article article);

    void saveArticle(Article article);
}
