import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  showAuthorMenu = false;
  showArticleMenu = false;

  toggleAuthorMenu() {
    this.showAuthorMenu = !this.showAuthorMenu;
    this.showArticleMenu = false;   // hide article menu if open
  }

  toggleArticleMenu() {
    this.showArticleMenu = !this.showArticleMenu;
    this.showAuthorMenu = false;    // hide author menu if open
  }
}
