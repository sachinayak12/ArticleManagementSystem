import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  activeSection: string | null = null;
   isLoggedIn(): boolean {
    return localStorage.getItem("loggedUser") !== null;
  }

  showSection(section: string) {
    this.activeSection = section; // automatically hides previous
  }
}
