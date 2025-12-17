import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorListComponent } from './component/Author/authorList/authorList.component';
import { CreateAuthorComponent } from './component/Author/create-author/create-author.component';
import { GetAuthorComponent } from './component/Author/get-author/get-author.component';
import { UpdateAuthorComponent } from './component/Author/update-author/update-author.component';
import { DeleteAuthorComponent } from './component/Author/delete-author/delete-author.component';
import { CreateArticleComponent } from './component/Article/create-article/create-article.component';
import { ListArticlesComponent } from './component/Article/list-articles/list-articles.component';
import { UpdateArticleComponent } from './component/Article/update-article/update-article.component';
import { DeleteArticleComponent } from './component/article/delete-article/delete-article.component';
import { ArticlesAllComponent } from './component/User/articles-all/articles-all.component';
import { UserSignupComponent } from './component/User/user-signup/user-signup.component';
import { UserLoginComponent } from './component/User/user-login/user-login.component';




const routes: Routes = [
  {path:'authors-list' , component:AuthorListComponent},
  {path:'create-author' , component:CreateAuthorComponent},
  { path: 'get-author', component: GetAuthorComponent },
  {path: 'update-author' , component:UpdateAuthorComponent},
  {path: 'delete-author' , component:DeleteAuthorComponent},
  {path: 'create-article' , component:CreateArticleComponent},
  {path: 'list-articles' , component:ListArticlesComponent},
  { path: 'update-article', component: UpdateArticleComponent },
  {path : 'delete-article', component:DeleteArticleComponent},
  {path : "articles-all" , component:ArticlesAllComponent},
  {path : "user-signup" , component:UserSignupComponent},
  {path : "user-login" , component:UserLoginComponent}



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
