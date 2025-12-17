import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { AuthorListComponent } from './component/Author/authorList/authorList.component';
import { CreateAuthorComponent } from './component/Author/create-author/create-author.component';
import { GetAuthorComponent } from './component/Author/get-author/get-author.component';
import { UpdateAuthorComponent } from './component/Author/update-author/update-author.component';
import { DeleteAuthorComponent } from './component/Author/delete-author/delete-author.component';
import { ArticleListComponent } from './component/Article/article-list/article-list.component';
import { CreateArticleComponent } from './component/Article/create-article/create-article.component';
import { ListArticlesComponent } from './component/Article/list-articles/list-articles.component';
import { UpdateArticleComponent } from './component/Article/update-article/update-article.component';
import { HomeComponent } from './component/home/home.component';
import { DeleteArticleComponent } from './component/article/delete-article/delete-article.component';
import { CommonModule } from '@angular/common';
import { ArticlesAllComponent } from './component/User/articles-all/articles-all.component';
import { UserLoginComponent } from './component/User/user-login/user-login.component';
import { UserSignupComponent } from './component/User/user-signup/user-signup.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthorListComponent,
    CreateAuthorComponent,
    GetAuthorComponent,
    UpdateAuthorComponent,
    DeleteAuthorComponent,
    ArticleListComponent,
    CreateArticleComponent,
    ListArticlesComponent,
    UpdateArticleComponent,
    HomeComponent,
    DeleteArticleComponent,
    ArticleListComponent,
    ArticlesAllComponent,
    UserLoginComponent,
    UserSignupComponent

  ],
  imports: [
    BrowserModule,
    FormsModule,
    CommonModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
