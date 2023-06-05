import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SideNavRightComponent } from '../components/side-nav-right/side-nav-right.component';
@Injectable({
  providedIn: 'root'
})

export class CartService {
  l:any;

  constructor(private http:HttpClient) { }
getCart(){
  return this.http.get("http://localhost:8080/get-cart-courses/1");
}

requestToAddToCart(courseId:number,studentId:number)
{
  return this.http.get("http://localhost:8080/add-course-to-cart/1/"+courseId).subscribe((data)=>{
    document.location.reload();
  });

}

}
