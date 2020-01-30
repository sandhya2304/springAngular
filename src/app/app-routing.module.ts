import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SearchDeleteComponent } from './search-delete/search-delete.component';
import { RegistrationComponent } from  './registration/registration.component';
import { HomeComponent } from './home/home.component';


const routes: Routes = [

 { path: "", redirectTo:"home",pathMatch:"full" },
  { path:"home",component: HomeComponent},
 { path:"save",component: RegistrationComponent},
 { path:"search",component: SearchDeleteComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
