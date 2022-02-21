export class UserModel{

    public userDetailId : number;
    public firstName : string;
	public lastName: string;
	public phoneNumber : number;
    public emailId : string;
    public towerNumber? : string;
    public flatNumber? : string;

    constructor(userDetailId : number, firstName : string, lastName : string, phoneNumber : string, emailId : string,
    towerNumber? : string, flatNumber? : string)
    {
        this.userDetailId=userDetailId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=+phoneNumber;
        this.emailId=emailId;
        this.towerNumber=towerNumber;
        this.flatNumber=flatNumber;
    }

    
}