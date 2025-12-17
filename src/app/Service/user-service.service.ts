import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserDTO, UserLoginDTO } from '../Model/User/user.model';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  baseUrl = 'http://localhost:8082/user-service/user';
    
  
    constructor(private http : HttpClient) {
      
     }
     createUser(user: UserDTO): Observable<UserDTO> {
      return this.http.post<UserDTO>(`${this.baseUrl}/signup`, user);
     }
     loginUser(user:UserLoginDTO):Observable<UserLoginDTO>{
      return this.http.post<UserLoginDTO>(`${this.baseUrl}/login`, user)
     }
      isLoggedIn(): boolean {
    return localStorage.getItem("loggedUser") !== null;
  }
     logout() {
    localStorage.removeItem("loggedUser");
  }

}
