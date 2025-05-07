import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {

  public errorMessage: string | null = null;
  private AuthUrlApi = 'http://localhost:8080';
  public username: string = '';
  public password: string = '';

  // Construtor da classe
  constructor(private http: HttpClient) {}

  // Método para autenticar o login
  autenticarLogin() {
    const params = new HttpParams()
      .set('login', this.username)
      .set('senhaUsuario', this.password);

    this.http.post(`${this.AuthUrlApi}/autenticar/login`, params.toString(), {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
      responseType: 'text'
    }).subscribe({
      next: (response) => {
        console.debug('Resposta técnica:', response); // Log dev
        const parsedResponse = JSON.parse(response); // Parse the response string into a JSON object
        const token = parsedResponse.token; // Extrai o token da resposta
        const usuario = parsedResponse.usuario; // Extrai o usuário da resposta
        localStorage.setItem('token', token); // Armazena o token no local storage
        localStorage.setItem('usuario', usuario); // Armazena o usuário no local storage
      },
      error: (error) => {
        console.error('Erro técnico completo:', error); // Log detalhado
        this.handleUserError(error); // Mensagem amigável
      }
    });
  }

  // Método para lidar com erros do usuário
  private handleUserError(error: any) {
    if (error.status === 500) {
      this.errorMessage = 'Credenciais inválidas ou erro no servidor';
    } else {
      this.errorMessage = 'Erro na comunicação com o servidor';
    }
    
    // Limpa a mensagem após 5 segundos
    setTimeout(() => this.errorMessage = null, 5000);
  }

}
