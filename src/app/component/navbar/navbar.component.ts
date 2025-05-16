import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  nomeUsuario: string | null = null;

  constructor(public router: Router) {
    this.nomeUsuario = this.getNomeUsuarioFromToken();
  }

  logout() {
    // Remove o JWT token do local storage.
    localStorage.removeItem('token');
    this.router.navigate(['/']);
  }

  isAuthenticated(): boolean {
    const token = localStorage.getItem('token');
    if (!token) {
      return false;
    }
    return true;
  }

  navItems = [
    { label: 'Home', path: '/' },
    { label: 'Rank', path: '/rank' },
    { label: 'Recomendações', path: '/recomendado' },
    { label: 'Categorias', path: '/categoria' },
    { label: 'Descoberta', path: '/descoberta' },
    { label: 'Ajuda/FAQ', path: '/ajuda' },
  ];

  getNomeUsuarioFromToken(): string | null {
    const token = localStorage.getItem('token');
    if (!token) return null;
    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return payload.sub || null;
    } catch (e) {
      return null;
    }
  }
}
