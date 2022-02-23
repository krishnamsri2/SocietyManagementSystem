export class MenuModel{
    private url:string;
    private flatId:number;
    private serialNo:string;
    public menuDetail:string;
    constructor(url:string,flatId:string,menuDetail:string){
        this.menuDetail = menuDetail;
        this.url = url;
        this.flatId = +flatId;
    }
}