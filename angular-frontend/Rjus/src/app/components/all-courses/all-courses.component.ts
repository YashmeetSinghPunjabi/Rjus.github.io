import { sanitizeIdentifier } from '@angular/compiler';
import { Component, OnInit,Input,Output, ViewEncapsulation } from '@angular/core';
import { from, startWith } from 'rxjs';
import {MatPaginatorIntl, MatPaginatorModule} from '@angular/material/paginator';
import { CourseService } from 'src/app/services/course.service';
import { CartService } from 'src/app/services/cart.service';


@Component({
  selector: 'app-all-courses',
  templateUrl: './all-courses.component.html',
  styleUrls: ['./all-courses.component.css'],

})
export class AllCoursesComponent implements OnInit {
i:any;
  l:any;
  m:any;x:any;

  addToCart(j:any)
  {
   
   this.cartService.requestToAddToCart(j.courseId,1)
  }
  sort(e:any){
    
    if(e.target.value==1)  
     {
      this.course.sortByLowToHigh().subscribe((data)=>{
        this.l=data;
       } )
     } 
      
    
     if(e.target.value==0)
     {
     this.course.sortByHighToLow().subscribe((data)=>{
      this.l=data;
     } )
      
     } 
    }
  searchBox(search:any)
  { 
    this.l=[];
    this.i=0;
    while(this.i<this.m.length)
{
if(this.m[this.i].name.startsWith(search.target.value))
{
  console.log(this.m[this.i])
  this.l.push(this.m[this.i]);
}
this.i++;
}

  }
  constructor(private course: CourseService,private cartService:CartService) { 
    course.getCourse().subscribe((data)=>{
      console.log(data);
      this.l=data;
      this.m=data;
      console.log(this.l)
    });
    


  }
  ngOnInit(): void
   {
   }
  

}
