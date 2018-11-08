package com.imooc.shop.repository;

import com.imooc.shop.bean.ArticleType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ArticleTypeMapper 数据访问类
 */
public interface ArticleTypeMapper {

    @Select("select * from ec_article_type where code = #{xxxx}")
    ArticleType getTypeByCode(String typeCode);

    @Select("select * from ec_article_type")
    List<ArticleType> getArticleTypes();

    @Select("select * from ec_article_type where length(code) = 4")
    List<ArticleType> getFirstArticleTypes();

    @Select("select * from ec_article_type where code like #{typeCode} and length(code) = #{len} ")
    List<ArticleType> loadSecondTypes(@Param("typeCode") String typeCode, @Param("len") int i);
}