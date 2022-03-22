import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Route, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home-page/home-page.component';
import { FooterComponent } from './home-page/footer/footer.component';
import { DashboardComponent } from './dashboard/dashboard.component';

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
//import { RoleComponent } from './dashboard/configuration/role/role.component';
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

import { RoleComponent } from './dashboard/configuration/user/role/role.component';


import { RoleModalComponent } from './modals/roleModals/role-modal/role-modal.component';
import { NewRoleModalComponent } from './modals/roleModals/new-role-modal/new-role-modal.component';
import { EditUserModalComponent } from './dashboard/configuration/user/edit-user-modal/edit-user-modal.component';
import { FlatDetailsComponent } from './dashboard/configuration/user/flat-details/flat-details.component';
import { NewFlatModalComponent } from './modals/flatmodals/new-flat-modal/new-flat-modal.component';
import { FlatEditModalComponent } from './modals/flatmodals/flat-edit-modal/flat-edit-modal.component';

import { PutTokenService } from './token-interceptor.service';
import { ForgotPasswordComponent } from './modals/authentication/forgot-password/forgot-password.component';
import { ResetPasswordComponent } from './modals/authentication/reset-password/reset-password.component';
import { ProfileComponent } from './dashboard/vertical-navbar/profile/profile.component';
import { ChangePasswordComponent } from './modals/profile-modals/change-password/change-password.component';
import { NavbarComponent } from './dashboard/navbar/navbar.component';
import { AnnouncementComponent } from './dashboard/announcement/announcement.component';
import { ExpandAnnouncementModalComponent } from './modals/announcement-modal/expand-announcement-modal/expand-announcement-modal.component';
import { AddAnnouncementModalComponent } from './modals/announcement-modal/add-announcement-modal/add-announcement-modal.component';
import { EditAnnouncementModalComponent } from './modals/announcement-modal/edit-announcement-modal/edit-announcement-modal.component';
import { CookieService } from 'ngx-cookie-service';
import { NoticeComponent } from './dashboard/notice/notice.component';
import { ShowNoticeComponent } from './dashboard/notice/show-notice/show-notice.component';
import { CreateNoticeComponent } from './dashboard/notice/create-notice/create-notice.component';
import { ExpandNoticeComponent } from './modals/notice-modals/expand-notice/expand-notice.component';
import { EditNoticeComponent } from './modals/notice-modals/edit-notice/edit-notice.component';
import { HomeComponent } from './dashboard/home/home.component';
import { ProfileCardComponent } from './dashboard/home/profile-card/profile-card.component';
import { UserComplaintsComponent } from './dashboard/complaints/user-complaints/user-complaints.component';
import { RaiseComplaintComponent } from './modals/complaints/raise-complaint/raise-complaint.component';
import { ComplaintHistoryComponent } from './modals/complaints/complaint-history/complaint-history.component';
import { ComplaintsComponent } from './dashboard/complaints/complaints.component';
import { WorkerComplaintsComponent } from './dashboard/complaints/worker-complaints/worker-complaints.component';
import { DatePipe } from '@angular/common';
import { AssignedTaskComponent } from './dashboard/complaints/assigned-task/assigned-task.component';
import { TaskComponent } from './dashboard/complaints/task/task.component';
import { RegisteredComplaintsComponent } from './dashboard/complaints/registered-complaints/registered-complaints.component';
import { CompletedTaskComponent } from './dashboard/complaints/completed-task/completed-task.component';
import { AnnouncementCardComponent } from './dashboard/home/announcement-card/announcement-card.component';
import { NoticeCardComponent } from './dashboard/home/notice-card/notice-card.component';



@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    FooterComponent,
    DashboardComponent,
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
    RoleComponent,
    RoleModalComponent,
    NewRoleModalComponent,
    EditUserModalComponent,
    FlatDetailsComponent,
    NewFlatModalComponent,
    FlatEditModalComponent,
    ForgotPasswordComponent,
    ResetPasswordComponent,
    ProfileComponent,
    ChangePasswordComponent,
    NavbarComponent,
    AnnouncementComponent,
    ExpandAnnouncementModalComponent,
    AddAnnouncementModalComponent,
    EditAnnouncementModalComponent,
    NoticeComponent,
    ShowNoticeComponent,
    CreateNoticeComponent,
    ExpandNoticeComponent,
    EditNoticeComponent,
    HomeComponent,
    ProfileCardComponent,
    UserComplaintsComponent,
    RaiseComplaintComponent,
    ComplaintHistoryComponent,
    ComplaintsComponent,
    WorkerComplaintsComponent,
    AssignedTaskComponent,
    TaskComponent,
    RegisteredComplaintsComponent,
    CompletedTaskComponent,
    AnnouncementCardComponent,
    NoticeCardComponent,
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
  providers:[
     { provide: HTTP_INTERCEPTORS, useClass: PutTokenService, multi: true },
      CookieService,
      DatePipe
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
