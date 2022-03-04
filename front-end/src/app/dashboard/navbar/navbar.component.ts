import { Component, OnInit } from '@angular/core';
import { ComponentModel } from '../vertical-navbar/component.model';
import { MatIconModule } from '@angular/material/icon';
import { RoleService } from '../configuration/user/role/role.service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserPostServices } from '../configuration/user/user.posts.service';
import { AuthService } from 'src/app/auth.service';
import { relative } from '@angular/compiler-cli/private/localize';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  public currentUser;
  menus: any[] = [];
  sizeOfComponents: number;
  startIndex = 0;

  components: ComponentModel[] = [
    new ComponentModel('Configuration', 'configuration'),
  ];

  constructor(
    private roleService: RoleService,
    private route: Router,
    private userService: UserPostServices,
    private authService: AuthService,
    private activeRoute: ActivatedRoute,
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.currentUser = JSON.parse(atob(localStorage.getItem('user')));

    this.http
      .get<any>(`http://localhost:9191/menu/${this.currentUser.userDetailId}`)
      .subscribe((data) => {
        this.menus = data;
        console.log(this.menus);
      });
  }

  displayProfile() {
    this.route.navigate(['profile'], { relativeTo: this.activeRoute });
  }

  logoutOnClick() {
    this.authService.logout(this.currentUser).subscribe(
      (responseData) => {
        localStorage.clear();
        this.userService.deleteCurrentUser();
        this.route.navigate(['']);
      },
      (error) => {
        console.log('Error in logging out', error);
      }
    );
  }
}
