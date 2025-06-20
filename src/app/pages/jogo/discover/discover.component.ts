import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { DescobertaService } from '../../../service/descoberta-service/descoberta.service';

@Component({
  selector: 'app-discover',
  imports: [CommonModule],
  templateUrl: './discover.component.html',
  styleUrl: './discover.component.css',
})
export class DiscoverComponent implements OnInit {

  constructor(private descobertaService: DescobertaService) {}

  ngOnInit(): void {

  }

}
