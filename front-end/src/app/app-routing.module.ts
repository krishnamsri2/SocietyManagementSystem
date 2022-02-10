import { NgModule } from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import { ConfigurationComponent } from "./dashboard/configuration/configuration.component";


const appRoutes:Route[] = [
    {path:'',component: ConfigurationComponent},
    
  ]

@NgModule({
  imports:[
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule{

}