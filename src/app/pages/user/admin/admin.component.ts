import { Component, EventEmitter, Input, Output } from '@angular/core';
import { TagService } from '../../../service/tag/tag.service';
import { FormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin',
  imports: [CommonModule, FormsModule],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  
  @Input() selectedTags: string[] = [];
  @Output() tagsChanged = new EventEmitter<string[]>();
  
  tagInput = '';
  allTags: string[] = []; // Todas as tags disponíveis
  filteredTags: string[] = []; // Tags filtradas pela busca
  showSuggestions = false;

  constructor(private tagService: TagService) {}

  ngOnInit() {
    this.loadAllTags();
  }

  loadAllTags() {
    this.tagService.getAllTags().subscribe(tags => {
      this.allTags = tags;
    });
  }

  searchTags() {
    if (this.tagInput.length > 0) {
      this.filteredTags = this.allTags.filter(tag => 
        tag.toLowerCase().includes(this.tagInput.toLowerCase()) &&
        !this.selectedTags.includes(tag)
      );
      this.showSuggestions = true;
    } else {
      this.filteredTags = [];
      this.showSuggestions = false;
    }
  }

  addTag(tag: string) {
    if (!this.selectedTags.includes(tag)) {
      this.selectedTags.push(tag);
      this.tagsChanged.emit(this.selectedTags);
      this.tagInput = '';
      this.showSuggestions = false;
    }
  }

  addTagFromInput() {
    if (this.tagInput.trim() && !this.selectedTags.includes(this.tagInput.trim())) {
      this.selectedTags.push(this.tagInput.trim());
      this.tagsChanged.emit(this.selectedTags);
      this.tagInput = '';
    }
    this.showSuggestions = false;
  }

  removeTag(tag: string) {
    this.selectedTags = this.selectedTags.filter(t => t !== tag);
    this.tagsChanged.emit(this.selectedTags);
  }
}
