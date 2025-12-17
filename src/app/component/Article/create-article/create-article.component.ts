import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ArticleService } from 'src/app/Service/article.service';

@Component({
  selector: 'app-create-article',
  templateUrl: './create-article.component.html',
  styleUrls: ['./create-article.component.css']
})
export class CreateArticleComponent implements OnInit {

  articleForm!: FormGroup;

  constructor(private fb: FormBuilder, private articleService: ArticleService) {}

  ngOnInit(): void {
    this.articleForm = this.fb.group({
      articleName: ['', [Validators.required, Validators.minLength(3)]],
      articleDescription: ['', [Validators.required, Validators.minLength(10)]],
      authorId: ['', [Validators.required, Validators.min(1)]]
    });
  }

  submitArticle() {
    if (this.articleForm.invalid) {
      this.articleForm.markAllAsTouched();
      return;
    }

    this.articleService.createArticle(this.articleForm.value).subscribe({
      next: () => alert("Article created successfully!"),
      error: () => alert("Failed to create article")
    });
  }
}
