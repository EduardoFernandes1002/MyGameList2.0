import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-gamecard',
  imports: [CommonModule, ],
  templateUrl: './gamecard.component.html',
  styleUrl: './gamecard.component.css'
})
export class GamecardComponent {
  jogo: any = '';

}
