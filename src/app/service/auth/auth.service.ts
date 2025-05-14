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

  logout(): void {
    localStorage.removeItem('token');
    this.isLogedInSubject.next(false);
  }

  isLoggedIn(): Observable<boolean> {
    return this.isLogedInSubject.asObservable();
  }

  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }
}
