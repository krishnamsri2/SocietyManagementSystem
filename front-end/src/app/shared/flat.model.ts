export class FlatModel{
    private flatNo:string;
    private serialNo:string;
    private flatId:number;
    private numberOfOccupant:number;
    private status:boolean;

    constructor(flatNo:string,numberOfOccupant:string,status:boolean){
        this.flatNo = flatNo;
        this.numberOfOccupant = +numberOfOccupant;
        this.status = status;
    }
}