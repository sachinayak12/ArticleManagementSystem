import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from 'src/app/Service/user-service.service';

@Component({
  selector: 'app-login-user',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent implements OnInit {

  loginForm!: FormGroup;
  successMessage = '';
  errorMessage = '';

  constructor(private fb: FormBuilder, private userService: UserServiceService,  private router: Router) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      
      userEmail: ['', [Validators.required,Validators.email]],
      password: ['', [Validators.required]]
    });
  }

  loginUser() {
    if (this.loginForm.invalid) {
      this.errorMessage = "Please fix the errors before submitting.";
      this.successMessage = "";
      this.loginForm.markAllAsTouched();
      return;
    }

    this.userService.loginUser(this.loginForm.value).subscribe({
      // next: (response) => {
      //   this.successMessage = "user logged in successfully!";
      //   this.errorMessage = "";

      //   console.log(response);
      //   this.loginForm.reset();
      //     this.router.navigate(['/articles-all']);

      // },
  next: (response) => {
    this.successMessage = "user logged in successfully!";
    this.errorMessage = "";
    console.log(response);
    localStorage.setItem("loggedUser", JSON.stringify(response));

    this.router.navigate(['/articles-all']);
},



      error: (err) => {
        this.errorMessage = "Failed to login !";
        this.successMessage = "";
        console.error(err);
      }
    });
  }
}
