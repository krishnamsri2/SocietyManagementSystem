export class ChangePasswordModel{
    constructor(private emailId:string,private oldPassword:string,private newPassword:string){}
}