export class NoticeModel{
    private noticeId:number;
    private noticeDetail:string;
    private userId:number;
    private serialNo:string;
    public updatedDate?:string;
    constructor(noticeDetail:string,userId:string,noticeId:string,updatedDate?:string){
        this.noticeDetail = noticeDetail;
        this.userId = +userId;
        this.noticeId = +noticeId;
        this.updatedDate = updatedDate;
    }
    getNoticeDetails(){
        return this.noticeDetail;
    }
    getNoticeID(){
        return this.noticeDetail;
    }
}