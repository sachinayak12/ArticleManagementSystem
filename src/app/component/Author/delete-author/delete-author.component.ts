import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthorService } from 'src/app/Service/author.service';

@Component({
  selector: 'app-delete-author',
  templateUrl: './delete-author.component.html',
  styleUrls: ['./delete-author.component.css']
})
export class DeleteAuthorComponent {

  deleteForm: FormGroup;
   successMessage = '';
  errorMessage = '';


  constructor(private fb: FormBuilder, private authorService: AuthorService) {
    this.deleteForm = this.fb.group({
      authorId: ['', [Validators.required, Validators.min(1)]]
    });
  }

  deleteAuthor() {
    if (this.deleteForm.invalid) 
      {
        this.errorMessage = "Please fix the errors before submitting.";
      this.successMessage = "";
        return;
      }
    const id = this.deleteForm.value.authorId;

    this.authorService.deleteAuthor(id).subscribe({
      next: (response) => {
        this.successMessage = "Author deleted successfully!";
        this.errorMessage = "";

        console.log(response);
      },
      error: (err) => {
        this.errorMessage = "Failed to delete author!";
        this.successMessage = "";
        console.error(err);
      }
    });
  }
}
