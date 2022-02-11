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


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    FooterComponent,
    DashboardComponent,
    VerticalNavbarComponent,
    ConfigurationComponent,
    SocietyComponent,
    UserComponent
    
    //DummyComponentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
