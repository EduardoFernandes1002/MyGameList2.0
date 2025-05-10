import { Component,  } from '@angular/core';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../servico/auth/auth.service';

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

  constructor(private authService: AuthService, private router: Router) {}


  onSubmit(): void {
    this.authService.login(this.login, this.senhaUsuario).subscribe({
    next: (response: any) => {
      // Supondo que o token seja retornado no campo "token" da resposta
      const token = response.token;
      if (token) {
        localStorage.setItem('token', token);
        this.router.navigate(['/']); // Ajuste a rota conforme necessário
      } else {
        console.error('Token não encontrado na resposta.');
      }
    },
    error: (error) => {
      console.error('Erro ao fazer login:', error);
    },
  });
  }
}
