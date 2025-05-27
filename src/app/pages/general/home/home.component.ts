import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { GeralService } from '../../../service/geral/geral.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [ CommonModule,FormsModule ],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent implements OnInit {

    jogos: any[] = [];


  constructor(private geralService: GeralService) {}

  recommendedGames = [
    { nomeJogo: 'Jogo 1', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', generos: 'Ação', plataformas: 'PC' },
    { nomeJogo: 'Jogo 2', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', generos: 'RPG', plataformas: 'PS5' },
    { nomeJogo: 'Jogo 3', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', generos: 'Aventura', plataformas: 'XBOX' },
    { nomeJogo: 'Jogo 4', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', generos: 'Ação', plataformas: 'PC' },
    { nomeJogo: 'Jogo 5', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', generos: 'RPG', plataformas: 'PS5' },
    { nomeJogo: 'Jogo 6', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', generos: 'Aventura', plataformas: 'XBOX' },
  ];

  chunkedRecommendedGames: any[] = [];

  loadTopFive(): void {
    this.geralService.getTop5Jogos().subscribe({
      next: (data: any) => {
        this.jogos = data.content;
      },
      error: (error: any) => {
        console.error('Erro ao carregar comentários:', error);
      }
    });
  }

  highestRatedGames = [
    { nomeJogo: 'Jogo 1', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', totalNotaJogo: 1000, generos: 'Ação' },
    { nomeJogo: 'Jogo 2', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', totalNotaJogo: 980, generos: 'RPG' },
    { nomeJogo: 'Jogo 3', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', totalNotaJogo: 970, generos: 'Aventura' },
    { nomeJogo: 'Jogo 4', imagemJogo: 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsy9m0IvPtLGV4EljpImDbmJWFuLFfG4PtZQ&s', totalNotaJogo: 960, generos: 'Ação' },
  ];
  ngOnInit(): void {
    this.loadTopFive();
  }

  private chunkArray(array: any[], chunkSize: number): any[] {
    const chunks = [];
    for (let i = 0; i < array.length; i += chunkSize) {
      chunks.push(array.slice(i, i + chunkSize));
    }
    return chunks;
  }
}

