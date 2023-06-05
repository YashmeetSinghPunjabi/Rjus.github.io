import { getRtlScrollAxisType } from '@angular/cdk/platform';
import { Component, OnInit,Input } from '@angular/core';
import { subscribeOn } from 'rxjs';
import { CartService } from 'src/app/services/cart.service';


@Component({
  selector: 'app-side-nav-right',
  templateUrl: './side-nav-right.component.html',
  styleUrls: ['./side-nav-right.component.css']
})
export class SideNavRightComponent implements OnInit {
  part=['1','2'];
  a:any;
  i:any;
  hid="";
  totalCartValue=0;
  constructor(private cart:CartService) {
    
    cart.getCart().subscribe((data)=>{
      this.a=data;
      console.log(this.a)
   
    })
    console.log(this.a);
   
    

   }

  ngOnInit(): void {
  }

}
