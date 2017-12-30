import { Component, OnInit } from '@angular/core';

import { MessageService }    from './message.service';
import { Message }           from './message/message.component';

import 'rxjs/add/operator/finally';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  username: string;
  message: string;
  isUsernameGiven: boolean = false;
  isMessageListReceived: boolean = false;
  returnedMessage: Message;
  limit: number = 10;

  latestMessages: Message[];

  constructor(private messageService: MessageService) { }

  ngOnInit() {
    this.messageService.getLatestMessages(this.limit)
                         .subscribe(messages => this.latestMessages = messages);
    this.isMessageListReceived = true;
  }

  getUsername(newUser: string){
    if(newUser){
      this.username = newUser;
      this.isUsernameGiven = true;
    }
  }

  sendNewMessage(newMessage: string){
    if(newMessage){
      this.message = newMessage;
      this.messageService.postMessageToDB(this.username, newMessage).finally(() => this.messageService.getLatestMessages(this.limit).subscribe(messages => this.latestMessages = messages))
                         .subscribe(message  => this.returnedMessage = message);
     // this.messageService.getLatestMessages(this.limit)
                        // .subscribe(messages => this.latestMessages = messages);
    }
  }

}
