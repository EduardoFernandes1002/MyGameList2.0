import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-game-card',
  templateUrl: './game-card.component.html',
  styleUrls: ['./game-card.component.css'],
  imports: [CommonModule, RouterLink],
})
export class GameCardComponent {

  @Input() jogo: any;
  @Input() routerLink: string | any[] = '';
}
