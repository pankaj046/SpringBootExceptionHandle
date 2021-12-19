package sharma.pankaj.fieldvalidationrestapi.model

import javax.validation.constraints.*

data class RequestModel(

    @NotEmpty(message = "First name is required")
    @Size(min = 2)
    var firstName: String?=null,
    @NotEmpty
    @Size(min = 2, message = "Last name is required")
    var lastName: String = "",
    @NotEmpty
    @Email
    var email: String = "",
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*_=+-]).{8,12}\$",
        message = "Invalid password")
    var password: String = "",
    @NotEmpty
    @Size(min = 10, message = "Invalid phone number")
    var phone: String = "",
    @Size(min = 13, message = "Age must be above or equal to 13")
    var age : Int = 0
){
    override fun toString(): String {
        return "RequestModel(firstName=$firstName, firstLast='$lastName', email='$email', password='$password', phone='$phone', age=$age)"
    }
}