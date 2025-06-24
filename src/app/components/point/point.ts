import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Point, PointService } from '../../services/point.service';

@Component({
  selector: 'app-point',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './point.html'
})
export class PointComponent {
  points: Point[] = [];
  newPoint: Point = {
    idPoint: 0,
    city: '',
    address: '',
    phone: '',
    fioHeader: ''
  };

  constructor(private pointService: PointService) {
    this.loadPoints();
  }

  loadPoints() {
    this.pointService.getAll().subscribe(data => this.points = data);
  }

  addPoint() {
    this.pointService.create(this.newPoint).subscribe(() => {
      this.loadPoints();
      this.newPoint = { idPoint: 0, city: '', address: '', phone: '', fioHeader: '' };
    });
  }

  deletePoint(id: number) {
    this.pointService.delete(id).subscribe(() => this.loadPoints());
  }
}