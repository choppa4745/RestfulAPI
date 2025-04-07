package com.example.rest.mapper;


import com.example.rest.model.User;
import com.example.rest.web.model.request.UpsertUserRequest;
import com.example.rest.web.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserMapper {

    User upsertRequestToUser(UpsertUserRequest request);

    UserResponse userToResponse(User user);

}
