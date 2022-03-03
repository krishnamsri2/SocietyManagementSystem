export class AnnouncementModel{
    private announcementId:number;
    private announcementDetail:string;
    public serialNo:string;

    constructor(announcementId:string,announcementDetail:string){
        this.announcementId = +announcementId;
        this.announcementDetail = announcementDetail
    }
}