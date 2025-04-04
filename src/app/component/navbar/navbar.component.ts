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
logout() {
  // Remove the JWT token from local storage or session storage
  localStorage.removeItem('token');
  // Redirect the user to the login page
  this.router.navigate(['/login']);
}

isAuthenticated(): boolean {
  // Check if a valid JWT token exists in local storage or session storage
  const token = localStorage.getItem('token');
  if (!token) {
    return false;
  }

  // Optionally, you can decode and validate the token's expiration
  const payload = JSON.parse(atob(token.split('.')[1]));
  const isTokenExpired = payload.exp * 1000 < Date.now();
  return !isTokenExpired;
}
  navItems = [
    { label: 'Home', path: '/' },
    { label: 'Rank', path: '/rank' },
    { label: 'Recomendações', path: '/recomendado' },
    { label: 'Categorias', path: '/categoria' },
    { label: 'Descoberta', path: '/descoberta' },
    { label: 'Ajuda/FAQ', path: '/ajuda' },
  ];

  constructor(public router: Router) {}
}
