import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-discover',
  imports: [CommonModule],
  templateUrl: './discover.component.html',
  styleUrl: './discover.component.css'
})
export class DiscoverComponent implements OnInit {
  allGames = Array.from({ length: 100 }, (_, i) => ({
    name: `Jogo ${i + 1}`,
    image: `https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s`,
    genre: ['Ação', 'RPG', 'Aventura'][Math.floor(Math.random() * 3)],
    platform: ['PC', 'PS5', 'XBOX'][Math.floor(Math.random() * 3)],
    votes: Math.floor(Math.random() * 1000),
  }));

  currentPage = 1;
  itemsPerPage = 12; // Número de jogos por página
  totalPages = Math.ceil(this.allGames.length / this.itemsPerPage);

  get currentPageGames() {
    const start = (this.currentPage - 1) * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    return this.allGames.slice(start, end);
  }

  get pages() {
    return Array.from({ length: this.totalPages }, (_, i) => i + 1);
  }

  goToPage(page: number) {
    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
    }
  }

  ngOnInit(): void {}
}
