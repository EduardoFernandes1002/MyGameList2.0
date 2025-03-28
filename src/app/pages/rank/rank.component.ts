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
  date: Date;
}

@Component({
  selector: 'app-rank',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './rank.component.html',
  styleUrls: ['./rank.component.css']
})
export class RankComponent implements OnInit {
  allGames: Game[] = [];
  filteredGames: Game[] = [];
  currentPage = 1;
  itemsPerPage = 20;
  searchQuery = '';
  selectedTab = 0;

  private readonly timeFilters = [
    { days: Infinity },   // All Time
    { days: 30 },         // Last Month
    { days: 7 }           // Last Week
  ];

  ngOnInit(): void {
    this.generateMockData();
    this.applyFilters();
  }

  private generateMockData(): void {
    const platforms = ['PC', 'PS5', 'XBOX'];
    const genres = ['Ação', 'Aventura', 'RPG'];
    
    this.allGames = Array.from({ length: 2000 }, (_, i) => {
      const randomDays = Math.floor(Math.random() * 365);
      return {
        id: `game-${i}`,
        name: `Jogo ${i + 1}`,
        score: Math.floor(Math.random() * 1000),
        image: 'https://via.placeholder.com/80',
        genre: genres[Math.floor(Math.random() * genres.length)],
        platform: platforms[Math.floor(Math.random() * platforms.length)],
        position: i + 1,
        date: new Date(Date.now() - randomDays * 24 * 60 * 60 * 1000)
      };
    });
  }

  applyFilters(): void {
    const filter = this.timeFilters[this.selectedTab];
    const cutoffDate = new Date();
    cutoffDate.setDate(cutoffDate.getDate() - filter.days);

    this.filteredGames = this.allGames
      .filter(game => filter.days === Infinity || game.date >= cutoffDate)
      .sort((a, b) => b.score - a.score)
      .map((game, index) => ({ ...game, position: index + 1 }));

    this.applySearch();
  }

  applySearch(): void {
    this.filteredGames = this.filteredGames.filter(game =>
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

  goToPage(page: number | string): void {
    if (typeof page !== 'number') return;
    
    if (page >= 1 && page <= this.totalPages) {
      this.currentPage = page;
    }
  }

  get pages(): (number | string)[] {
    const total = this.totalPages;
    const current = this.currentPage;
    const delta = 2;
    const range: (number | string)[] = [];

    if (total <= 7) {
      return Array.from({ length: total }, (_, i) => i + 1);
    }

    range.push(1);

    let start = Math.max(2, current - delta);
    let end = Math.min(total - 1, current + delta);

    if (current - 1 <= delta) {
      end = 1 + (delta * 2);
    }

    if ((total - current) <= delta) {
      start = total - (delta * 2);
    }

    if (start > 2) range.push('...');
    
    for (let i = start; i <= end; i++) {
      if (i > 1 && i < total) range.push(i);
    }

    if (end < total - 1) range.push('...');
    
    range.push(total);

    return range;
  }

  onTabChange(tab: number): void {
    this.selectedTab = tab;
    this.applyFilters();
  }
}