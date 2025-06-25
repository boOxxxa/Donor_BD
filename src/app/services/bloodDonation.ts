import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Data } from '@angular/router';

export interface BloodDonation {
    id_donation: number;
    donation_date: string;
    id_point: Point;
    id_donor: Donor;
  }
export interface Point {
idPoint: number;
city: string;
address: string;
phone: string;
fioHeader: string;
}
export interface Donor {
    id_donor: number;
    id_person: Person;
    blood_type: string;
    rh_factor: string;
}
export interface Person {
    id_person: number;
    fio: string;
    gender: string;
  } 
@Injectable({
  providedIn: 'root'
})
export class BloodDonationService {
  private apiUrl = 'http://localhost:8080/api/blood-donations'; 

  constructor(private http: HttpClient) {}

  getAll(): Observable<BloodDonation[]> {
    return this.http.get<BloodDonation[]>(this.apiUrl);
  }

  getById(id: number): Observable<BloodDonation> {
    return this.http.get<BloodDonation>(`${this.apiUrl}/${id}`);
  }

  create(donor: BloodDonation): Observable<BloodDonation> {
    return this.http.post<BloodDonation>(this.apiUrl, donor);
  }

  update(id: number, donor: BloodDonation): Observable<void> {
    return this.http.put<void>(`${this.apiUrl}/${id}`, donor);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}