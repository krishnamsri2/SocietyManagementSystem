export class TowerModel{
    private serialNo:string;
    private towerId:number;
    private soc:number;
    private towerName:string;

    constructor(towerId:number,serialNo:string,towerName:string,soc:number){
        this.towerId=towerId;
        this.serialNo = serialNo;
        this.soc = soc;
        this.towerName = towerName;
    }
}