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

  constructor(private authService: AuthService, private router: Router) {}

  /*OnSubmit(form: any): void {
    if (form.valid) {
      this.authService.register(form.value).subscribe({
        next: (response) => {
          console.log('Registro bem-sucedido:', response);
          this.router.navigate(['/login']);
        },
        error: (error) => {
          console.error('Erro ao registrar:', error);
        }
      });
    } else {
      console.error('Formulário inválido');
    }
  } */

}
