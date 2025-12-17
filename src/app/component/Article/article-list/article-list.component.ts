import { Component, OnInit } from '@angular/core';
import { ArticleService } from 'src/app/Service/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {

  articleName!: string;
  articleDescription!: string;
  authorId!: number;

  constructor(private articleService: ArticleService) {}

  ngOnInit(): void {}

  submitArticle() {
    const newArticle = {
      articleName: this.articleName,
      articleDescription: this.articleDescription,
      authorId: this.authorId
    };

    this.articleService.createArticle(newArticle).subscribe({
      next: (res) => {
        alert("Article created successfully!");
      },
      error: (err) => {
        console.error(err);
        alert("Failed to create article");
      }
    });
  }
}
