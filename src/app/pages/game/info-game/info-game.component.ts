import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
@Component({
  selector: 'app-info-game',
  imports: [CommonModule],
  templateUrl: './info-game.component.html',
  styleUrl: './info-game.component.css'
})
export class InfoGameComponent {
  jogo = {
    nome: 'Nome do Jogo',
    imagem: 'path/to/image.jpg',
    genero: 'Ação',
    plataforma: 'PC',
    sinopse: 'Descrição do jogo.',
    dataLancamento: new Date()
  };
}
