export class ComponentModel{
    private name : string;
    private relativeUrl? : string; 

    constructor( name :string , relativeUrl? : string){
        this.name=name;
        this.relativeUrl=relativeUrl;
    }
}