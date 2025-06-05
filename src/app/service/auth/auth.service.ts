import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private apiUrl = 'http://localhost:8080/autenticar'; // URL da API de autenticação
  private isLogedInSubject = new BehaviorSubject<boolean>(this.hasToken());

  constructor(private http: HttpClient) {}

  login(login: string, senhaUsuario: string){
    const usuario = {
    senhaUsuario,
    emailUsuario: login.includes('@') ? login : undefined,
    nomeUsuario: !login.includes('@') ? login : undefined,
  };
    return this.http.post(`${this.apiUrl}/login`, usuario)
  }


  isLoggedIn(): Observable<boolean> {
    return this.isLogedInSubject.asObservable();
  }

  isAuthenticated(): boolean {
    return !!this.getToken();
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  getNomeUsuarioFromToken(): string | null {
    const token = this.getToken();
    if (!token) return null;
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.sub;
    } catch (e) {
      return null;
    }
  }

  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }

  logout(): void {
    localStorage.removeItem('token');
    this.isLogedInSubject.next(false);
  }

  
}
