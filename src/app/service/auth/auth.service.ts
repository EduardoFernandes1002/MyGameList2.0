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

  // Consulta na api pelo nome ou email, verificando se a senha está correta.retornando o usuario co token logado
  login(login: string, senhaUsuario: string){

    const usuario = {
    senhaUsuario,
    emailUsuario: (login.includes('@') && login.includes('.')) ? login : undefined,
    nomeUsuario: !login.includes('@') ? login : undefined,
  };
    return this.http.post(`${this.apiUrl}/login`, usuario) // enviar usuario porem retorna o token
  }

  register(emailUsuario: string, nomeUsuario: string,apelidoUsuario: string,  senhaUsuario: string){

    const usuario = {
      emailUsuario: (emailUsuario.includes('@') && emailUsuario.includes('.')) ? emailUsuario : undefined,
      nomeUsuario: (nomeUsuario.length >= 4 && nomeUsuario.length <= 15) ? nomeUsuario : undefined,
      apelidoUsuario: (apelidoUsuario.length >= 4 && apelidoUsuario.length <= 15) ? apelidoUsuario : undefined,
      senhaUsuario, 
    }

    return this.http.post(`${this.apiUrl}/register`, usuario)

  }

  // verifica se está logado
  isLoggedIn(): Observable<boolean> {
    return this.isLogedInSubject.asObservable();
  } 

  // Verifica se o token ainda existe
  isAuthenticated(): boolean {
    return !!this.getToken();
  }

  // busca token no localhost
  getToken(): string | null {
    return localStorage.getItem('token');
  }

  // Pega nome do usuario pelo token para criação do link do perfil
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

  // Verifica se existe o token
  private hasToken(): boolean {
    return !!localStorage.getItem('token');
  }

  // remove token caso clicar em Sair
  logout(): void {
    localStorage.removeItem('token');
    this.isLogedInSubject.next(false);
  }

  
}
