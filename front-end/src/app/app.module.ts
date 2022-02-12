import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FooterComponent } from './home-page/footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VerticalNavbarComponent } from './dashboard/vertical-navbar/vertical-navbar.component';
//import { ConfigurationComponentComponent } from './dashboard/configuration/configuration.component';

import { ConfigurationComponent } from './dashboard/configuration/configuration.component';
import { AppRoutingModule } from './app-routing.module';
import { SocietyComponent } from './dashboard/configuration/society/society.component';
import { UserComponent } from './dashboard/configuration/user/user.component';
import { SecurityComponent } from './dashboard/configuration/security/security.component';
import { TowerComponent } from './dashboard/configuration/society/tower/tower.component';
import { TowerListComponent } from './dashboard/configuration/society/tower-list/tower-list.component';
import { FlatComponent } from './dashboard/configuration/society/tower/flat/flat.component';


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
    SecurityComponent,
    TowerComponent,
    TowerListComponent,
    FlatComponent,
    
    //DummyComponentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
