import { Injectable }                              from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { Observable }                              from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';

import { Message }                                 from './message/message.component';

@Injectable()
export class MessageService {

  private messagesUrl = 'http://localhost:8080/messages';

  constructor (private http: Http) {}

  postMessageToDB(username: string, message: string): Observable<Message>{
    let headers = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: headers });

    let tempMsg = new Message();
    tempMsg.username = username;
    tempMsg.message = message;
    let body = JSON.stringify(tempMsg);

    return this.http.post(this.messagesUrl, tempMsg, options)
                    .map(this.extractData)
                    .catch(this.handleError);
  }

  getLatestMessages(limit: number): Observable<Message[]>{
    let getParams = this.messagesUrl + '?limit=' + limit.toString();

    return this.http.get(getParams)
                    .map(this.extractData)
                    .catch(this.handleError);

  }

  private extractData(res: Response) {
    let body = res.json();
    return body;
  }

  private handleError (error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      const body = error.json() || '';
      const err = body.error || JSON.stringify(body);
      errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
