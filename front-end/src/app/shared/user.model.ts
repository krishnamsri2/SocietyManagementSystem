export class UserModel{

    private userId : string;
    private firstName : string;
	private lastName: string;
	private phoneNumber : number;
    private email : string;
    private roleType : string;
    private towerNumber : string;
    private flatNumber : number;

    constructor(userId : string, firstName : string, lastName : string, phoneNumber : number, email : string, roleType : string, towerNumber : string, flatNumber : number){
        this.userId=userId;
        this.firstName=firstName;
        this.lastName=lastName;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.roleType=roleType;
        this.towerNumber=towerNumber;
        this.flatNumber=flatNumber;
    }
}