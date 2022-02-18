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
    NarrowLongCardsComponent
    
    //DummyComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
