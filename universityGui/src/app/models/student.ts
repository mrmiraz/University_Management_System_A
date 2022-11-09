export class Student{
    id!:Number;
    firtName!:String;
    lastName!:String;
    phoneNumber1!:String;
    phoneNumber2!:String;
    email1!:String;
    email2!:String;
    gender!:String;
    address!:String;
    batch!:String;
    cgpa!:String;

    constructor(id:Number, firstName:String, lastName:String, phoneNumber1:String, phoneNumber2:String, email1:String, email2:String, gender:String, address:String, batch:String, cgpa:String){
        this.id = id;
        this.firtName=firstName;
        this.lastName = lastName;
        this.phoneNumber1=phoneNumber1;
        this.phoneNumber2=phoneNumber2;
        this.email1 = email1;
        this.email2 = email2;
        this.gender = gender;
        this.address = address;
        this.batch = batch;
        this.cgpa = cgpa;
    }

}