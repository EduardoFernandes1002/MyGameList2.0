import { Component,  } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../../service/auth/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  login: string = '';
  senhaUsuario: string = '';

  errorMessage: string | null = null;  // Mensagem de erro

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    this.errorMessage = null; // Limpa mensagem antes do submit
    this.authService.login(this.login, this.senhaUsuario).subscribe({
      next: (response: any) => {
        const token = response.token;
        if (token) {
          localStorage.setItem('token', token);
          this.authService['isLoggedInSubject'].next(true);
          this.router.navigate(['/']);
        } else {
          this.errorMessage = 'Token não encontrado na resposta. Por favor, tente novamente.';
        }
      },
      error: (error) => {
        this.errorMessage = 'Erro ao fazer login. Verifique suas credenciais e tente novamente.';
      },
    });
  }
}
