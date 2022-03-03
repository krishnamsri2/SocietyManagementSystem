export class ResetPasswordModel{
    constructor(private token : string, private newPassword : string,private emailId?: string){}
}