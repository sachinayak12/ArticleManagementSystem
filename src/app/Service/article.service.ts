// import { Injectable } from '@angular/core';
// import { Article } from '../Model/article.model';
// import { HttpClient, HttpHeaders } from '@angular/common/http';
// import { Observable } from 'rxjs';

// @Injectable({
//   providedIn: 'root'
// })
// export class ArticleService {
//   baseUrl = 'http://localhost:8081/article'
//    constructor(private http : HttpClient) {
      
//      }
//   createArticle(article: Article) {
//   return this.http.post<Article>(
//     `${this.baseUrl}/save`, 
//     article,
//     { headers: { 'Content-Type': 'application/json' }}
//   );
// }
// getArticlesByAuthorId(authorId: number) {
//   return this.http.get<Article[]>(
//     `${this.baseUrl}/get/${authorId}`
//   );
// }
// updateArticle(article: any) {
//   return this.http.patch<Article>(
//     `${this.baseUrl}/update`,
//     article,
//     { responseType: 'json' as const }
//   );
// }



// deleteArticle(articleId: number): Observable<any> {
//   return this.http.delete(
//     `${this.baseUrl}/delete/${articleId}`,
//     { responseType: 'text' }   //  FIXED ←<<<<
//   );
// }



//   getAllArticles(): Observable<any[]> {
//     return this.http.get<any[]>(`${this.baseUrl}/getAll`);
//   }

// likeArticle(articleId: number) {
//   return this.http.post<number>(`http://localhost:9999/likes/save/${articleId}`, {});
// }



//   // comment(articleId: number, comment: string): Observable<any> {
//   //   return this.http.post(`http://localhost:9090/comments/save`, {
//   //     articleId,
//   //     comment
//   //   });

//   // }
// }
import { Injectable } from '@angular/core';
import { Article } from '../Model/article.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  baseUrl = 'http://localhost:8082/article-service/article'
   constructor(private http : HttpClient) {
      
     }
  createArticle(article: Article) {
  return this.http.post<Article>(
    `${this.baseUrl}/save`, 
    article,
    { headers: { 'Content-Type': 'application/json' }}
  );
}
getArticlesByAuthorId(authorId: number) {
  return this.http.get<Article[]>(
    `${this.baseUrl}/get/${authorId}`
  );
}
updateArticle(article: any) {
  return this.http.patch<Article>(
    `${this.baseUrl}/update`,
    article,
    { responseType: 'json' as const }
  );
}



deleteArticle(articleId: number): Observable<any> {
  return this.http.delete(
    `${this.baseUrl}/delete/${articleId}`,
    { responseType: 'text' }   //  FIXED ←<<<<
  );
}



  getAllArticles(): Observable<any[]> {
    return this.http.get<any[]>(`${this.baseUrl}/getAll`);
  }

// likeArticle(articleId: number) {
//   return this.http.post<number>(`http://localhost:8082/interaction-service/likes/save/${articleId}`, {});
// }
// likeArticle(articleId: number): Observable<number> {
//   return this.http.post<number>(
//     `http://localhost:8082/interaction-service/likes/save/${articleId}`,
//     {}
//   );
likeArticle(articleId: number, userId: number) {
  return this.http.post(`http://localhost:8082/likes/likes/save/${articleId}/${userId}`,
     { responseType: 'text' });
}

getLikes(articleId: number) {
  return this.http.get<number>(`http://localhost:8082/likes/likes/get/${articleId}`);
}

}




  // comment(articleId: number, comment: string): Observable<any> {
  //   return this.http.post(`http://localhost:9090/comments/save`, {
  //     articleId,
  //     comment
  //   });

  // }
// }




















