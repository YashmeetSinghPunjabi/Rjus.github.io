import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpParams } from '@angular/common/http';
 

@Injectable({
  providedIn: 'root'
})
export class CourseService {
  constructor(private http: HttpClient) { 

  }
  getCourse()
  {

    return this.http.get("http://localhost:8080/get-courses");
    
  
  }
  sortByHighToLow()
  {
    return this.http.get("http://localhost:8080/sort-price-high-to-low");
  }
  sortByLowToHigh()
  {
    return this.http.get("http://localhost:8080/sort-price-low-to-high");
    
  }

}
