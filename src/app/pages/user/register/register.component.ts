import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { AuthService } from '../../../service/auth/auth.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
})
export class RegisterComponent {

  emailUsuario: string = '';
  nomeUsuario: string = '';
  apelidoUsuario: string = '';
  senhaUsuario: string = '';
  comfirmarSenha: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  OnSubmit(): void {
    if (this.senhaUsuario === this.comfirmarSenha) {
      this.authService.register(this.emailUsuario, this.nomeUsuario, this.apelidoUsuario, this.senhaUsuario).subscribe({
        next: (response) => {
          console.log('Registro bem-sucedido:', response);
          this.router.navigate(['/login']);
        },
        error: (error) => {
          console.error('Erro ao registrar:', error);
        }
      });
    } else {
      console.error('Senhas não coincidem.');
    }
  }

}
