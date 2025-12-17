import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ArticleService } from 'src/app/Service/article.service';
import { Article } from 'src/app/Model/article.model';

@Component({
  selector: 'app-list-articles',
  templateUrl: './list-articles.component.html',
  styleUrls: ['./list-articles.component.css']
})
export class ListArticlesComponent implements OnInit {

  articlesForm!: FormGroup;
  articles: Article[] = [];
  errorMessage: string = '';

  constructor(private fb: FormBuilder, private articleService: ArticleService) {}

  ngOnInit(): void {
    this.articlesForm = this.fb.group({
      authorId: ['', [Validators.required, Validators.min(1)]]
    });
  }

  loadArticles() {
    if (this.articlesForm.invalid) {
      this.articlesForm.markAllAsTouched();
      return;
    }

    const authorId = this.articlesForm.value.authorId;

    this.articleService.getArticlesByAuthorId(authorId).subscribe({
      next: (res) => {
        this.articles = res;
        this.errorMessage = '';
      },
      error: () => {
        this.articles = [];
        this.errorMessage = "Failed to load articles";
      }
    });
  }
}
