export class TowerModel{
    private tower_Id:string;
    private towerId:string;
    private parentId:string;
    private towerName:string;
    private towerAddress:string;

    constructor(tower_Id:string,towerId:string,towerName:string,towerAddress:string,parentId:string){
        this.towerId=tower_Id;
        this.towerId = towerId;
        this.parentId = parentId;
        this.towerName = towerName;
        this.towerAddress = towerAddress;
    }
}