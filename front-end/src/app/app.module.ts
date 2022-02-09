import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { VerticalNavbarComponent } from './dashboard-component/vertical-navbar/vertical-navbar.component';
import { DashboardComponentComponent } from './dashboard-component/dashboard-component.component';

@NgModule({
  declarations: [
    AppComponent,
    VerticalNavbarComponent,
    DashboardComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
