export class MenuModel{
    private url:string;
    public menuId:number;
    private serialNo:string;
    public menuName:string;
    constructor(url:string,menuId:string,menuName:string){
        this.menuName = menuName;
        this.url = url;
        this.menuId = +menuId;
    }
}