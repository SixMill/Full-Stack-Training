import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class Message implements OnInit {

  username: string;
  message: string;
  postedAt: string;

  constructor() { }

  ngOnInit() {
  }

}
