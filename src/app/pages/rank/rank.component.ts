// rank.component.ts
import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-rank',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './rank.component.html'
})
export class RankComponent {
  searchQuery = '';
  selectedTab = 0;

  currentRanking = [
    {
      position: 1,
      name: 'Cyber Quest',
      score: 9500,
      image: '/assets/game1.jpg', // Caminho para sua imagem
      genre: 'RPG',
      platform: 'PC/PS5'
    },
    // ... outros itens
  ];
}