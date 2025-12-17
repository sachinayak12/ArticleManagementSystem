import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ArticleService } from 'src/app/Service/article.service';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html',
  styleUrls: ['./article-list.component.css']
})
export class ArticleListComponent implements OnInit {


   articles: any[] = [];

  constructor(private service: ArticleService) {}

  ngOnInit(): void {
    this.service.getAllArticles().subscribe(data => {
      this.articles = data;
      console.log(data);
    });
  }

  like(articleId: number) {
    this.service.likeArticle(articleId).subscribe(() => {
      alert("Liked successfully!");
    });
  }

  openComments(article: any) {
    // Redirect to comments page or show popup
    console.log(article);
  }
}