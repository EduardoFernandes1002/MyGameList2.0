import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-category',
  imports: [ CommonModule ],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent {
  categorias = [
    { nome: 'Ação', descricao: 'Jogos de ação e aventura' },
    { nome: 'RPG', descricao: 'Jogos de RPG e fantasia' },
    { nome: 'Esportes', descricao: 'Jogos de esportes e simulação' }
  ];
}
