import { CanActivateFn, Router } from '@angular/router';
import { AuthService } from '../../service/auth/auth.service';
import { inject } from '@angular/core';


export const authGuard: CanActivateFn = (route, state) => {
  const authService = inject(AuthService);
  const router = inject(Router);  

  // Se o token não exista
  if (!authService.getToken()) {
    router.navigate(['/login']);
    return false;
    
  } 
  return true;

};

export const notAuthGuard: CanActivateFn = () => {
  const authService = inject(AuthService);
  const router = inject(Router);

  if (authService.isAuthenticated()) {
    router.navigate(['/']);
    return false;
  }

  return true;
};