import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Donor {
    id_donor: number;
    id_person: Person;
    blood_type: string;
    rh_factor: string;
  }
  export interface Person{
    id_person: number;
    fio: string;
    gender: string;
  }
@Injectable({
  providedIn: 'root'
})
export class DonorService {
  private apiUrl = 'http://localhost:8080/api/donors'; 

  constructor(private http: HttpClient) {}

  getAll(): Observable<Donor[]> {
    return this.http.get<Donor[]>(this.apiUrl);
  }

  getById(id: number): Observable<Donor> {
    return this.http.get<Donor>(`${this.apiUrl}/${id}`);
  }

  create(donor: Donor): Observable<Donor> {
    return this.http.post<Donor>(this.apiUrl, donor);
  }

  update(id: number, donor: Donor): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, donor);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}