import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FooterComponent } from './home-page/footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VerticalNavbarComponent } from './dashboard/vertical-navbar/vertical-navbar.component';

//import {MatIconModule} from '@angular/material/icon';
import { ConfigurationComponent } from './dashboard/configuration/configuration.component';
import { AppRoutingModule } from './app-routing.module';
import { SocietyComponent } from './dashboard/configuration/society/society.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserComponent } from './dashboard/configuration/user/user.component';
import { TowerComponent } from './dashboard/configuration/society/tower/tower.component';
import { TowerListComponent } from './dashboard/configuration/society/tower-list/tower-list.component';
import { FlatComponent } from './dashboard/configuration/society/tower/flat/flat.component';
import { NewUserComponent } from './dashboard/configuration/user/new-user/new-user.component';
import { UserService } from './service/user.service';
import { HttpClientModule , HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ModalComponent } from './modals/modal/modal.component';
import { AddSocietyComponent } from './modals/societymodal/add-society/add-society.component';
import { AddTowerComponent } from './modals/towermodals/add-tower/add-tower.component';
import { FlatmodalsComponent } from './modals/flatmodals/flatmodals.component';
import { RoleComponent } from './dashboard/configuration/role/role.component';
import { MenuComponent } from './dashboard/configuration/menu/menu.component';
import { MenuSecurityComponent } from './dashboard/configuration/menu-security/menu-security.component';
import { NarrowLongCardsComponent } from './narrow-long-cards/narrow-long-cards.component';
import { EditSocietyComponent } from './modals/societymodal/edit-society/edit-society.component';
import { EditTowerComponent } from './modals/towermodals/edit-tower/edit-tower.component';
import { EditFlatModalComponent } from './modals/flatmodals/edit-flat-modal/edit-flat-modal.component';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { AddMenuModalComponent } from './modals/menumodals/add-menu-modal/add-menu-modal.component';
import { EditMenuModalComponent } from './modals/menumodals/edit-menu-modal/edit-menu-modal.component';
import { MenuSecurityAssignComponent } from './modals/menu-security-assign/menu-security-assign.component';
import {MatIconModule} from '@angular/material/icon';
import { RoleListComponent } from './modals/menu-security-assign/role-list/role-list.component';
import { BackBtnComponent } from './back-btn/back-btn.component';




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
    NarrowLongCardsComponent,
    EditSocietyComponent,
    EditTowerComponent,
    EditFlatModalComponent,
    AddMenuModalComponent,
    EditMenuModalComponent,
    MenuSecurityAssignComponent,
    RoleListComponent,
    BackBtnComponent,
    
    //DummyComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    NoopAnimationsModule,
    MatIconModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
