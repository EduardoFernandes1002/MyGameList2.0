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
  login = '';
  password = '';
  erro = '';

  constructor(private authService: AuthService, private router: Router) {}

  onSubmit(): void {
    this.authService.login(this.login, this.password).subscribe({
      next: () => this.router.navigate(['/']), // Ajuste a rota conforme necessário
      error: err => this.erro = 'Login inválido. Verifique suas credenciais.'
    });
  }
}
