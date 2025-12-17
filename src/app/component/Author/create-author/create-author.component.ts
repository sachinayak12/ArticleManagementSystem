import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthorService } from 'src/app/Service/author.service';

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.css']
})
export class CreateAuthorComponent implements OnInit {

  authorForm!: FormGroup;
  successMessage = '';
  errorMessage = '';

  constructor(private fb: FormBuilder, private authorService: AuthorService) {}

  ngOnInit(): void {
    this.authorForm = this.fb.group({
      authorName: ['', [Validators.required, Validators.minLength(2)]],
      password: ['', [Validators.required, Validators.minLength(4)]]
    });
  }

  createAuthor() {
    if (this.authorForm.invalid) {
      this.errorMessage = "Please fix the errors before submitting.";
      this.successMessage = "";
      this.authorForm.markAllAsTouched();
      return;
    }

    this.authorService.createAuthor(this.authorForm.value).subscribe({
      next: (response) => {
        this.successMessage = "Author created successfully!";
        this.errorMessage = "";

        console.log(response);
        this.authorForm.reset();
      },
      error: (err) => {
        this.errorMessage = "Failed to create author!";
        this.successMessage = "";
        console.error(err);
      }
    });
  }
}
