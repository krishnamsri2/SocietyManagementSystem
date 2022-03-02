export class UserModel{

    public userDetailId? : number;
    public firstName : string;
	public lastName: string;
	public phoneNumber : number;
    public emailId : string;
    public societyId? : number;

    constructor(firstName : string, lastName : string, phoneNumber : number, emailId : string,userDetailId?: number, societyId?:number)
    {
        this.userDetailId=userDetailId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=+phoneNumber;
        this.emailId=emailId;
        this.societyId=societyId;
    }


    
    
}