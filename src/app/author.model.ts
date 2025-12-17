export interface ArticleDTO {
  articleId: number;
  articleName: string;
  articleDescription: string;
}

export interface AuthorDTO {
  authorId: number;
  authorName: string;
  articles: ArticleDTO[];
}

export interface CreateAuthorDTO {
  authorId?: number;
  authorName: string;
  articles?: ArticleDTO[];
  password:string;
}
export interface DisplayAuthorDTO {
  authorId?: number;
  authorName: string;

}
export interface UpdateAuthorNameDTO {
  authorId?: number;
  authorName: string;
  
}
export interface UpdateAuthorPasswordDTO {
  authorId?: number;
  password: string;
  
}