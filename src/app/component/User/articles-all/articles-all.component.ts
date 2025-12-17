
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ArticleService } from 'src/app/Service/article.service';

@Component({
  selector: 'app-articles-all',
  templateUrl: './articles-all.component.html',
  styleUrls: ['./articles-all.component.css']
})
export class ArticlesAllComponent implements OnInit {

  articles: any[] = [];
  isLoggedIn = false;
  userData: any = null;

  constructor(private service: ArticleService, private router: Router) {}

// ngOnInit(): void {
//   const stored = localStorage.getItem("loggedUser");

//   if (stored) {
//     this.userData = JSON.parse(stored);
//     this.isLoggedIn = true;
//   }

//   this.service.getAllArticles().subscribe(data => {
//     this.articles = data;
//   });
// }
ngOnInit(): void {
  const stored = localStorage.getItem("loggedUser");

  if (stored) {
    this.userData = JSON.parse(stored);
    this.isLoggedIn = true;
  }

  this.service.getAllArticles().subscribe(data => {
    this.articles = data;

    // Load likes for each article
    this.articles.forEach(article => {
      this.service.getLikes(article.articleId).subscribe(count => {
        article.likes = count;
      });
    });
  });
}

  logout() {
  localStorage.removeItem("loggedUser");
  this.isLoggedIn = false;
  this.userData = null;
}



  // like(articleId: number) {
  //   this.service.likeArticle(articleId).subscribe(updatedLikes => {
  //     const art = this.articles.find(a => a.articleId === articleId);
  //     if (art) {
  //       art.likes = updatedLikes; // Real-time update
  //     }
  //   });
  // }

  like(articleId: number) {
  if (!this.userData) {
    alert("Please log in to like articles.");
    return;
  }

  const userId = this.userData.userId;

  this.service.likeArticle(articleId, userId).subscribe(() => {

    // Fetch updated likes after success
    this.service.getLikes(articleId).subscribe(count => {
      const art = this.articles.find(a => a.articleId === articleId);
      if (art) {
        art.likes = count;
      }
    });

  });
}


  readArticle(articleId: number) {
    // Redirect to article-read page
    this.router.navigate(['/read-article', articleId]);
  }
}
