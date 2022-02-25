import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FooterComponent } from './home-page/footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VerticalNavbarComponent } from './dashboard/vertical-navbar/vertical-navbar.component';


import { ConfigurationComponent } from './dashboard/configuration/configuration.component';
import { AppRoutingModule } from './app-routing.module';
import { SocietyComponent } from './dashboard/configuration/society/society.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserComponent } from './dashboard/configuration/user/user.component';
import { TowerComponent } from './dashboard/configuration/society/tower/tower.component';
import { TowerListComponent } from './dashboard/configuration/society/tower-list/tower-list.component';
import { FlatComponent } from './dashboard/configuration/society/tower/flat/flat.component';
import { NewUserComponent } from './dashboard/configuration/user/new-user/new-user.component';

import { HttpClientModule , HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from './modals/modal/modal.component';
import { AddSocietyComponent } from './modals/societymodal/add-society/add-society.component';
import { AddTowerComponent } from './modals/towermodals/add-tower/add-tower.component';
import { FlatmodalsComponent } from './modals/flatmodals/flatmodals.component';
import { RoleComponent } from './dashboard/configuration/user/role/role.component';
import { MenuComponent } from './dashboard/configuration/menu/menu.component';
import { MenuSecurityComponent } from './dashboard/configuration/menu-security/menu-security.component';
//import { EditRoleComponent } from './dashboard/configuration/user/edit-role/edit-role.component';
import { RoleModalComponent } from './modals/roleModals/role-modal/role-modal.component';
import { NewRoleModalComponent } from './modals/roleModals/new-role-modal/new-role-modal.component';
import { EditUserModalComponent } from './dashboard/configuration/user/edit-user-modal/edit-user-modal.component';
import { FlatDetailsComponent } from './dashboard/configuration/user/flat-details/flat-details.component';
import { NewFlatModalComponent } from './modals/flatmodals/new-flat-modal/new-flat-modal.component';
import { FlatEditModalComponent } from './modals/flatmodals/flat-edit-modal/flat-edit-modal.component';
import {MatIconModule} from '@angular/material/icon';
import { MatSliderModule } from '@angular/material/slider';
import { PutTokenService } from 'src/token-interceptor.service';
import { ForgotPasswordModalComponent } from './modals/forgot-password-modal/forgot-password-modal.component';



@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    FooterComponent,
    DashboardComponent,
    VerticalNavbarComponent,
    ConfigurationComponent,
    SocietyComponent,
    UserComponent,
    TowerComponent,
    TowerListComponent,
    FlatComponent,
    NewUserComponent,
    ModalComponent,
    AddSocietyComponent,
    AddTowerComponent,
    FlatmodalsComponent,
    RoleComponent,
    MenuComponent,
    MenuSecurityComponent,
    RoleModalComponent,
    NewRoleModalComponent,
    EditUserModalComponent,
    FlatDetailsComponent,
    NewFlatModalComponent,
    FlatEditModalComponent,
    ForgotPasswordModalComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    MatIconModule
    
  ],
  providers:[
     { provide: HTTP_INTERCEPTORS, useClass: PutTokenService, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
