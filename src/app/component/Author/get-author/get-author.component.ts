import { Component } from '@angular/core';
import { AuthorDTO } from 'src/app/author.model';
import { AuthorService } from 'src/app/Service/author.service';

@Component({
  selector: 'app-get-author',
  templateUrl: './get-author.component.html',
  styleUrls: ['./get-author.component.css']
})
export class GetAuthorComponent {

  authorId!: number;
  author: AuthorDTO | null = null;
  errorMessage: string = '';

  constructor(private authorService: AuthorService) {}

  fetchAuthor() {
    if (!this.authorId || this.authorId <= 0) {
      this.errorMessage = 'Please enter a valid Author ID';
      this.author = null;
      return;
    }

    this.authorService.getAuthorById(this.authorId).subscribe({
      next: (data) => {
        this.author = data;
        this.errorMessage = '';
      },
      error: () => {
        this.author = null;
        this.errorMessage = 'Author not found';
      }
    });
  }
}
