import { NgModule } from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import { ConfigurationComponent } from "./dashboard/configuration/configuration.component";
import { SocietyComponent } from "./dashboard/configuration/society/society.component";
import { TowerListComponent } from "./dashboard/configuration/society/tower-list/tower-list.component";
import { FlatComponent } from "./dashboard/configuration/society/tower/flat/flat.component";
import { TowerComponent } from "./dashboard/configuration/society/tower/tower.component";
import { NewUserComponent } from "./dashboard/configuration/user/new-user/new-user.component";
import { UserComponent } from "./dashboard/configuration/user/user.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { HomePageComponent } from "./home-page/home-page.component";


const appRoutes:Route[] = [
    {path:'',component: HomePageComponent},
    {path:'dashboard',component: DashboardComponent,
      children:[
        {
          path:'configuration',component:ConfigurationComponent,
          children:[
            { path: 'user', component: UserComponent},
            {path:'society',component:SocietyComponent,children:[
              {path:'towerlist/:id',component:TowerListComponent,children:[
                {path:'tower/:id',component:TowerComponent}
              ]},
              // {path:'towerlist/:id',component:TowerComponent,children:[
              //   {path:'flat/:id',component:FlatComponent}
              // ]}
            ]},
            {path:'user',component:UserComponent, children : [
              { path : 'new_user', component : NewUserComponent}
            ]},
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