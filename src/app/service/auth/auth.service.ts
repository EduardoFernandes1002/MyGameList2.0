import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  private apiUrl = 'http://localhost:8080/autenticar'; // URL da API de autenticação
  private isLoggedInSubject = new BehaviorSubject<boolean>(this.hasToken());
  nomeUsuario: any;

  constructor(private http: HttpClient) {}

  // Consulta na api pelo nome ou email, verificando se a senha está correta.retornando o usuario co token logado
  login(login: string, senhaUsuario: string) {
    const usuario: any = { senhaUsuario };
    if (login.includes('@') && login.includes('.')) {
      usuario.emailUsuario = login;
    } else {
      usuario.nomeUsuario = login;
    }
    return this.http.post(`${this.apiUrl}/login`, usuario);
  }

  register(
    emailUsuario: string,
    nomeUsuario: string,
    apelidoUsuario: string,
    senhaUsuario: string
  ) {
    // Validação (opcional, mas recomendado)
    if (
      !emailUsuario.includes('@') ||
      !emailUsuario.includes('.') ||
      nomeUsuario.length < 4 ||
      nomeUsuario.length > 15 ||
      apelidoUsuario.length < 4 ||
      apelidoUsuario.length > 15
    ) {
      throw new Error('Dados inválidos para registro');
    }

    const usuario = {
      emailUsuario,
      nomeUsuario,
      apelidoUsuario,
      senhaUsuario,
    };

    return this.http.post(`${this.apiUrl}/registrar`, usuario);
  }

  // verifica se está logado
  isLoggedIn(): Observable<boolean> {
    return this.isLoggedInSubject.asObservable();
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
    this.isLoggedInSubject.next(false);
  }

  // Funções do usuario para outras areas

  getInfosUsuarioLogado(): Observable<any[]> {
    const nomeUsuario = this.getNomeUsuarioFromToken();
    return this.http
      .get<any[]>(`http://localhost:8080/api/usuarios/username/${nomeUsuario}`)
  }

  getJogosListaUsuario(lista: number): Observable<any[]> {
    const nomeUsuario = this.getNomeUsuarioFromToken();
    return this.http
      .get<any[]>(`http://localhost:8080/api/lista/${nomeUsuario}/${lista}/jogos`)
  }

  getNomeLista(idLista: number): Observable<any> {
  return this.http.get<any>(`http://localhost:8080/api/lista/${idLista}`);
}
}
