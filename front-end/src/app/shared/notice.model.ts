export class NoticeModel{
    private noticeId:number;
    private noticeDetail:string;
    private userId:number;
    private serialNo:string;
    constructor(noticeDetail:string,userId:string,noticeId:string){
        this.noticeDetail = noticeDetail;
        this.userId = +userId;
        this.noticeId = +noticeId;
    }
    getNoticeDetails(){
        return this.noticeDetail;
    }
    getNoticeID(){
        return this.noticeDetail;
    }
}