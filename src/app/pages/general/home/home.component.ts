import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ CommonModule ],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {
  recommendedGames = [
    { name: 'Jogo 1', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', genre: 'Ação', platform: 'PC' },
    { name: 'Jogo 2', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', genre: 'RPG', platform: 'PS5' },
    { name: 'Jogo 3', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', genre: 'Aventura', platform: 'XBOX' },
    { name: 'Jogo 4', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', genre: 'Ação', platform: 'PC' },
    { name: 'Jogo 5', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', genre: 'RPG', platform: 'PS5' },
    { name: 'Jogo 6', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', genre: 'Aventura', platform: 'XBOX' },
  ];

  chunkedRecommendedGames: any[] = [];

  topRankedGames = [
    { name: 'Jogo 1', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 950, platform: 'PC' },
    { name: 'Jogo 2', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 920, platform: 'PS5' },
    { name: 'Jogo 3', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 900, platform: 'XBOX' },
    { name: 'Jogo 4', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 880, platform: 'PC' },
    { name: 'Jogo 5', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 870, platform: 'PS5' },
    { name: 'Jogo 6', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 868, platform: 'PS3' },

  ];

  highestRatedGames = [
    { name: 'Jogo 1', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 1000, genre: 'Ação' },
    { name: 'Jogo 2', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 980, genre: 'RPG' },
    { name: 'Jogo 3', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 970, genre: 'Aventura' },
    { name: 'Jogo 4', image: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', score: 960, genre: 'Ação' },
  ];

  ngOnInit(): void {
    this.chunkedRecommendedGames = this.chunkArray(this.recommendedGames, 3);
  }

  private chunkArray(array: any[], chunkSize: number): any[] {
    const chunks = [];
    for (let i = 0; i < array.length; i += chunkSize) {
      chunks.push(array.slice(i, i + chunkSize));
    }
    return chunks;
  }
}

