import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthorService } from 'src/app/Service/author.service';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-create-author',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css']
})
export class UserSignupComponent implements OnInit {

  signup!: FormGroup;
  successMessage = '';
  errorMessage = '';

  constructor(private fb: FormBuilder, private userService: UserServiceService) {}

  ngOnInit(): void {
    this.signup = this.fb.group({
      userName: ['', [Validators.required, Validators.minLength(2)]],
            userEmail: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.required, Validators.minLength(4)]]
    });
  }

  createUser() {
    if (this.signup.invalid) {
      this.errorMessage = "Please fix the errors before submitting.";
      this.successMessage = "";
      this.signup.markAllAsTouched();
      return;
    }

    this.userService.createUser(this.signup.value).subscribe({
      next: (response) => {
        this.successMessage = "user created successfully!";
        this.errorMessage = "";

        console.log(response);
        this.signup.reset();
      },
      error: (err) => {
        this.errorMessage = "Failed to create user!";
        this.successMessage = "";
        console.error(err);
      }
    });
  }
}
