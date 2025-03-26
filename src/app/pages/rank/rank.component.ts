import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

interface Game {
  id: string;
  name: string;
  score: number;
  image: string;
  genre: string;
  platform: string;
  position: number;
}

@Component({
  selector: 'app-rank',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './rank.component.html',
  styleUrls: ['./rank.component.css']
})
export class RankComponent implements OnInit {
  rankings: { [key: number]: Game[] } = { 0: [], 1: [], 2: [] };
  filteredGames: Game[] = [];
  currentPage = 1;
  itemsPerPage = 20;
  searchQuery = '';
  selectedTab = 0;

  ngOnInit(): void {
    this.generateMockData();
    this.loadTabData();
  }

  private generateMockData(): void {
    [0, 1, 2].forEach(tab => {
      this.rankings[tab] = Array.from({ length: 50 }, (_, i) => ({
        id: `game-${tab}-${i}`,
        name: `Jogo ${i + 1} (Aba ${tab})`,
        score: Math.floor(Math.random() * 1000),
        image: 'C:\Users\LAB INFO CEDUP 08\Documents\Eduardo-info24\MyGameList2.0\public\favicon.ico',
        genre: ['Ação', 'Aventura', 'RPG'][Math.floor(Math.random() * 3)],
        platform: ['PC', 'PS5', 'XBOX'][Math.floor(Math.random() * 3)],
        position: i + 1
      }));
    });
  }

  loadTabData(): void {
    this.filteredGames = [...this.rankings[this.selectedTab]];
    this.currentPage = 1;
    this.applySearch();
  }

  applySearch(): void {
    this.filteredGames = this.rankings[this.selectedTab].filter(game =>
      game.name.toLowerCase().includes(this.searchQuery.toLowerCase())
    );
    this.currentPage = 1;
  }

  get currentRanking(): Game[] {
    const start = (this.currentPage - 1) * this.itemsPerPage;
    const end = start + this.itemsPerPage;
    return this.filteredGames.slice(start, end);
  }

  get totalPages(): number {
    return Math.ceil(this.filteredGames.length / this.itemsPerPage);
  }

  goToPage(page: number): void {
    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
    }
  }

  get pages(): number[] {
    return Array.from({ length: this.totalPages }, (_, i) => i + 1);
  }

  onTabChange(tab: number): void {
    this.selectedTab = tab;
    this.loadTabData();
  }
}