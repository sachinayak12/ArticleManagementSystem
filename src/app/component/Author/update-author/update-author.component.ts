import { Component, OnInit } from '@angular/core';
import { AuthorService } from 'src/app/Service/author.service';

@Component({
  selector: 'app-update-author',
  templateUrl: './update-author.component.html',
  styleUrls: ['./update-author.component.css']
})
export class UpdateAuthorComponent implements OnInit {

  authorId!: number;
  newName!: string;
  newPassword!: string;
  NamesuccessMessage = '';
  NameerrorMessage = '';
  PasswordsuccessMessage = '';
  PassworderrorMessage = '';

  constructor(private authorService: AuthorService) {}

  ngOnInit(): void {
    
  }

  updateName() {
    this.authorService.updateAuthorName(this.authorId, this.newName)
      .subscribe({
        next: (res) => {
          this.NamesuccessMessage = "Name updated successfully!";
        this.NameerrorMessage = "";
        console.log(Response);
        },
        error: (err) => {
           this.NameerrorMessage = "Failed to update the name!";
        this.NamesuccessMessage = "";
        console.error(err);
        }
      });
  }

  updatePassword() {
    this.authorService.updateAuthorPassword(this.authorId, this.newPassword)
      .subscribe({
        next: (res) => {
          this.PasswordsuccessMessage = "Password updated successfully!";
        this.PassworderrorMessage = "";
        console.log(Response);
        },
        error: (err) => {
           this.PassworderrorMessage = "Failed to update the password!";
        this.PasswordsuccessMessage = "";
        console.error(err);
        }
      });
  }

}
