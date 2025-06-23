import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CategoriaService } from '../../../service/categoria-service/categoria.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-category',
  imports: [CommonModule],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css',
})
export class CategoryComponent {
  generos: any[] = [];
  modos: any[] = [];
  plataformas: any[] = [];

  constructor(private categoriaService: CategoriaService, private router: Router) {}

  ngOnInit() {
    this.categoriaService.getGeneros().subscribe(data => this.generos = data);
    this.categoriaService.getModosDeJogo().subscribe(data => this.modos = data);
    this.categoriaService.getPlataformas().subscribe(data => this.plataformas = data);
  }



  verJogosPorCategoria(tipo: string, nome: string) {
    nome = nome ? nome.toLowerCase().replace(/\s+/g, '-') : '';
    this.router.navigate(['/descoberta', tipo, nome]);
  }
} 