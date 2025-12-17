import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthorDTO, CreateAuthorDTO, UpdateAuthorNameDTO, UpdateAuthorPasswordDTO } from '../author.model';

@Injectable({
  providedIn: 'root'
})
export class AuthorService {
  baseUrl = 'http://localhost:8082/author-service/author';
  

  constructor(private http : HttpClient) {
    
   }
   getAllAuthors():Observable<AuthorDTO[]>{
    return this.http.get<AuthorDTO[]>(`${this.baseUrl}/get`);
   }

   createAuthor(author: CreateAuthorDTO): Observable<AuthorDTO> {
  return this.http.post<AuthorDTO>(`${this.baseUrl}`, author);
}
getAuthorById(id: number): Observable<AuthorDTO> {
  return this.http.get<AuthorDTO>(`${this.baseUrl}/${id}`);
}
updateAuthorName(authorId: number, newName: string) {
  const body = { newName }; // <-- send JSON object

  return this.http.patch(
    `${this.baseUrl}/name/${authorId}`,
    body,
    { headers: { 'Content-Type': 'application/json' } }
  );
}
deleteAuthor(authorId: number) {
  return this.http.delete(`${this.baseUrl}/delete/${authorId}`);
}



updateAuthorPassword(authorId: number, newPassword: string) {
   const body = { newPassword }; // <-- send JSON object

  return this.http.patch(
    `${this.baseUrl}/password/${authorId}`,
    body,
    { headers: { 'Content-Type': 'application/json' } }
  );
}







}
