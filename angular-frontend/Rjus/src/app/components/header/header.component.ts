import { Component, OnInit } from '@angular/core';
import { Input,Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  @Output() hid = new EventEmitter<string>();
var=true;
  
url:any;
  add() {
    this.hid.emit("");
  }

  constructor() {
    this.url=window.location.href;
    console.log(this.url)
    
  
    
    this.hid.emit("");
   
   }

  ngOnInit(): void {
    
  }

}
