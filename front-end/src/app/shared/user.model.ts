export class UserModel{

    public userDetailId? : number;
    public firstName : string;
	public lastName: string;
	public phoneNumber : number;
    public emailId : string;
    

    constructor(firstName : string, lastName : string, phoneNumber : string, emailId : string,userDetailId?: number)
    {
        this.userDetailId=userDetailId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=+phoneNumber;
        this.emailId=emailId;
    }

    
}