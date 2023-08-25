import { Result } from "@/model";
import request from "@/utils/request";
import { AxiosPromise } from "axios";
import { OutPut } from "./types";

/**
 * 获取名句,tips信息
 * @returns 名句,tips信息
 */
export function getRandomOutPut(): AxiosPromise<OutPut> {
  return request({
    url: "/output/getDictum",
    method: "get",
  });
}

