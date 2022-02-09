import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { VerticalNavbarComponent } from './vertical-navbar/vertical-navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    VerticalNavbarComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
