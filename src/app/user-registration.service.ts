import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {

  constructor(private http:HttpClient) { }

public doRegister(user)
{
	return this.http.post("http://localhost:1111/save",user,{responseType:'text' as 'json'});
}

public getUsers()
{
	return this.http.get("http://localhost:1111/all");
}

public getUsersByEmail(email)
{
	return this.http.get("http://localhost:1111/findUser/"+email);
}

public deleteUser(id)
{
	return this.http.delete("http://localhost:1111/cancel/"+id);
}

}
