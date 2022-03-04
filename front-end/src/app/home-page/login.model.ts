export class LoginModel{
    private password: string;
    private emailId: string;
    private userId? :number;
    public firstName? : string;
    public lastName? : string;
    public societyId? : number;

    constructor(emailId:string, password : string, userId? : number,firstName? : string,lastName? : string, societyId? : number){
        this.emailId=emailId;
        this.password=password;
        this.userId=userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.societyId=societyId;
    }
}