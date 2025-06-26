import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Point {
  id_point: number;
  city: string;
  address: string;
  phone: string;
  fioHeader: string;
}

@Injectable({
  providedIn: 'root'
})
export class PointService {
  private apiUrl = 'http://localhost:8080/api/points';

  constructor(private http: HttpClient) {}

  getAll(): Observable<Point[]> {
    return this.http.get<Point[]>(this.apiUrl);
  }

  create(point: Point): Observable<Point> {
    return this.http.post<Point>(this.apiUrl, point);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
  update(id: number, point: Point): Observable<Point> {
    return this.http.put<Point>(`${this.apiUrl}/${id}`, point);
  }
}