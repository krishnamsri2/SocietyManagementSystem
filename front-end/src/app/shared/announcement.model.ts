export class AnnouncementModel{
    private announcementId:number;
    public announcementTitle:string;
    private announcementDetail:string;
    public serialNo:string;

    constructor(announcementId:string,announcementTitle:string,announcementDetail:string){
        this.announcementId = +announcementId;
        this.announcementTitle = announcementTitle;
        this.announcementDetail = announcementDetail
    }
}