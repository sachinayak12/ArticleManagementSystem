import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Article } from 'src/app/Model/article.model';
import { ArticleService } from 'src/app/Service/article.service';

@Component({
  selector: 'app-delete-article',
  templateUrl: './delete-article.component.html',
  styleUrls: ['./delete-article.component.css']
})
export class DeleteArticleComponent implements OnInit {

    deleteForm!: FormGroup;
  articles: Article[] = [];
  message: string = "";

  constructor(private fb: FormBuilder, private articleService: ArticleService) {
    this.deleteForm = this.fb.group({
      articleId: ['', Validators.required],
    });
  }
  ngOnInit(): void {
    // throw new Error('Method not implemented.');
  }

  deleteArticle() {
  if (this.deleteForm.invalid) {
    this.message = "Please fill all fields";
    return;
  }

  const articleId = this.deleteForm.value.articleId;  // FIXED

  this.articleService.deleteArticle(articleId).subscribe({
    next: () => {
      this.message = "Article deleted successfully";
    },
    error: (err) => {
      console.error(err);
      this.message = "Error deleting article";
    }
  });
  }
}
