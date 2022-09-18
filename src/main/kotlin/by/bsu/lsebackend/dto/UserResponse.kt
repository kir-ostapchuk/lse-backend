package by.bsu.lsebackend.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class UserResponse(
    @JsonProperty("firstName")
    val firstName: String,

    @JsonProperty("lastName")
    val lastName: String,

    @JsonProperty("email")
    val email: String,

    @JsonProperty("faculty")
    val faculty: String,

    @JsonProperty("group")
    val group: String,
)
