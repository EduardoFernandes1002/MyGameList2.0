import { Component, OnInit } from '@angular/core';
import { TagService } from '../../../service/tag/tag.service'; 
import { FormBuilder, FormGroup, FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

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
  tagInput = '';
  showSuggestions = false;

  // Formulário do jogo
  jogoForm: FormGroup;
jogos: any;

  constructor(
    private TagService: TagService,
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
    this.carregarGeneros();
  }

  carregarGeneros(): void {
    this.TagService.getGeneros().subscribe({
      next: (generos) => {
        this.allGeneros = generos;
      },
      error: (err) => {
        console.error('Erro ao carregar gêneros:', err);
      }
    });
  }

  searchTags(): void {
    if (this.tagInput.length > 0) {
      this.TagService.searchGeneros(this.tagInput).subscribe({
        next: (generos) => {
          this.filteredGeneros = generos
            .map(g => g.nomeGenero)
            .filter(g => !this.selectedTags.includes(g));
          this.showSuggestions = true;
        },
        error: (err) => {
          console.error('Erro na busca:', err);
        }
      });
    } else {
      this.filteredGeneros = [];
      this.showSuggestions = false;
    }
  }

  addTag(tag: string): void {
    if (!this.selectedTags.includes(tag)) {
      this.selectedTags.push(tag);
      this.jogoForm.get('generos')?.setValue(this.selectedTags);
      this.tagInput = '';
      this.showSuggestions = false;
    }
  }

  addTagFromInput(): void {
    if (this.tagInput.trim() && !this.selectedTags.includes(this.tagInput.trim())) {
      this.selectedTags.push(this.tagInput.trim());
      this.jogoForm.get('generos')?.setValue(this.selectedTags);
      this.tagInput = '';
    }
    this.showSuggestions = false;
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