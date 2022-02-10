import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FooterComponent } from './home-page/footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { VerticalNavbarComponent } from './dashboard/vertical-navbar/vertical-navbar.component';
import { ConfigurationComponentComponent } from './dashboard/configuration-component/configuration-component.component';
import { DummyComponentComponent } from './dashboard/dummy-component/dummy-component.component';

const appRoutes:Route[] = [
  {path:'',component:ConfigurationComponentComponent},
  {path:'dummy',component:DummyComponentComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    FooterComponent,
    DashboardComponent,
    VerticalNavbarComponent,
    ConfigurationComponentComponent,
    DummyComponentComponent,
    //DummyComponentComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
