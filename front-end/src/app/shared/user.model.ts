export class UserModel{

    public userDetailId? : number;
    public firstName : string;
	public lastName: string;
	public phoneNumber : number;
    public emailId : string;
    public societyId? : number;
    public societyName? : string;

    constructor(firstName : string, lastName : string, phoneNumber : number, emailId : string,userDetailId?: number,societyName?:string,societyId?:number)
    {
        this.userDetailId=userDetailId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=+phoneNumber;
        this.emailId=emailId;
        this.societyName=societyName;
        this.societyId=societyId;
    }


    
    
}