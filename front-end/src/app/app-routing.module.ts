import { NgModule } from '@angular/core';
import { Route, RouterModule } from '@angular/router';
import { ConfigurationComponent } from './dashboard/configuration/configuration.component';
import { MenuSecurityComponent } from './dashboard/configuration/menu-security/menu-security.component';
import { MenuComponent } from './dashboard/configuration/menu/menu.component';
import { RoleComponent } from './dashboard/configuration/user/role/role.component';

import { SocietyComponent } from './dashboard/configuration/society/society.component';
import { TowerListComponent } from './dashboard/configuration/society/tower-list/tower-list.component';
import { FlatComponent } from './dashboard/configuration/society/tower/flat/flat.component';
import { TowerComponent } from './dashboard/configuration/society/tower/tower.component';
import { FlatDetailsComponent } from './dashboard/configuration/user/flat-details/flat-details.component';
//import { EditRoleComponent } from "./dashboard/configuration/user/edit-role/edit-role.component";

import { NewUserComponent } from './dashboard/configuration/user/new-user/new-user.component';
import { UserComponent } from './dashboard/configuration/user/user.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ResetPasswordComponent } from './modals/authentication/reset-password/reset-password.component';
import { ProfileComponent } from './dashboard/vertical-navbar/profile/profile.component';
import { AnnouncementComponent } from './dashboard/announcement/announcement.component';
import { NoticeComponent } from './dashboard/notice/notice.component';
import { ShowNoticeComponent } from './dashboard/notice/show-notice/show-notice.component';
import { CreateNoticeComponent } from './dashboard/notice/create-notice/create-notice.component';

const appRoutes: Route[] = [
  { path: '', component: HomePageComponent },
  { path: 'reset_password/:email', component: ResetPasswordComponent },
  {
    path: 'dashboard',
    component: DashboardComponent,
    children: [
      { path: 'profile', component: ProfileComponent },
      { path: 'announcement', component: AnnouncementComponent },
      {
        path: 'configuration',
        component: ConfigurationComponent,
        children: [
          {
            path: 'user',
            component: UserComponent,
            children: [
              { path: 'new_user', component: NewUserComponent },
              { path: 'role/:userDetailId', component: RoleComponent },
              {
                path: 'flat_details/:userDetailId',
                component: FlatDetailsComponent,
              },
            ],
          },

          {
            path: 'society',
            component: SocietyComponent,
            children: [
              {
                path: 'towerlist/:id',
                component: TowerListComponent,
                children: [{ path: 'tower/:id', component: TowerComponent }],
              },
            ],
          },

          { path: 'menu', component: MenuComponent },
          { path: 'menu_security', component: MenuSecurityComponent },
        ],
      },
      { path: 'notice', component: NoticeComponent,children:[
        {path:'showNotice',component:ShowNoticeComponent},
        {path:'createNotice',component:CreateNoticeComponent},
      ] },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
