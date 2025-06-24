import { Component, OnInit } from '@angular/core';
import { TagService } from '../../../service/tag/tag.service'; 
import { FormBuilder, FormGroup, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { JogoService } from '../../../service/jogo-service/jogo.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css'],
  imports: [ FormsModule, CommonModule ],
})
export class AdminComponent implements OnInit {
  // Variáveis para o autocomplete de gêneros
  selectedTags: string[] = [];
  allGeneros: any[] = [];
  filteredGeneros: any[] = [];

  // Formulário do jogo
  jogoForm: FormGroup;
  jogos: any[] = [];
  usuarios: any[] = [];

  constructor(
    private jogoService: JogoService,
    private fb: FormBuilder
  ) {
    this.jogoForm = this.fb.group({
      distribuidora: [''],
      desenvolvedora: [''],
      nomeJogo: [''],
      sinopse: [''],
      dataLancamento: [''],
      modoJogo: [''],
      generos: [[]]
    });
  }
  ngOnInit(): void {
    this.loadAllJogos()
  }

  loadAllJogos(): void {
    this.jogoService.getJogos().subscribe({
      next: (data: any) => {
        this.jogos = data.content || data;
        
      },
      error: (error: any) => {
        console.error('Erro ao carregar top 5:', error);
      }
    });
  }




  removeTag(tag: string): void {
    this.selectedTags = this.selectedTags.filter(t => t !== tag);
    this.jogoForm.get('generos')?.setValue(this.selectedTags);
  }

  submitForm(): void {
    if (this.jogoForm.valid) {
      const formData = this.jogoForm.value;
      console.log('Dados do jogo:', formData);
      // Aqui você faria a chamada para salvar o jogo
      // this.http.post('/api/jogos', formData).subscribe(...);
    }
  }
}