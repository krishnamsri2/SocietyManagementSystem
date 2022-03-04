export class NoticeModel{
    private noticeDetail:string;
    private userId:number;
    private serialNo:string;
    constructor(noticeDetail:string,userId:string){
        this.noticeDetail = noticeDetail;
        this.userId = +userId;
    }
}