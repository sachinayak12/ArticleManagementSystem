import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ArticleService } from 'src/app/Service/article.service';

@Component({
  selector: 'app-update-article',
  templateUrl: './update-article.component.html',
  styleUrls: ['./update-article.component.css']
})
export class UpdateArticleComponent implements OnInit {

  updateForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private articleService: ArticleService
  ) {}

  ngOnInit(): void {
    this.updateForm = this.fb.group({
      authorId: ['', [Validators.required, Validators.min(1)]],
      articleName: ['', [Validators.required, Validators.minLength(3)]],
      articleDescription: ['', [Validators.required, Validators.minLength(3)]]
    });
  }

  updateArticle() {
    if (this.updateForm.invalid) {
      this.updateForm.markAllAsTouched();
      return;
    }

    const articleDTO = this.updateForm.value;

    this.articleService.updateArticle(articleDTO).subscribe({
  next: (res) => {
    console.log("Updated:", res);
    alert("Article updated successfully!");
  },
  error: (err) => {
    console.error(err);
    alert("Failed to update article");
  }
});

  }

  get f() {
    return this.updateForm.controls;
  }
}
