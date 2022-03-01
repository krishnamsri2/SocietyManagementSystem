import { NgModule } from "@angular/core";
import {Route, RouterModule} from "@angular/router";
import { ConfigurationComponent } from "./dashboard/configuration/configuration.component";
import { MenuSecurityComponent } from "./dashboard/configuration/menu-security/menu-security.component";
import { MenuComponent } from "./dashboard/configuration/menu/menu.component";
import { RoleComponent } from "./dashboard/configuration/user/role/role.component";

import { SocietyComponent } from "./dashboard/configuration/society/society.component";
import { TowerListComponent } from "./dashboard/configuration/society/tower-list/tower-list.component";
import { FlatComponent } from "./dashboard/configuration/society/tower/flat/flat.component";
import { TowerComponent } from "./dashboard/configuration/society/tower/tower.component";
import { FlatDetailsComponent } from "./dashboard/configuration/user/flat-details/flat-details.component";
//import { EditRoleComponent } from "./dashboard/configuration/user/edit-role/edit-role.component";

import { NewUserComponent } from "./dashboard/configuration/user/new-user/new-user.component";
import { UserComponent } from "./dashboard/configuration/user/user.component";
import { DashboardComponent } from "./dashboard/dashboard.component";
import { HomePageComponent } from "./home-page/home-page.component";
import { ResetPasswordComponent } from "./modals/authentication/reset-password/reset-password.component";
import { ProfileComponent } from "./dashboard/vertical-navbar/profile/profile.component";




const appRoutes:Route[] = [
    {path:'',component: HomePageComponent},
    { path: 'reset_password/:email',component : ResetPasswordComponent},
    {path:'dashboard',component: DashboardComponent,
      children:[
         { path: 'profile', component: ProfileComponent },
        {
          path:'configuration',component:ConfigurationComponent,
          children:[
            { path: 'user', component: UserComponent,children : [
              { path : 'new_user', component : NewUserComponent},
              { path: 'role/:userDetailId', component: RoleComponent},
              { path: 'flat_details/:userDetailId', component : FlatDetailsComponent}
            ]},

            {path:'society',component:SocietyComponent,children:[
              {path:'towerlist',component:TowerListComponent},
              {path:'towerlist/:id',component:TowerComponent,children:[
                {path:'flat/:id',component:FlatComponent}
              ]}
            ]},
            
            
            { path: 'menu', component: MenuComponent},
            { path: 'menu_security', component: MenuSecurityComponent}
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