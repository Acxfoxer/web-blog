/**
 * 首页滚动输出字体信息
 */
export interface OutPut {
   /**
     * id
     */
    id:number;
   /**
    *  信息uuid
    */
    uuid: string;
   /**
    *  名言,警句
    */
    dictum: string;
   /**
    * 句子类型
    */
    type: string;
   /**
    * 来源
    */
    fromWhere: string;
   /**
    * 作者
    */
    fromWho: string;
   /**
    * 创建人
    */
    creator: string;
   /**
    * 创建用户的id
    */
    creatorUid: string;
   /**
    * 查看数量
    */
    reviewer: number;
   /**
    * 提交信息
    */
    commitFrom: string;
   /**
    * 创建日期
    */
    createdAt:Date;
   /**
    * 长度
    */
    length:Number;
}
