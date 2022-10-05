package by.bsu.lsebackend.dto

import by.bsu.lsebackend.entity.Role
import com.fasterxml.jackson.annotation.JsonProperty

class StudentResponse(
    firstName: String,
    lastName: String,
    email: String,
    faculty: String,
    @JsonProperty("group")
    val group: String,
    @JsonProperty("course")
    val course: Int,
) : UserResponse(firstName, lastName, email, faculty, Role.ROLE_STUDENT.name)
