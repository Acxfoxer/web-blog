import { PageQuery, PageResult, ResponseResult } from "@/model";
import request from "@/utils/request";
import { AxiosPromise } from "axios";
import { Article, ArticleInfo, ArticleRecommend, ArticleSearch } from "./types";

/**
 * 查看文章列表
 * @param params 查询条件
 * @returns 文章列表
 */
export function getArticleList(params: PageQuery): AxiosPromise<ResponseResult<PageResult<Article[]>>> {
  return request({
    url: "/article/articleList",
    method: "get",
    params,
  });
}

/**
 * 查看文章
 * @param articleId 文章id
 */
export function getArticle(articleId: number): AxiosPromise<ResponseResult<ArticleInfo>> {
  return request({
    url: `/article/${articleId}`,
    method: "get",
  });
}

/**
 * 查看推荐文章
 * @returns 推荐文章
 */
export function getArticleRecommend(): AxiosPromise<ResponseResult<ArticleRecommend[]>> {
  return request({
    url: "/article/recommend",
    method: "get",
  });
}

/**
 * 搜索文章
 * @returns 文章列表
 */
export function searchArticle(keyword: string): AxiosPromise<ResponseResult<ArticleSearch[]>> {
  return request({
    url: "/article/search",
    method: "get",
    params: {
      keyword,
    },
  });
}

/**
 * 点赞文章
 * @param articleId 文章id
 */
export function likeArticle(articleId: number): AxiosPromise<ResponseResult<null>> {
  return request({
    url: `/article/${articleId}/like`,
    method: "post",
  });
}
