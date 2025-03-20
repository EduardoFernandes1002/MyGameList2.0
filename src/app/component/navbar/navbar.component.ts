import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  navItems = [
    { label: 'Home', path: '/' },
    { label: 'Rank', path: '/rank' },
    { label: 'Recomendações', path: '/recomendado' },
    { label: 'Categorias', path: '/categoria' },
    { label: 'Descoberta', path: '/descoberta' },
    { label: 'Ajuda/FAQ', path: '/ajuda' }
  ];

  constructor(public router: Router) {}
  
}
