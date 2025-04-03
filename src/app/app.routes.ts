import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { PerfilComponent } from './pages/perfil/perfil.component';
import { InfoGameComponent } from './pages/info-game/info-game.component';
import { RankComponent } from './pages/rank/rank.component';
import { AdminComponent } from './pages/admin/admin.component';
import { RecomendedComponent } from './pages/recomended/recomended.component';
import { CategoryComponent } from './pages/category/category.component';
import { HelpComponent } from './pages/help/help.component';
import { DiscoverComponent } from './pages/discover/discover.component';
import { ConfigProfileComponent } from './pages/config-profile/config-profile.component';

export const routes: Routes = [
  { path: '', component: HomeComponent, title:'Home' },
  { path: 'info', component: InfoGameComponent, title:'Informações' },
  { path: 'rank', component: RankComponent, title:'Ranking' },
  { path: 'perfil', component: PerfilComponent, title:'Perfil' },
  { path: 'admin', component: AdminComponent, title:'Administração' },
  { path: 'ajuda', component: HelpComponent, title:'Ajuda/FAQ' },
  { path: 'categoria', component: CategoryComponent, title:'Categoria' },
  { path: 'recomendado', component: RecomendedComponent, title:'Recomendação' },
  { path: 'descoberta', component: DiscoverComponent, title:'Descoberta'},
  { path: 'config-perfil', component: ConfigProfileComponent, title:'ConfiguraçãoPerfil' }
];
