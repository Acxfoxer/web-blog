import { ResponseResult } from "@/model";
import request from "@/utils/request";
import { AxiosPromise } from "axios";
import { ScrollWord } from "./types";

/**
 * 获取名句,tips信息
 * @returns 名句,tips信息
 */
export function getRandomScrollWord(): AxiosPromise<ResponseResult<ScrollWord>> {
  return request({
    url: "/scrollWord/getDictum",
    method: "get",
  });
}

