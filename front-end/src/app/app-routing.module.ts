import { NgModule } from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import { ConfigurationComponent } from "./dashboard/configuration/configuration.component";
import { SocietyComponent } from "./dashboard/configuration/society/society.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { HomePageComponent } from "./home-page/home-page.component";


const appRoutes:Route[] = [
    {path:'',component: HomePageComponent},
    {path:'dashboard',component: DashboardComponent,
      children:[
        {
          path:'configuration',component:ConfigurationComponent,
          children:[
            {path:'society',component:SocietyComponent}
          ]
        }
      ]
    },
    
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