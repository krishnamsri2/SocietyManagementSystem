import { Injectable } from "@angular/core";

@Injectable({
    providedIn:'root'
})
export class ReloadService{
    reload:boolean;
    doReload(){
        this.reload = true;
    }
    dontReload(){
        this.reload = false;
    }
}