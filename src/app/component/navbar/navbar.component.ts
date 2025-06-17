import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';
import { AuthService } from '../../service/auth/auth.service';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  nomeUsuario: any;

  constructor(public router: Router, public authService: AuthService) {
    this.updateNomeUsuario();
    this.authService.isLoggedIn().subscribe(() => {
      this.updateNomeUsuario();
    });
  }

  private updateNomeUsuario() {
    this.nomeUsuario = this.authService.getNomeUsuarioFromToken();
  }

  isAuthenticated(): boolean {
    return this.authService.isAuthenticated();
  }
  
  

  logout() {
    this.authService.logout();
    this.nomeUsuario = null;
    this.router.navigate(['/']);
  }

  navItems = [
    { label: 'Home', path: '/' },
    { label: 'Rank', path: '/rank' },
    { label: 'Categorias', path: '/categoria' },
    { label: 'Ajuda/FAQ', path: '/ajuda' },
  ];
}
