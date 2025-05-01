import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  private AuthUrlApi = 'http://localhost:8080/autenticar';
  public username: string = '';
  public password: string = '';

  constructor(private http: HttpClient) {}

  autenticarLogin() {
    const params = new HttpParams()
      .set('login', this.username)
      .set('senhaUsuario', this.password);
  
    this.http.post(`${this.AuthUrlApi}/login`, params.toString(), {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    }).subscribe({
      next: (response) => console.log('Login bem-sucedido:', response),
      error: (error) => {
        console.error('Erro completo:', error);
        console.error('Detalhes do erro:', error.error);
      }
    });
  }
}
